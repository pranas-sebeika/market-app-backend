package sebeikapranas.backend.service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sebeikapranas.backend.entity.User;
import sebeikapranas.backend.entity.mapper.UserMapper;
import sebeikapranas.backend.repository.UserRepository;
import sebeikapranas.backend.service.dto.UserInDTO;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public void createUser(UserInDTO userInDTO) {
        if(isUsernameUnique(userInDTO.getUsername())){
            User newUser = userMapper.mapUserInDtoToUser(userInDTO);
            userRepository.save(newUser);
        } else {
            throw new EntityExistsException(String.format("User name: %s already exists", userInDTO.getUsername()));
        }
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findWithRolesByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    private boolean isUsernameUnique(String username) {
        return ! userRepository.findByUsername(username).isPresent();
    }
}

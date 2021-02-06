package sebeikapranas.backend.entity.mapper;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sebeikapranas.backend.entity.Role;
import sebeikapranas.backend.entity.User;
import sebeikapranas.backend.entity.constants.Roles;
import sebeikapranas.backend.service.RoleService;
import sebeikapranas.backend.service.dto.UserInDTO;

@Component
public class UserMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    RoleService roleService;

    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User mapUserInDtoToUser(UserInDTO dto) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName(Roles.ADMIN));

        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(roles)
                .isEnabled(true)
                .isLocked(false)
                .build();

        return user;
    }

}



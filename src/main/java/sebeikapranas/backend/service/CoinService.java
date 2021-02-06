package sebeikapranas.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sebeikapranas.backend.controller.dto.CoinInDTO;
import sebeikapranas.backend.entity.User;
import sebeikapranas.backend.repository.UserRepository;
import sebeikapranas.backend.service.dto.CoinsDTO;
import sebeikapranas.backend.entity.Coin;
import sebeikapranas.backend.entity.mapper.CoinMapper;
import sebeikapranas.backend.repository.CoinRepository;
import sebeikapranas.backend.service.dto.CoinOutDTO;

import static sebeikapranas.backend.entity.utils.UserUtils.getUsername;
import static sebeikapranas.backend.entity.utils.UserUtils.isAdmin;

@Service
public class CoinService {

    private final CoinRepository coinRepository;
    private final CoinMapper coinMapper;
    private final FileService fileService;
    private final UserService userService;
    private final UserRepository userRepository;

    public CoinService(CoinRepository coinRepository,
                       CoinMapper coinMapper,
                       FileService fileService,
                       UserService userService,
                       UserRepository userRepository) {
        this.coinRepository = coinRepository;
        this.coinMapper = coinMapper;
        this.fileService = fileService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public List<CoinsDTO> getAllCoins() {
        return coinRepository.findAll()
                .stream()
                .map(coinMapper::mapCoinToCoinsDTO)
                .collect(Collectors.toList());
    }

    public CoinOutDTO getCoin(long id) {
//        TODO create custom exception
        Coin coin = coinRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return coinMapper.mapCoinToCoinDTO(coin);
    }

    @Transactional
    public Long addCoin(MultipartFile obverse, MultipartFile reverse, CoinInDTO coinInDTO) {
        User owner = userService.loadUserByUsername(getUsername(SecurityContextHolder.getContext().getAuthentication()))   ;
        Coin coin = coinMapper.mapCoinInDtoToCoin(coinInDTO);
        coin.setObverse(fileService.storeFile(obverse));
        coin.setReverse(fileService.storeFile(reverse));
        coin.setOwner(owner);

        return coinRepository.save(coin).getId();

    }

    @Transactional
    public void deleteCoin(long coinId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(isAdmin(authentication)) {
            coinRepository.findById(coinId)
                    .ifPresentOrElse(coin -> coinRepository.deleteById(coin.getId()),
                            () -> new EntityNotFoundException("NOT FOUND"));
        } else {
            User user = userService.loadUserByUsername(getUsername(authentication));
            coinRepository.findByIdAndOwnerId(coinId, user.getId())
                    .ifPresentOrElse(coin -> coinRepository.deleteById(coin.getId()),
                            () -> new EntityNotFoundException("NOT FOUND"));
        }

    }

    public List<CoinsDTO> getAllUserCoins() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Long userId = userRepository.findByUsername(username).get().getId();

        return coinRepository.findAll()
                .stream()
                .filter(coin -> coin.getOwner().getId().equals(userId))
                .map(coinMapper::mapCoinToCoinsDTO)
                .collect(Collectors.toList());

    }
}

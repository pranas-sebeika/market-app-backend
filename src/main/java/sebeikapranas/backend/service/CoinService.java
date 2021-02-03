package sebeikapranas.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sebeikapranas.backend.controller.dto.CoinInDTO;
import sebeikapranas.backend.service.dto.CoinsDTO;
import sebeikapranas.backend.entity.Coin;
import sebeikapranas.backend.entity.mapper.CoinMapper;
import sebeikapranas.backend.repository.CoinRepository;
import sebeikapranas.backend.service.dto.CoinOutDTO;

@Service
public class CoinService {

    private CoinRepository coinRepository;
    private CoinMapper coinMapper;
    private FileService fileService;

    public CoinService(CoinRepository coinRepository, CoinMapper coinMapper, FileService fileService) {
        this.coinRepository = coinRepository;
        this.coinMapper = coinMapper;
        this.fileService = fileService;
    }

    public List<CoinsDTO> getAllCoins() {
        return coinRepository.findAll()
                .stream()
                .map(coin -> coinMapper.mapCoinToCoinsDTO(coin))
                .collect(Collectors.toList());
    }

    public CoinOutDTO getCoin(long id) {
//        TODO create custom exception
        Coin coin = coinRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return coinMapper.mapCoinToCoinDTO(coin);
    }

    @Transactional
    public Long addCoin(MultipartFile obverse, MultipartFile reverse, CoinInDTO coinInDTO) {

        Coin coin = coinMapper.mapCoinInDtoToCoin(coinInDTO);
        coin.setObverse(fileService.storeFile(obverse));
        coin.setReverse(fileService.storeFile(reverse));

        return coinRepository.save(coin).getId();

    }

    @Transactional
    public void deleteCoin(long id) {
        coinRepository.findById(id)
                .ifPresentOrElse(coin -> coinRepository.deleteById(coin.getId()),
                        () -> new EntityNotFoundException("NOT FOUND"));
    }
}

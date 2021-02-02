package sebeikapranas.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sebeikapranas.backend.service.dto.CoinsDTO;
import sebeikapranas.backend.entity.Coin;
import sebeikapranas.backend.entity.mapper.CoinMapper;
import sebeikapranas.backend.repository.CoinRepository;
import sebeikapranas.backend.service.dto.CoinOutDTO;

@Service
public class CoinService {

    private CoinRepository coinRepository;
    private CoinMapper coinMapper;

    public CoinService(CoinRepository coinRepository, CoinMapper coinMapper) {
        this.coinRepository = coinRepository;
        this.coinMapper = coinMapper;
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
}

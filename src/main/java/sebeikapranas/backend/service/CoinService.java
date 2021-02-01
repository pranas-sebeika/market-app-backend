package sebeikapranas.backend.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import sebeikapranas.backend.controller.dto.CoinsDTO;
import sebeikapranas.backend.entity.mapper.CoinMapper;
import sebeikapranas.backend.repository.CoinRepository;

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
}

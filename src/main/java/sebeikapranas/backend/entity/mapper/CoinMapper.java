package sebeikapranas.backend.entity.mapper;

import org.springframework.stereotype.Component;
import sebeikapranas.backend.controller.dto.CoinsDTO;
import sebeikapranas.backend.entity.Coin;

@Component
public class CoinMapper {

    public CoinsDTO mapCoinToCoinsDTO(Coin coin){
        return CoinsDTO.builder()
                .id(coin.getId())
                .obverse(coin.getObverse())
                .reverse(coin.getReverse())
                .title(coin.getTitle())
                .year(coin.getYear())
                .price(coin.getPrice())
                .build();
    }
}

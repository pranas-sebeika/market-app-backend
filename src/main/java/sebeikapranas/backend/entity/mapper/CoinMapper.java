package sebeikapranas.backend.entity.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import sebeikapranas.backend.controller.dto.CoinInDTO;
import sebeikapranas.backend.service.dto.CoinOutDTO;
import sebeikapranas.backend.service.dto.CoinsDTO;
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

    public CoinOutDTO mapCoinToCoinDTO(Coin coin) {
        return CoinOutDTO.builder()
                .condition(coin.getCondition())
                .description(coin.getDescription())
                .diameter(coin.getDiameter())
                .hallmark(coin.getHallmark())
                .metal(coin.getMetal())
                .mintage(coin.getMintage())
                .price(coin.getPrice())
                .obverse(coin.getObverse())
                .reverse(coin.getReverse())
                .telephone(coin.getTelephone())
                .title(coin.getTitle())
                .weight(coin.getWeight())
                .year(coin.getYear())
                .build();
    }

    public Coin mapCoinInDtoToCoin(CoinInDTO dto) {
        Coin coin = new Coin();
        BeanUtils.copyProperties(dto, coin);
        return coin;
    }
}

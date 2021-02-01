package sebeikapranas.backend.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sebeikapranas.backend.controller.dto.CoinsDTO;
import sebeikapranas.backend.service.CoinService;

@RestController

public class CoinController {

    private CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/coins")
    @ResponseStatus(HttpStatus.OK)
    public List<CoinsDTO> getAllCoins() {
        return coinService.getAllCoins();
    }


}

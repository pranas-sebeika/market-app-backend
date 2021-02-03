package sebeikapranas.backend.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sebeikapranas.backend.controller.dto.CoinInDTO;
import sebeikapranas.backend.service.dto.CoinOutDTO;
import sebeikapranas.backend.service.dto.CoinsDTO;
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

    @PostMapping(value = "/coin/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Long addCoin(
            @RequestParam(name = "obverse") MultipartFile obverse,
            @RequestParam(name = "reverse") MultipartFile reverse,
            @Valid CoinInDTO coinInDTO
    ) {

        return coinService.addCoin(obverse, reverse, coinInDTO);
    }

    @GetMapping(value = "/coins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CoinOutDTO getCoin(@PathVariable long id) {

        return coinService.getCoin(id);
    }

    @DeleteMapping(value = "/coins/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoin(@PathVariable long id) {

        coinService.deleteCoin(id);
    }


}

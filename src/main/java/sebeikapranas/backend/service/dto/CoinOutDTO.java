package sebeikapranas.backend.service.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinOutDTO {

    private String obverse;

    private String reverse;

    private String title;

    private String condition;

    private Integer mintage;

    private String metal;

    private Float hallmark;

    private Float weight;

    private Float diameter;

    private Integer year;

    private String description;

    private BigDecimal price;

    private String telephone;
}

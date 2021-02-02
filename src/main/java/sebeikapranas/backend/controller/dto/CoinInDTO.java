package sebeikapranas.backend.controller.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoinInDTO {

    @NotBlank
    private String title;

    private String condition;

    private Integer mintage;

    private String metal;

    private Float hallmark;

    @NotNull
    private Float weight;

    @NotNull
    private Float diameter;

    @NotNull
    private Integer year;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String telephone;

}

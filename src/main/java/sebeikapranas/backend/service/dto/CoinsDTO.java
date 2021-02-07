package sebeikapranas.backend.service.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinsDTO {

    @NotNull
    private Long id;

    @NotNull
    private Long owner;

    @NotBlank
    private String obverse;

    @NotBlank
    private String reverse;

    @NotBlank
    private String title;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer year;
}

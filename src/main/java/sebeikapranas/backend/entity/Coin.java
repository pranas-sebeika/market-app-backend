package sebeikapranas.backend.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;


@Entity
@Setter
@Getter
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String avers;

    @NotBlank
    private String reverse;

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

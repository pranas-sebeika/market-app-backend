package sebeikapranas.backend.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;


@Entity
@Setter
@Getter
@Table(name = "coin")
@NoArgsConstructor
@AllArgsConstructor
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="owner_id", referencedColumnName = "id", nullable=false)
    private User owner;

    @NotBlank
    @Column(name = "obverse")
    private String obverse;

    @NotBlank
    @Column(name = "reverse")
    private String reverse;

    @NotBlank
    @Column(name = "title")
    private String title;

    @Column(name = "coin_condition")
    private String condition;

    @Column(name = "mintage")
    private Integer mintage;

    @Column(name = "metal")
    private String metal;

    @Column(name = "hallmark")
    private Double hallmark;

    @NotNull
    @Column(name = "weight")
    private Double weight;

    @NotNull
    @Column(name = "diameter")
    private Double diameter;

    @NotNull
    @Column(name = "year")
    private Integer year;

    @NotBlank
    @Column(name = "description", length = 450)
    private String description;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @NotBlank
    @Column(name = "telephone")
    private String telephone;

}

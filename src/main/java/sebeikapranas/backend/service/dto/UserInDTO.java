package sebeikapranas.backend.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserInDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 3, max = 20)
    private String password;

    @NotBlank
    @Size(min = 3, max = 20)
    private String email;

}

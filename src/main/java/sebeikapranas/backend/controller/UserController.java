package sebeikapranas.backend.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sebeikapranas.backend.controller.dto.UserOutDTO;
import sebeikapranas.backend.entity.User;
import sebeikapranas.backend.service.UserService;
import sebeikapranas.backend.service.dto.UserInDTO;

@RestController
@Api(tags = "This controller is responsible for interaction with user object)")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserOutDTO login(@AuthenticationPrincipal User user) {
        return new UserOutDTO(user);
    }

    @PostMapping("user/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Validated UserInDTO userInDTO) {
        userService.createUser(userInDTO);

    }
}

package sebeikapranas.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sebeikapranas.backend.controller.dto.UserOutDTO;
import sebeikapranas.backend.entity.User;

@RestController
public class UserController {

    @PostMapping("/login")
    public UserOutDTO login(@AuthenticationPrincipal User user) {
        return new UserOutDTO(user);
    }

    @PostMapping("user/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserOutDTO userOutDTO) {

    }
}

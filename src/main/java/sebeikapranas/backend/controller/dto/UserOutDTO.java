package sebeikapranas.backend.controller.dto;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.Data;
import sebeikapranas.backend.entity.Role;
import sebeikapranas.backend.entity.User;

@Data
public class UserOutDTO {

    private Long id;
    private String username;
    private Set<String> roles;
    private String name;
    private String lastname;

    public UserOutDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles().stream()
                .map(Role::getType)
                .collect(Collectors.toSet());
        this.name = user.getName();
        this.lastname = user.getLastname();
    }
}

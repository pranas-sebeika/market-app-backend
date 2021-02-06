package sebeikapranas.backend.entity.utils;

import org.springframework.security.core.Authentication;

import static sebeikapranas.backend.security.SecurityConstants.ADMIN;

public class UserUtils {

    public static boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities()
                .stream()
                .anyMatch(role -> role.getAuthority().equalsIgnoreCase(ADMIN));
    }

    public static String getUsername (Authentication authentication) {
        return authentication.getPrincipal().toString();
    }


}

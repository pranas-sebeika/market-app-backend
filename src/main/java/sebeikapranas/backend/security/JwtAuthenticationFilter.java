package sebeikapranas.backend.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sebeikapranas.backend.entity.User;

import static sebeikapranas.backend.security.SecurityConstants.AUTHORIZATION_HEADER;
import static sebeikapranas.backend.security.SecurityConstants.AUTHORIZATION_HEADER_PREFIX;
import static sebeikapranas.backend.security.SecurityConstants.USERNAME;
import static sebeikapranas.backend.security.SecurityConstants.PASSWORD;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JwtProvider jwtProvider;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        super(authenticationManager);
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            Map<String, String> credentials = new ObjectMapper().readValue(request.getReader(), new TypeReference<>() {});

            return getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(credentials.get(USERNAME), credentials.get(PASSWORD)));

        } catch (Exception e) {
            throw new BadCredentialsException("Incorrect Credentials");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);

        User user = (User) authResult.getPrincipal();
        String jwtToken = jwtProvider.createToke(user);
        response.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER_PREFIX + jwtToken);

        chain.doFilter(request, response);

    }

}

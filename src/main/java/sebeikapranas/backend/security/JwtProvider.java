package sebeikapranas.backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import sebeikapranas.backend.entity.User;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Service
public class JwtProvider {

    @Value("${security.jwt.secret-key}")
    private byte[] secret;

    @Value("#{${security.jwt.expire-in-mins} * 60 * 1000}")
    private long validityInMillis;

    public String createToke(User user) {
        Date now = new Date();
        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(secret), SignatureAlgorithm.HS512)
                .setHeaderParam("type", "JWT")
                .setIssuer("market-api")
                .setAudience("market-front")
                .setIssuedAt(now)
                .setSubject(user.getUsername())
                .setExpiration(new Date(now.getTime() + validityInMillis))
                .claim("roles", user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .compact();
    }


    public Authentication getAuthentication(String jwt) {
        Jws<Claims> parsedJwt = Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(jwt);

        String username = parsedJwt.getBody().getSubject();

        List<GrantedAuthority> roles = ((List<String>) parsedJwt.getBody().get("roles")).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        if (isNotEmpty(username)) {
            return new UsernamePasswordAuthenticationToken(username,null, roles);
        }

        return null;
    }
}

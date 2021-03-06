package com.elements.elementscommon.config.security;

import com.elements.elementscommon.domain.user.User;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;


@Slf4j
@Component
public class JwtUtils {
    @Value("${elements.jwt.secret}")
    private String jwtSecret;
    @Value("${elements.jwt.expiration-ms}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        if (authentication.getPrincipal() instanceof User) {
            User userPrincipal = (User) authentication.getPrincipal();
            return Jwts.builder()
                    .setSubject(userPrincipal.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                    .signWith(HS512, jwtSecret)
                    .compact();
        }
        return null;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public Jwt getOauthJwt(String token) {
        var jwt = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
        return Jwt.withTokenValue(token)
                .headers(headers -> headers.putAll(jwt.getHeader()))
                .issuedAt(jwt.getBody().getIssuedAt().toInstant())
                .expiresAt(jwt.getBody().getExpiration().toInstant())
                .subject(jwt.getBody().getSubject())
                .build();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}

package com.elements.elementscommon.config.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;


@Slf4j
@RequiredArgsConstructor
public class JwtTokenDecoder implements JwtDecoder {
    private final JwtUtils jwtUtils;

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            if (token != null && jwtUtils.validateJwtToken(token)) {
                return jwtUtils.getOauthJwt(token);
            }
        } catch (Exception e) {
            log.error("Cannot set user authentication: {}", e.toString());
        }
        return null;
    }
}

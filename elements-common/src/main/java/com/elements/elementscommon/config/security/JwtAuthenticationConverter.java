package com.elements.elementscommon.config.security;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;


@RequiredArgsConstructor
public class JwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final UserDetailsService userDetailsService;

    @Override
    public AbstractAuthenticationToken convert(@NotNull Jwt jwt) {
        UserDetails user = userDetailsService.loadUserByUsername(jwt.getSubject());
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }
}

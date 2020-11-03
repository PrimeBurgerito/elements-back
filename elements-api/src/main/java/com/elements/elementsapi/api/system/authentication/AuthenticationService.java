package com.elements.elementsapi.api.system.authentication;

import com.elements.elementscommon.config.security.JwtUtils;
import com.elements.elementscommon.domain.authentication.JwtResponse;
import com.elements.elementscommon.domain.user.User;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public JwtResponse authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        new JWTClaimsSet.Builder().build();
        User userDetails = (User) authentication.getPrincipal();
        return JwtResponse.builder()
                .token(jwt)
                .id(userDetails.getId())
                .email(userDetails.getEmail())
                .username(userDetails.getUsername())
                .roles(userDetails.getRoleStrings())
                .build();
    }
}

package com.elements.elementscommon.domain.authentication;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class JwtResponse {
    private final String token;
    private final String type;
    private final String id;
    private final String username;
    private final String email;
    private final Collection<String> roles;
}

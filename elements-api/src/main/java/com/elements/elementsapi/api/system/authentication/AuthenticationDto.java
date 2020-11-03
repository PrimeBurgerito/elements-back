package com.elements.elementsapi.api.system.authentication;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class AuthenticationDto {
    @NotBlank String username;
    @NotBlank String password;
}

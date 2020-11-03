package com.elements.elementsapi.api.system.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;


@Data
@NoArgsConstructor
class UserDto {
    @NotBlank
    private String username;
    @NotBlank
    @JsonProperty(access = WRITE_ONLY)
    private String password;
    @Email
    private String email;
}

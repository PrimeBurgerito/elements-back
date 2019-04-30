package com.elements.elementsapi.api.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class UserDto {
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}

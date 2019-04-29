package com.elements.elementscommon.domain.userrole;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
public class UserRole implements GrantedAuthority {
    private RoleName name;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return name.toString();
    }
}

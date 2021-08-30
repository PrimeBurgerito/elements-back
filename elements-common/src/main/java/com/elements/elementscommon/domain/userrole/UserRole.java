package com.elements.elementscommon.domain.userrole;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import static com.elements.elementscommon.domain.userrole.RoleName.ROLE_USER;

@Data
public class UserRole implements GrantedAuthority {
    private static final long serialVersionUID = -7128159340756321573L;

    private RoleName name = ROLE_USER;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return name.toString();
    }
}

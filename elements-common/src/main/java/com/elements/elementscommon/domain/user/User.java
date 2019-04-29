package com.elements.elementscommon.domain.user;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndexed;
import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementscommon.domain.userrole.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Document
public class User extends DocumentBase implements UserDetails {

    @HashIndexed(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    private List<UserRole> roles;

    @JsonIgnore
    @Override
    public Collection<UserRole> getAuthorities() {
        return roles;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}

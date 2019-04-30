package com.elements.elementscommon.domain.user;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndexed;
import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementscommon.domain.userrole.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.singletonList;

@Data
@Document
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends DocumentBase implements UserDetails, Serializable {

    private static final long serialVersionUID = 8139057150294422099L;

    @NonNull
    @HashIndexed(unique = true)
    private String username;

    @NonNull
    @JsonIgnore
    private String password;

    private List<UserRole> roles = singletonList(new UserRole());

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

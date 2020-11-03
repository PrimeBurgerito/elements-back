package com.elements.elementscommon.domain.user;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementscommon.domain.userrole.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;

import java.beans.Transient;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

@Data
@Document
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends DocumentBase implements UserDetails {
    private static final long serialVersionUID = 7293177368898414377L;

    @NonNull
    @Indexed(unique = true)
    private String username;

    @NonNull
    @JsonIgnore
    private String password;

    @NonNull
    private String email;

    private List<UserRole> roles = singletonList(new UserRole());

    @JsonIgnore
    @Override
    public Collection<UserRole> getAuthorities() {
        return roles;
    }

    @JsonIgnore
    @Transient
    public Collection<String> getRoleStrings() {
        return roles.stream().map(UserRole::getAuthority).collect(toList());
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

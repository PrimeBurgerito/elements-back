package com.elements.elementscommon.service;

import com.elements.elementscommon.domain.user.User;
import com.elements.elementscommon.domain.user.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepository userRepository;

    @Override
    public User loadUserByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}

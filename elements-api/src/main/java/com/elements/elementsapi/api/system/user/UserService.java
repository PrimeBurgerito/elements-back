package com.elements.elementsapi.api.system.user;

import com.elements.elementscommon.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserDto create(UserDto userDto) {
        User user = userMapper.map(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.map(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public List<UserDto> find() {
        List<User> users = userRepository.findAll();
        return userMapper.map(users);
    }

    @Transactional(readOnly = true)
    public UserDto get(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return userMapper.map(user);
    }

    @Transactional(readOnly = true)
    public UserDto me() {
        Authentication authentication = getContext().getAuthentication();
        return userMapper.map((User) authentication.getPrincipal());
    }
}

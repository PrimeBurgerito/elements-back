package com.elements.elementsapi.api.user;

import com.elements.elementscommon.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return get(userName);
    }
}

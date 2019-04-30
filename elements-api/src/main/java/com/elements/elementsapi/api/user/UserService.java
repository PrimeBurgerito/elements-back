package com.elements.elementsapi.api.user;

import com.elements.elementscommon.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserDto create(UserDto userDto) {
        User user = userMapper.map(userDto);
        return userMapper.map(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public List<UserDto> find() {
        Collection<User> users = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(toList());
        return userMapper.map(users);
    }
}

package com.elements.elementsapi.api.system.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/create")
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping
    public List<UserDto> find() {
        return userService.find();
    }

    @GetMapping(value = "/{username}")
    public UserDto get(@PathVariable String username) {
        return userService.get(username);
    }

    @GetMapping(value = "/me")
    public UserDto me() {
        return userService.me();
    }
}

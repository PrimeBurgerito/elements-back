package com.elements.elementsapi.api.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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

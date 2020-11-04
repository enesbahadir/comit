package com.comit.controller;

import com.comit.model.User;
import com.comit.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User createUser (@RequestBody User newUser)
    {
        return userService.createUser(newUser);
    }
}

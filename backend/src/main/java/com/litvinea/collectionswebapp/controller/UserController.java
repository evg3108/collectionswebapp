package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

}

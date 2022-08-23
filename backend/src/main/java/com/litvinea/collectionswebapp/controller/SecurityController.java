package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.service.RegistrationService;
import com.litvinea.collectionswebapp.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {

    private final RegistrationService registrationService;

    public SecurityController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
    public User registerNewUser(String password, String username, BindingResult bindingResult){
        return registrationService.registerNewUser(password, username, bindingResult);
    }
}

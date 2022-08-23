package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.validator.UserRegistrationValidator;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class RegistrationService {

    private final UserService userService;
    private final UserRegistrationValidator registrationValidator;

    public RegistrationService(UserService userService, UserRegistrationValidator registrationValidator) {
        this.userService = userService;
        this.registrationValidator = registrationValidator;
    }

    public User registerNewUser(String password, String username, BindingResult bindingResult){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        registrationValidator.validate(user, bindingResult);
        if (!bindingResult.hasErrors()){
            return userService.saveNewUser(user);
        }
        return null;
    }

}

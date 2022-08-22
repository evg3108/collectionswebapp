package com.litvinea.collectionswebapp.validator;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.service.UserService;
import liquibase.repackaged.net.sf.jsqlparser.util.validation.ValidationUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserRegistrationValidator implements Validator {

    private final UserService userService;

    public UserRegistrationValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "");
        User user = (User) target;
        Optional<User> foundUser = userService.findUserByUsername(user.getUsername());
        if(foundUser.isEmpty()){
            errors.rejectValue("username", " ", "This username already taken!");
        }
    }
}

package com.litvinea.collectionswebapp.validator;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.service.UserSecurityDetailsService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserLoginValidator implements Validator {

    private final UserSecurityDetailsService userSecurityDetailsService;

    public UserLoginValidator(UserSecurityDetailsService userSecurityDetailsService) {
        this.userSecurityDetailsService = userSecurityDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "");
        User user = (User)target;
        UserDetails foundUser = userSecurityDetailsService.loadUserByUsername(user.getUsername());
        if(!foundUser.getPassword().equals(user.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        }
    }
}

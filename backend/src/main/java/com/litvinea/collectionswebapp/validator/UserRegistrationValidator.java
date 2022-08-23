package com.litvinea.collectionswebapp.validator;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserRegistrationValidator implements Validator {

    private final UserRepository userRepository;

    public UserRegistrationValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "");
        User user = (User) target;
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if(foundUser.isPresent()){
            errors.rejectValue("username", " ", "This username already taken!");
        }
    }
}

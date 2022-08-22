package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.repository.UserRepository;
import com.litvinea.collectionswebapp.validator.UserLoginValidator;
import com.litvinea.collectionswebapp.validator.UserRegistrationValidator;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRegistrationValidator userRegistrationValidator;
    private final UserLoginValidator userLoginValidator;


    public UserService(UserRepository userRepository, UserRegistrationValidator userValidator, UserLoginValidator userLoginValidator) {
        this.userRepository = userRepository;
        this.userRegistrationValidator = userValidator;
        this.userLoginValidator = userLoginValidator;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User registerNewUser(String password, String username, String email, BindingResult bindingResult){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        userRegistrationValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return null;
            //TODO
        }
        return userRepository.save(user);
    }

    public void logUserIn(String username, String password, BindingResult bindingResult){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userLoginValidator.validate(user, bindingResult);
        if(!bindingResult.hasErrors()){
            //TODO
        }
    }

    public boolean deleteUser(long id){
        Optional<User> userToDelete = userRepository.findById(id);
        if(userToDelete.isEmpty()){
            return false;
        } else {
            userRepository.delete(userToDelete.get());
            return true;
        }
    }


}

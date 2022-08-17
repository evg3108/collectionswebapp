package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserByUsername(String username){
        Optional<User> foundUser = userRepository.findByUsername(username);
        if(foundUser.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        } else {
            return foundUser.get();
        }
    }

    public User createNewUser(String password, String username, String email){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        return userRepository.save(user);
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

package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User registerNewUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(long id){
        userRepository.deleteById(id);
        }


}

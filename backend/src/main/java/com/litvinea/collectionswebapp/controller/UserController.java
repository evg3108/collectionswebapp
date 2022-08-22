package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUserById(@RequestParam("username") String username) {
        Optional<User> foundUser = userService.findUserByUsername(username);
        return foundUser.orElse(null);
    }

    @PostMapping("/signup")
    public User registerNewUser(@RequestBody UserRequestBody requestBody,
                                BindingResult bindingResult) {
        return userService.registerNewUser(requestBody.password, requestBody.username, requestBody.email, bindingResult);
    }

    @PostMapping("/login")
    public void login(String username,
                      String password,
                      BindingResult bindingResult){
        userService.logUserIn(username, password, bindingResult);
    }

    @DeleteMapping("/delete?{id}")
    public ResponseEntity<Void> deleteUserById(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(null);
    }


    public static class UserRequestBody {
        private String username;
        private String password;
        private String email;
    }

}

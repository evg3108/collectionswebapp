package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return userService.findUserByUsername(username);
    }

    @PostMapping("/create")
    public User createNewUser(@RequestBody UserRequestBody requestBody) {
        return userService.createNewUser(requestBody.password, requestBody.username, requestBody.email);
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

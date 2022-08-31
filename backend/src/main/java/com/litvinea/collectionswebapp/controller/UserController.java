package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.mapper.UserMapper;
import com.litvinea.collectionswebapp.service.UserService;
import org.openapitools.api.UserApi;
import org.openapitools.model.UserDataResponseDto;
import org.openapitools.model.UserRegistrationRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@RestController
public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<UserDataResponseDto> getUserById(String username) {
        Optional<User> user = userService.findUserByUsername(username);
        if(!user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't find user @" + username);
        }
        return ResponseEntity.ok(UserMapper.toDto(user.get()));
    }

    @Override
    public ResponseEntity<UserDataResponseDto> registerNewUser(UserRegistrationRequestDto userRegistrationRequestDto) {
        User user = UserMapper.toDto(userRegistrationRequestDto);
        userService.registerNewUser(user);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }
}

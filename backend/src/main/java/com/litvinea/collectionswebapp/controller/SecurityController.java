package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.User;
import com.litvinea.collectionswebapp.mapper.UserMapper;
import com.litvinea.collectionswebapp.service.RegistrationService;
import org.openapitools.api.AuthApi;
import org.openapitools.model.UserRegistrationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController implements AuthApi {

    private final RegistrationService registrationService;

    public SecurityController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public ResponseEntity<Void> registerNewUser(UserRegistrationRequestDto userRegistrationRequestDto) {
        User user = UserMapper.toDto(userRegistrationRequestDto);
        registrationService.registerNewUser(user);
        return ResponseEntity.ok(null);
    }
}

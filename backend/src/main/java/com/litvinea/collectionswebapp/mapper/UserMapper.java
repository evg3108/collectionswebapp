package com.litvinea.collectionswebapp.mapper;

import com.litvinea.collectionswebapp.entity.User;
import org.openapitools.model.UserDataResponseDto;
import org.openapitools.model.UserEditRequestDto;
import org.openapitools.model.UserRegistrationRequestDto;

public class UserMapper {

    public static User toEntity (UserEditRequestDto request){
        User user = new User();
        user.setUsername(request.getUsername());
        return user;
    }

    public static UserDataResponseDto toDto (User user){
        UserDataResponseDto userDto = new UserDataResponseDto();
        userDto.setUserId(user.getId());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public static User toDto (UserRegistrationRequestDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

}

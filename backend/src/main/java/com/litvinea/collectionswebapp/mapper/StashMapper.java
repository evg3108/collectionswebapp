package com.litvinea.collectionswebapp.mapper;

import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.entity.Topic;
import com.litvinea.collectionswebapp.entity.User;
import org.openapitools.model.AllStashesResponseDto;
import org.openapitools.model.StashCreateRequestDto;
import org.openapitools.model.StashEditRequestDto;
import org.openapitools.model.StashResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class StashMapper {

    public static Stash toEntity(StashCreateRequestDto request, Topic topic){
        Stash stash = new Stash();
        stash.setTitle(request.getTitle());
        stash.setTopic(topic);
        stash.setDescription(request.getDescription());
        User user = new User();
        user.setId(request.getUserId());
        stash.setUser(user);
        return stash;
    }

    public static Stash toEntity(StashEditRequestDto request, Topic topic){
        Stash stash = new Stash();
        stash.setTitle(request.getTitle());
        stash.setTopic(topic);
        stash.setDescription(request.getDescription());
        User user = new User();
        user.setId(request.getUserId());
        stash.setUser(user);
        return stash;
    }

    public static StashResponseDto toDto(Stash stash){
        StashResponseDto response = new StashResponseDto();
        response.setId(stash.getId());
        response.setTitle(stash.getTitle());
        response.setTopic(stash.getTopic().getTitle());
        response.setDescription(stash.getDescription());
        response.setUserId(stash.getUser().getId());
        return response;
    }

    public static AllStashesResponseDto toDto (List<Stash> stashes){
        AllStashesResponseDto response = new AllStashesResponseDto();
        response.setContent(stashes.stream().map(StashMapper::toDto).collect(Collectors.toList()));
        return response;
    }

}

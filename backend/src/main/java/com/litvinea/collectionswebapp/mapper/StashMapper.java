package com.litvinea.collectionswebapp.mapper;

import com.litvinea.collectionswebapp.entity.Stash;
import org.openapitools.model.AllStashesResponseDto;
import org.openapitools.model.StashRequestDto;
import org.openapitools.model.StashResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class StashMapper {

    public static Stash toEntity(StashRequestDto requestDto){
        Stash stash = new Stash();
        stash.setTitle(requestDto.getTitle());
        stash.setTopic(requestDto.getTopic());
        stash.setDescription(requestDto.getDescription());
        return stash;
    }

    public static StashResponseDto toDto(Stash stash){
        StashResponseDto response = new StashResponseDto();
        response.setTitle(stash.getTitle());
        response.setTopic(stash.getTopic());
        response.setDescription(stash.getDescription());
        return response;
    }

    public static AllStashesResponseDto toDto (List<Stash> stashes){
        AllStashesResponseDto response = new AllStashesResponseDto();
        response.setContent(stashes.stream().map(StashMapper::toDto).collect(Collectors.toList()));
        return response;
    }

}

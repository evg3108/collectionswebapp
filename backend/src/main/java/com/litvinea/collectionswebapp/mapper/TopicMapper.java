package com.litvinea.collectionswebapp.mapper;

import com.litvinea.collectionswebapp.entity.Topic;
import org.openapitools.model.AllTopicsResponseDto;
import org.openapitools.model.TopicResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class TopicMapper {

    public static TopicResponseDto toDto(Topic topic){
        TopicResponseDto response = new TopicResponseDto();
        response.setId(topic.getId());
        response.setTitle(topic.getTitle());
        return response;
    }

    public static AllTopicsResponseDto toDto(List<Topic> topics){
        AllTopicsResponseDto response = new AllTopicsResponseDto();
        response.setContent(topics.stream()
                .map(TopicMapper::toDto)
                .collect(Collectors.toList()));
        return response;
    }
}

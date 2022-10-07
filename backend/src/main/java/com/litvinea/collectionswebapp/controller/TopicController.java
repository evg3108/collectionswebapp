package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.Topic;
import com.litvinea.collectionswebapp.mapper.TopicMapper;
import com.litvinea.collectionswebapp.service.TopicService;
import org.openapitools.api.TopicApi;
import org.openapitools.model.AllTopicsResponseDto;
import org.openapitools.model.CreateNewTopicRequest;
import org.openapitools.model.EditTopicRequest;
import org.openapitools.model.TopicResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://127.0.0.1:8000/")
@RestController
public class TopicController implements TopicApi {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public ResponseEntity<TopicResponseDto> createNewTopic(CreateNewTopicRequest request) {
        Topic topic = topicService.createNewTopic(request.getTitle());
        return ResponseEntity.ok(TopicMapper.toDto(topic));
    }

    @Override
    public ResponseEntity<Void> deleteTopicById(Long id) {
        topicService.deleteTopicById(id);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<TopicResponseDto> editTopic(Long id, EditTopicRequest editTopicRequest) {
        Topic editedTopic = topicService.editTopicTitle(id, editTopicRequest.getTitle());
        return ResponseEntity.ok(TopicMapper.toDto(editedTopic));
    }

    @Override
    public ResponseEntity<AllTopicsResponseDto> findAll() {
        return ResponseEntity.ok(TopicMapper.toDto(topicService.findAll()));
    }
}

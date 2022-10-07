package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.entity.Topic;
import com.litvinea.collectionswebapp.mapper.StashMapper;
import com.litvinea.collectionswebapp.service.StashService;
import com.litvinea.collectionswebapp.service.TopicService;
import org.openapitools.api.StashApi;
import org.openapitools.model.AllStashesResponseDto;
import org.openapitools.model.StashCreateRequestDto;
import org.openapitools.model.StashEditRequestDto;
import org.openapitools.model.StashResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://127.0.0.1:8000/")
@RestController
public class StashController implements StashApi {

    private final StashService stashService;
    private final TopicService topicService;

    public StashController(StashService stashService, TopicService topicService) {
        this.stashService = stashService;
        this.topicService = topicService;
    }

    @Override
    public ResponseEntity<StashResponseDto> createNewStash(StashCreateRequestDto request) {
        Topic topic = topicService.getTopicById(request.getTopic());
        Stash stash = StashMapper.toEntity(request, topic);
        StashResponseDto response = StashMapper.toDto(stashService.createNewStash(stash));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteStashById(Long id) {
        stashService.deleteStashById(id);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<StashResponseDto> editStash(@RequestParam("id") Long id, StashEditRequestDto request) {
        Topic topic = topicService.getTopicById(request.getTopic());
        Stash stashToEdit = StashMapper.toEntity(request, topic);
        StashResponseDto response = StashMapper.toDto(stashService.editStash(id, stashToEdit));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<StashResponseDto> findStashById(Long id) {
        Optional<Stash> found = stashService.findById(id);
        if(!found.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No stash with id = " + id + " found");
        }
        StashResponseDto response = StashMapper.toDto(found.get());
        return ResponseEntity.ok(response);
    }


    @Override
    public ResponseEntity<AllStashesResponseDto> findAllByUserId(Long userId) {
        List<Stash> list = stashService.findAllByUserId(userId);
        return ResponseEntity.ok(StashMapper.toDto(list));
    }
}

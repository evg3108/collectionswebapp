package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.mapper.StashMapper;
import com.litvinea.collectionswebapp.service.StashService;
import org.openapitools.api.StashApi;
import org.openapitools.model.AllStashesResponseDto;
import org.openapitools.model.StashRequestDto;
import org.openapitools.model.StashResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class StashController implements StashApi {

    private final StashService stashService;

    public StashController(StashService stashService) {
        this.stashService = stashService;
    }

    @Override
    public ResponseEntity<StashResponseDto> createNewStash(StashRequestDto stashRequestDto) {
        Stash stash = StashMapper.toEntity(stashRequestDto);
        StashResponseDto response = StashMapper.toDto(stashService.createNewStash(stash));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteStashById(Long id) {
        stashService.deleteStashById(id);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<StashResponseDto> editStash(StashRequestDto request) {
        Stash stashToEdit = StashMapper.toEntity(request);
        StashResponseDto response = StashMapper.toDto(stashService.editStash(stashToEdit));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<StashResponseDto> findStashById(Long id) {
        Optional<Stash> found = stashService.findById(id);
        if(found.isEmpty()){
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

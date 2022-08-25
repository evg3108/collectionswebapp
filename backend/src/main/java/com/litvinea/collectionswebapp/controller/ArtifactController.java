package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.Artifact;
import com.litvinea.collectionswebapp.mapper.ArtifactMapper;
import com.litvinea.collectionswebapp.service.ArtifactService;
import org.openapitools.api.ArtifactApi;
import org.openapitools.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtifactController implements ArtifactApi {

    private final ArtifactService artifactService;

    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @Override
    public ResponseEntity<ArtifactResponseDto> createNewArtifact(ArtifactCreateRequestDto request) {
        Artifact newArtifact = ArtifactMapper.toEntity(request);
        ArtifactResponseDto response = ArtifactMapper.toDto(artifactService.createNewArtifact(newArtifact));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteArtifactById(Long id) {
        artifactService.deleteArtifactById(id);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ArtifactResponseDto> editArtifact(ArtifactEditRequestDto request) {
        Artifact artifactToEdit = ArtifactMapper.toEntity(request);
        ArtifactResponseDto response = ArtifactMapper.toDto(artifactService.editArtifact(artifactToEdit));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ArtifactResponseDto> findById(Long id) {
        ArtifactResponseDto response = ArtifactMapper.toDto(artifactService.findById(id));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<AllArtifactsResponseDto> findAllByStashId(Long stashId) {
        List<Artifact> list = artifactService.findAllByStashId(stashId);
        return ResponseEntity.ok(ArtifactMapper.toDto(list));
    }
}

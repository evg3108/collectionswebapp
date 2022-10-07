package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.Artifact;
import com.litvinea.collectionswebapp.entity.Tag;
import com.litvinea.collectionswebapp.mapper.ArtifactMapper;
import com.litvinea.collectionswebapp.service.ArtifactService;
import com.litvinea.collectionswebapp.service.TagService;
import org.openapitools.api.ArtifactApi;
import org.openapitools.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://127.0.0.1:8000/")
@RestController
public class ArtifactController implements ArtifactApi {

    private final ArtifactService artifactService;
    private final TagService tagService;

    public ArtifactController(ArtifactService artifactService, TagService tagService) {
        this.artifactService = artifactService;
        this.tagService = tagService;
    }

    @Override
    public ResponseEntity<ArtifactResponseDto> createNewArtifact(ArtifactCreateRequestDto request) {
        List<Tag> tags = tagService.getTags(request.getTags());
        Artifact newArtifact = ArtifactMapper.toEntity(request, tags);
        ArtifactResponseDto response = ArtifactMapper.toDto(artifactService.createNewArtifact(newArtifact));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ArtifactResponseDto> editArtifact(@RequestParam("id") Long id, ArtifactEditRequestDto request) {
        List<Tag> tags = tagService.getTags(request.getTags());
        Artifact artifactToEdit = ArtifactMapper.toEntity(id, request, tags);
        ArtifactResponseDto response = ArtifactMapper.toDto(artifactService.editArtifact(id, artifactToEdit));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteArtifactById(Long id) {
        artifactService.deleteArtifactById(id);
        return ResponseEntity.ok(null);
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

package com.litvinea.collectionswebapp.mapper;

import com.litvinea.collectionswebapp.entity.Artifact;
import com.litvinea.collectionswebapp.entity.Stash;
import org.openapitools.model.AllArtifactsResponseDto;
import org.openapitools.model.ArtifactCreateRequestDto;
import org.openapitools.model.ArtifactEditRequestDto;
import org.openapitools.model.ArtifactResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ArtifactMapper {

    public static Artifact toEntity (ArtifactCreateRequestDto request){
        Artifact artifact = new Artifact();
        artifact.setTitle(request.getTitle());
        Stash stash = new Stash();
        stash.setId(request.getStashId());
        artifact.setStash(stash);
        return artifact;
    }

    public static Artifact toEntity (ArtifactEditRequestDto request){
        Artifact artifact = new Artifact();
        artifact.setId(request.getId());
        artifact.setTitle(request.getTitle());
        Stash stash = new Stash();
        stash.setId(request.getStashId());
        artifact.setStash(stash);
        return artifact;
    }

    public static ArtifactResponseDto toDto (Artifact artifact){
        ArtifactResponseDto response = new ArtifactResponseDto();
        response.setTitle(artifact.getTitle());
        response.setStashId(artifact.getStash().getId());
        return response;
    }

    public static AllArtifactsResponseDto toDto (List<Artifact> artifacts){
        AllArtifactsResponseDto response = new AllArtifactsResponseDto();
        response.setContent(artifacts.stream().map(ArtifactMapper::toDto).collect(Collectors.toList()));
        return response;
    }

}

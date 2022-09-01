package com.litvinea.collectionswebapp.mapper;

import com.litvinea.collectionswebapp.entity.Artifact;
import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.entity.Tag;
import com.litvinea.collectionswebapp.repository.TagRepository;
import org.openapitools.model.AllArtifactsResponseDto;
import org.openapitools.model.ArtifactCreateRequestDto;
import org.openapitools.model.ArtifactEditRequestDto;
import org.openapitools.model.ArtifactResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ArtifactMapper {

    public static Artifact toEntity (ArtifactCreateRequestDto request, List<Tag> tags){
        Artifact artifact = new Artifact();
        artifact.setTitle(request.getTitle());
        Stash stash = new Stash();
        stash.setId(request.getStashId());
        artifact.setStash(stash);
        artifact.setTags(tags);
        return artifact;
    }

    public static Artifact toEntity (long id, ArtifactEditRequestDto request, List<Tag> tags){
        Artifact artifact = new Artifact();
        artifact.setId(id);
        artifact.setTitle(request.getTitle());
        Stash stash = new Stash();
        stash.setId(request.getStashId());
        artifact.setStash(stash);
        artifact.setTags(tags);
        return artifact;
    }

    public static ArtifactResponseDto toDto (Artifact artifact){
        ArtifactResponseDto response = new ArtifactResponseDto();
        response.setId(artifact.getId());
        response.setTitle(artifact.getTitle());
        response.setStashId(artifact.getStash().getId());
        response.setTags(artifact.getTags()
                .stream()
                .map(Tag::getTitle)
                .collect(Collectors.toList()));
        return response;
    }

    public static AllArtifactsResponseDto toDto (List<Artifact> artifacts){
        AllArtifactsResponseDto response = new AllArtifactsResponseDto();
        response.setContent(artifacts.stream().map(ArtifactMapper::toDto).collect(Collectors.toList()));
        return response;
    }

}

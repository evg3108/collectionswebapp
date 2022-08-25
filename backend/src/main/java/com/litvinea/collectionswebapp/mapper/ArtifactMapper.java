package com.litvinea.collectionswebapp.mapper;

import com.litvinea.collectionswebapp.entity.Artifact;
import org.openapitools.model.AllArtifactsResponseDto;
import org.openapitools.model.ArtifactRequestDto;
import org.openapitools.model.ArtifactResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ArtifactMapper {

    public static Artifact toEntity (ArtifactRequestDto dto){
        Artifact artifact = new Artifact();
        artifact.setTitle(dto.getTitle());
        return artifact;
    }

    public static ArtifactResponseDto toDto (Artifact artifact){
        ArtifactResponseDto responseDto = new ArtifactResponseDto();
        responseDto.setTitle(artifact.getTitle());
        return responseDto;
    }

    public static AllArtifactsResponseDto toDto (List<Artifact> artifacts){
        AllArtifactsResponseDto response = new AllArtifactsResponseDto();
        response.setContent(artifacts.stream().map(ArtifactMapper::toDto).collect(Collectors.toList()));
        return response;
    }

}

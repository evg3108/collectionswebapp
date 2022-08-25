package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.Artifact;
import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.mapper.ArtifactMapper;
import com.litvinea.collectionswebapp.repository.ArtifactRepository;
import com.litvinea.collectionswebapp.repository.StashRepository;
import org.openapitools.model.ArtifactRequestDto;
import org.openapitools.model.ArtifactResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtifactService {

    private final ArtifactRepository artifactRepository;
    private final StashRepository stashRepository;

    public ArtifactService(ArtifactRepository artifactRepository, StashRepository stashRepository) {
        this.artifactRepository = artifactRepository;
        this.stashRepository = stashRepository;
    }

    public List<Artifact> findAll(long stashId){
        return artifactRepository.findByStash(stashId);
    }

//    public Page<Artifact> findAllSorted(long stashId, int pageNumber, int itemsPerPage, String sortBy){
//        return artifactRepository.findAllByStashId(stashId, PageRequest.of(pageNumber, itemsPerPage, Sort.by(sortBy)));
//    }

//    public Page<Artifact> findAll(long stashId, int pageNumber, int itemsPerPage){
//        Page<Artifact> page = artifactRepository.findAllByStashId(stashId, PageRequest.of(pageNumber, itemsPerPage));
//        return page;
//    }

    public Artifact findById(long id){
        Optional<Artifact> found = artifactRepository.findById(id);
        if(found.isEmpty()){
            throw new NullPointerException("No user with id = " + id + " found!");
        }
        return found.get();
    }

    public List<Artifact> findAllByStashId(long stashId){
        Optional<Stash> stash = stashRepository.findById(stashId);
        return stash.isEmpty() ? null : stash.get().getArtifacts();
    }

    public ArtifactResponseDto createNewArtifact(ArtifactRequestDto requestDto){
        Artifact savedArtifact = artifactRepository.save(ArtifactMapper.toEntity(requestDto));
        return ArtifactMapper.toDto(savedArtifact);
    }

    public ArtifactResponseDto editArtifact(ArtifactRequestDto requestDto){
        Artifact editedArtifact = artifactRepository.save(ArtifactMapper.toEntity(requestDto));
        return ArtifactMapper.toDto(editedArtifact);
    }

    public void deleteArtifactById(long id){
        artifactRepository.deleteById(id);
    }

}

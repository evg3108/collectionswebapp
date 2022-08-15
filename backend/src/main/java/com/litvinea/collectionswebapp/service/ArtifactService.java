package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.Artifact;
import com.litvinea.collectionswebapp.repository.ArtifactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class ArtifactService {

    private ArtifactRepository artifactRepository;

    public List<Artifact> findAll(){
        return artifactRepository.findAll();
    }

    public Artifact findById(long id){
        Optional<Artifact> foundArtifact =  artifactRepository.findById(id);
        return foundArtifact.orElse(null);
    }

    public Artifact createNewArtifact(Artifact artifact){
        return artifactRepository.save(artifact);
    }

    public Artifact editArtifact(Artifact artifact){
        artifactRepository.save(artifact);
        return null;
    }

    public boolean deleteArtifactById(long id){
        artifactRepository.deleteById(id);
        return true;
    }

}

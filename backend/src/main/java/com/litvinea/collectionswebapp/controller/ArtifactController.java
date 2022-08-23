package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.Artifact;
import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.repository.ArtifactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artifacts")
public class ArtifactController {

    private ArtifactRepository artifactRepository;

    @GetMapping("/all")
    public List<Artifact> findAll(){
        return artifactRepository.findAll();
    }

    @GetMapping("{id}")
    public Artifact findById(@RequestParam("id") long id){
        Optional<Artifact> foundArtifact =  artifactRepository.findById(id);
        return foundArtifact.orElse(null);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewArtifact(Artifact artifact){
        artifactRepository.save(artifact);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteArtifactById(@RequestParam("id") long id){
        artifactRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}

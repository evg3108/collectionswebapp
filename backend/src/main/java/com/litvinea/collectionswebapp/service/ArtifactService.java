package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.Artifact;
import com.litvinea.collectionswebapp.repository.ArtifactRepository;
import com.litvinea.collectionswebapp.repository.StashRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtifactService {

    private final ArtifactRepository artifactRepository;

    public ArtifactService(ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;
    }

    public Artifact createNewArtifact(Artifact artifact){
        return artifactRepository.save(artifact);
    }

    public List<Artifact> findAllByStashId(long stashId){
        return artifactRepository.findByStashId(stashId);
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

    public Artifact editArtifact(Artifact artifact){
        return artifactRepository.save(artifact);
    }

    public void deleteArtifactById(long id){
        artifactRepository.deleteById(id);
    }

}

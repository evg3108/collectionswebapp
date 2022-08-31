package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.repository.StashRepository;
import com.litvinea.collectionswebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StashService {

    private final StashRepository stashRepository;
    private final UserRepository userRepository;

    public StashService(StashRepository stashRepository, UserRepository userRepository){
        this.stashRepository = stashRepository;
        this.userRepository = userRepository;
    }

    public List<Stash> findAllByUserId(long userId){
        return stashRepository.findByAppuserId(userId);
    }

    public Optional<Stash> findById(long id){
        return stashRepository.findById(id);
    }

    public Stash createNewStash(Stash stash){
        return stashRepository.save(stash);
    }

    public Stash editStash(long id, Stash editedStash){
        Optional<Stash> oldStash = stashRepository.findById(id);
        if(!oldStash.isPresent()){
            throw new IllegalArgumentException("No stash with id=" + id + " found");
        }
        Stash stashToSave = oldStash.get();
        stashToSave.setTitle(editedStash.getTitle());
        stashToSave.setTopic(editedStash.getTopic());
        stashToSave.setDescription(editedStash.getDescription());
        return stashRepository.save(stashToSave);
    }

    public void deleteStashById(long id){
        stashRepository.deleteById(id);
    }

}

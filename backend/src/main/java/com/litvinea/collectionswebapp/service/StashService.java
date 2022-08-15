package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.repository.StashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class StashService {

    @Autowired
    private StashRepository stashRepository;

    public StashService(StashRepository stashRepository){
        this.stashRepository = stashRepository;
    }

    /**
     * Gets full list of existing collections (stashes)
     * @return List<Stash>
     */
    public List<Stash> findAll(){
        return stashRepository.findAll();
    }

    /**
     * Gets Stash with requested id
     * @param id
     * @return Stash or null
     */

    public Stash findById(long id){
        Optional<Stash> foundStash =  stashRepository.findById(id);
        return foundStash.orElse(null);
    }

    /**
     * Adds new Stash with provided data to database
     * @param stash must not be {@literal null}
     * @return {@literal true} if or false
     */
    public boolean createNewStash(Stash stash){
        stashRepository.save(stash);
        return true;
    }

    /**
     * Edits the existing Stash with provided id
     * @param stash
     * @return the edited stash; will never be {@literal null}
     */
    public Stash editStash(Stash stash){
        return stashRepository.save(stash);
    }

    /**
     * Deletes Stash with provided id from database
     * @param id
     * @return true or false
     */
    public boolean deleteStashById(long id){
        stashRepository.deleteById(id);
        return true;
    }

}

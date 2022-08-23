package com.litvinea.collectionswebapp.controller;

import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.repository.StashRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stashes")
public class StashController {

    private StashRepository stashRepository;

    @GetMapping("/all")
    public List<Stash> findAll(){
        return stashRepository.findAll();
    }

    @GetMapping("{id}")
    public Stash findById(@RequestParam("id") long id){
        Optional<Stash> foundStash =  stashRepository.findById(id);
        return foundStash.orElse(null);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewStash(Stash stash){
        stashRepository.save(stash);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStashById(@RequestParam("id") long id){
        stashRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}

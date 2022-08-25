package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.Stash;
import com.litvinea.collectionswebapp.entity.User;
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
        return stashRepository.findByUser(userId);
    }

    public Optional<Stash> findById(long id){
        return stashRepository.findById(id);
    }

    public List<Stash> findAllByUser(String username){
        Optional<User> user = userRepository.findByUsername(username);
        return user.isEmpty() ? null : user.get().getStashes();
    }

    public Stash createNewStash(Stash stash){
        return stashRepository.save(stash);
    }

    public Stash editStash(Stash stash){
        return stashRepository.save(stash);
    }

    public void deleteStashById(long id){
        stashRepository.deleteById(id);
    }

}

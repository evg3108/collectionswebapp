package com.litvinea.collectionswebapp.repository;

import com.litvinea.collectionswebapp.entity.Stash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StashRepository extends JpaRepository<Stash, Long> {
    List<Stash> findByUserId(long user_id);
}

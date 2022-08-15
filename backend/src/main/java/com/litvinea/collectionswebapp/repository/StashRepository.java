package com.litvinea.collectionswebapp.repository;

import com.litvinea.collectionswebapp.entity.Stash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StashRepository extends JpaRepository<Stash, Long> {
}

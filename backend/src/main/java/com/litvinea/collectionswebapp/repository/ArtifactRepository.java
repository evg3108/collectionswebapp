package com.litvinea.collectionswebapp.repository;

import com.litvinea.collectionswebapp.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    List<Artifact> findByStashId(long stash_id);
}

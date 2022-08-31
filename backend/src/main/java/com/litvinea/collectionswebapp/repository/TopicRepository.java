package com.litvinea.collectionswebapp.repository;

import com.litvinea.collectionswebapp.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}

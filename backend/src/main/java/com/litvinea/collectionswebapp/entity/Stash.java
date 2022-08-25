package com.litvinea.collectionswebapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stash {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String topic;
    String description;
    @OneToMany
    List<Artifact> artifacts;
    @ManyToOne
    User user;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }
}

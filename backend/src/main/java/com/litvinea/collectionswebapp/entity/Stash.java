package com.litvinea.collectionswebapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stash {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;

    @ManyToOne(fetch = FetchType.LAZY)
    Topic topic;

    String description;

    @OneToMany(mappedBy = "stash", cascade = CascadeType.ALL)
    List<Artifact> artifacts;

    @ManyToOne(fetch = FetchType.LAZY)
    User appuser;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
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

    public User getUser() {
        return appuser;
    }

    public void setUser(User user) {
        this.appuser = user;
    }


}

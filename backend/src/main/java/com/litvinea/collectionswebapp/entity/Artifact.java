package com.litvinea.collectionswebapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artifact {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stash_id", nullable=false)
    Stash stash;

    @ManyToMany
    @JoinTable(
            name = "artifact_tag",
            joinColumns = { @JoinColumn(name = "artifact_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    List<Tag> tags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Stash getStash() {
        return stash;
    }

    public void setStash(Stash stash) {
        this.stash = stash;
    }
}

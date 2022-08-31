package com.litvinea.collectionswebapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;

    @OneToMany(mappedBy = "topic")
    List<Stash> stashes;

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

    public List<Stash> getStashes() {
        return stashes;
    }

    public void setStashes(List<Stash> stashes) {
        this.stashes = stashes;
    }
}

package com.litvinea.collectionswebapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artifact {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long artifactId;
    String title;
    @ManyToMany
    List<Tag> tags;
    @ManyToOne
    Stash stash;
}

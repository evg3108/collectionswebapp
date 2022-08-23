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
}

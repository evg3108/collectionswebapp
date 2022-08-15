package com.litvinea.collectionswebapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stash {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    @OneToMany
    List<Artifact> artifacts;
}

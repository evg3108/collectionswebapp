package com.litvinea.collectionswebapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity (name = "polzovatel")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    @OneToMany
    private List<Stash> stashes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Stash> getStashes() {
        return stashes;
    }

    public void setStashes(List<Stash> stashes) {
        this.stashes = stashes;
    }
}

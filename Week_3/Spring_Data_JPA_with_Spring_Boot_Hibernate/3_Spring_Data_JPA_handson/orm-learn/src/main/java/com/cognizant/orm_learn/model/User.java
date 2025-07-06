package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    private int usId;

    @Column(name = "us_name")
    private String name;

    @Column(name = "us_email")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Attempt> attempts;

    // Getters and Setters
    public int getUsId() { return usId; }
    public void setUsId(int usId) { this.usId = usId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Set<Attempt> getAttempts() { return attempts; }
    public void setAttempts(Set<Attempt> attempts) { this.attempts = attempts; }
}

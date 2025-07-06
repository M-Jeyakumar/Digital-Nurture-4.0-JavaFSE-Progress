package com.cognizant.orm_learn.model;
import jakarta.persistence.*;


import java.util.Set;


@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    private int atId;

    @Column(name = "at_date")
    private java.sql.Date date;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @Column(name = "at_score")
    private double score;

    @OneToMany(mappedBy = "attempt")
    private Set<AttemptQuestion> attemptQuestions;

    // Getters and Setters
    public int getAtId() { return atId; }
    public void setAtId(int atId) { this.atId = atId; }
    public java.sql.Date getDate() { return date; }
    public void setDate(java.sql.Date date) { this.date = date; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
    public Set<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) { this.attemptQuestions = attemptQuestions; }
}


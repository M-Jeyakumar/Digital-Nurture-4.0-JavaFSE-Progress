package com.cognizant.orm_learn.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "options")
public class Options {
    @Id
    private int opId;

    @ManyToOne
    @JoinColumn(name = "op_qt_id")
    private Question question;

    @Column(name = "op_score")
    private double score;

    @Column(name = "op_text")
    private String text;

    // Getters and Setters
    public int getOpId() { return opId; }
    public void setOpId(int opId) { this.opId = opId; }
    public Question getOpQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
    public double getOpScore() { return score; }
    public void setScore(double score) { this.score = score; }
    public String getOpText() { return text; }
    public void setText(String text) { this.text = text; }
}


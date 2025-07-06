package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "question")
public class Question {
    @Id
    private int qtId;

    @Column(name = "qt_text")
    private String text;

    @OneToMany(mappedBy = "question")
    private Set<Options> options;

    // Getters and Setters
    public int getQtId() { return qtId; }
    public void setQtId(int qtId) { this.qtId = qtId; }
    public String getQtText() { return text; }
    public void setText(String text) { this.text = text; }
    public Set<Options> getOptions() { return options; }
    public void setOptions(Set<Options> options) { this.options = options; }
}

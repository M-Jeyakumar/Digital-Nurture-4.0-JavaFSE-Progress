package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {
    @Id
    private int aoId;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    private Options option;

    @ManyToOne
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;

    @Column(name = "ao_selected")
    private boolean selected;

    // Getters and Setters
    public int getAoId() { return aoId; }
    public void setAoId(int aoId) { this.aoId = aoId; }
    public Options getOption() { return option; }
    public void setOption(Options option) { this.option = option; }
    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public void setAttemptQuestion(AttemptQuestion attemptQuestion) { this.attemptQuestion = attemptQuestion; }
    public boolean isAoSelected() { return selected; }
    public void setSelected(boolean selected) { this.selected = selected; }
}


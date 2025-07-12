package com.cognizant.spring_learn.model;


public class Skill {
    private int id;
    private String name;

    public Skill() {
        System.out.println("Inside Skill constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("Inside Skill setId");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Inside Skill setName");
    }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}

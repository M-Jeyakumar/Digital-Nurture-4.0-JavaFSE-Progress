package com.cognizant.spring_learn.model;

public class Department {
    private int id;
    private String name;

    public Department() {
        System.out.println("Inside Department constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        System.out.println("Inside Department setId");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Inside Department setName");
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}


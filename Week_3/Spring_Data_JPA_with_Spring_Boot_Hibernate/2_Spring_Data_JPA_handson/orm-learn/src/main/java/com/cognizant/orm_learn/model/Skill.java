package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    // Getters, Setters, toString()
    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}


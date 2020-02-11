package com.dinuras.RDBMS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects",cascade = CascadeType.ALL)
    List<Employee> employees;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

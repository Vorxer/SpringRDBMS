package com.dinuras.RDBMS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    Integer Number;

    public Telephone(Integer number) {
        Number = number;
    }

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Employee employee;

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}

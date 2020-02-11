package com.dinuras.RDBMS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.model.core.ID;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    private String Name;
    private String Location;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    List<Telephone> telephones;

    @ManyToOne()
    Address address;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "EmployeeProjects",
            joinColumns=
            @JoinColumn(name="emp_ID", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="prj_ID", referencedColumnName="ID")
    )
    List<Project> projects;



    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Employee(String name, String location) {
        Name = name;
        Location = location;
    }

    public int getID() {
        return ID;
    }

    public void setID(int employeeID) {
        ID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static List<Employee> getAllEmployees() {
        Employee Phoebe = new Employee("Phoebe", "Mars");
        Employee Ross = new Employee("Tim", "London");
        Employee Rachel = new Employee( "Ross","Paris");
        Employee Joey = new Employee("Joey","Italy");
        Employee Chandler = new Employee("Chandler", "Yemen");
        Employee Monica = new Employee("Monica", "Utopia");

        List<Employee> Employees = Arrays.asList(Phoebe, Rachel, Monica, Ross, Joey, Chandler);

        return Employees;

    }
}

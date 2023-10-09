package com.readcsv.entity;


import jakarta.persistence.*;
;

import java.util.Date;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created")
    private Date created;
    @Column(name = "name")
    private String companyName;

    @Column(name = "employees")
    private int numberOfEmployees;
    @Column(name = "rating")
    private double employeesRating;


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getEmployeesRating() {
        return employeesRating;
    }

    public void setEmployeesRating(double employeesRating) {
        this.employeesRating = employeesRating;
    }


}

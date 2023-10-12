package com.readcsv.entity;


import com.google.api.client.util.DateTime;
import jakarta.persistence.*;
;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "name")
    private String companyName;

    @Column(name = "employees")
    private double numberOfEmployees;
    @Column(name = "rating")
    private double employeesRating;


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(double numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getEmployeesRating() {
        return employeesRating;
    }

    public void setEmployeesRating(double employeesRating) {
        this.employeesRating = employeesRating;
    }


}

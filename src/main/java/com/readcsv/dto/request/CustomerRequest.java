package com.readcsv.dto.request;


import com.google.api.client.util.DateTime;

import java.time.LocalDateTime;
import java.util.Date;

public class CustomerRequest {

    private LocalDateTime created;
    private String companyName;
    private double numberOfEmployees;
    private double employeesRating;

//    public CustomerRequest(String name, int employees, double rating) {
//        this.name = name;
//        this.employees = employees;
//        this.rating = rating;
//    }


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

    public void setNumberOfEmployees(double employees) {
        this.numberOfEmployees = employees;
    }

    public double getEmployeesRating() {
        return employeesRating;
    }

    public void setEmployeesRating(double rating) {
        this.employeesRating = rating;
    }
}

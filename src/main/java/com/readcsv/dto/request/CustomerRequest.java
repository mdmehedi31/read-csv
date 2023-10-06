package com.readcsv.dto.request;


import java.util.Date;

public class CustomerRequest {

    private Date created;
    private String name;
    private int employees;
    private double rating;

//    public CustomerRequest(String name, int employees, double rating) {
//        this.name = name;
//        this.employees = employees;
//        this.rating = rating;
//    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

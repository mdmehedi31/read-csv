package com.readcsv.dto.response;



import java.util.Date;


public class CustomerResponse {

    private Date created;
    private String companyName;
    private int numberOfEmployees;
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

    public int getEmployees() {
        return numberOfEmployees;
    }

    public void setEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getRating() {
        return employeesRating;
    }

    public void setRating(double employeesRating) {
        this.employeesRating = employeesRating;
    }
}

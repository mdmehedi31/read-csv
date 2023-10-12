package com.readcsv.dto.response;



import java.time.LocalDateTime;
import java.util.Date;


public class CustomerResponse {

    private LocalDateTime created;
    private String companyName;
    private double numberOfEmployees;
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

package com.readcsv.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_on")
    private LocalDateTime created;
    @Column(name = "name")
    private String companyName;

    @Column(name = "number_of_employee")
    private double numberOfEmployees;
    @Column(name = "employee_rating")
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

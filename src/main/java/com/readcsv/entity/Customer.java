package com.readcsv.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "created")
    private Date created;
    @Column(name = "name")
    private String name;
    @Column(name = "employees")
    private int employees;
    @Column(name = "rating")
    private double rating;
}

package com.readcsv.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomerRequest {

    private Date created;
    private String name;
    private int employees;
    private double rating;
}

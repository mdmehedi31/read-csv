package com.readcsv.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomerResponse {

    private Date created;
    private String name;
    private int employees;
    private double rating;
}

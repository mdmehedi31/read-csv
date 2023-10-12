package com.readcsv.controller.implementation;

import com.readcsv.controller.definitons.CustomerControllerDef;
import com.readcsv.dto.response.CustomerResponse;
import com.readcsv.service.definitions.CustomerServiceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;


@RestController
public class CustomerControllerImpl implements CustomerControllerDef {

    @Autowired
    private CustomerServiceDefinition customerServiceDefinition;

    @Override
    public String uploadCSV(List<String[]> csvData) throws IOException {


       String message= this.customerServiceDefinition.SaveCustomerInfo(csvData);

        return message;
    }

    @Override
    public List<CustomerResponse> getAllCustomerList() {

        List<CustomerResponse> getAllCustomer= this.customerServiceDefinition.getAllCustomerListSortByName();

        return getAllCustomer;
    }

//    @Override
//    public Customer findByName(String name) {
//        return this.customerServiceDefinition.findByName(name);
//    }
}

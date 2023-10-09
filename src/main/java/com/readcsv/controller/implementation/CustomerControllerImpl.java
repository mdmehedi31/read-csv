package com.readcsv.controller.implementation;

import com.readcsv.controller.definitons.CustomerControllerDef;
import com.readcsv.dto.request.CustomerRequest;
import com.readcsv.dto.response.CustomerResponse;
import com.readcsv.entity.Customer;
import com.readcsv.repository.CustomerRepository;
import com.readcsv.service.definitions.CustomerServiceDefinition;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;


@RestController
public class CustomerControllerImpl implements CustomerControllerDef {

    @Autowired
    private CustomerServiceDefinition customerServiceDefinition;

    @Override
    public String uploadCSV(List<CustomerRequest> customerRequestList) throws IOException {


        System.out.println("This is from Upload CSV method...");
        String result = this.customerServiceDefinition.Save(customerRequestList);


        return result;
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {

        List<CustomerResponse> getAllCustomer= this.customerServiceDefinition.getAllCustomerListSortByName();
        return getAllCustomer;
    }

    @Override
    public Customer findByName(String name) {
        return this.customerServiceDefinition.findByName(name);
    }
}

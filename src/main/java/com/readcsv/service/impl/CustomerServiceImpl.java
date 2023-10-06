package com.readcsv.service.impl;


import com.readcsv.dto.request.CustomerRequest;
import com.readcsv.entity.Customer;
import com.readcsv.repository.CustomerRepository;
import com.readcsv.service.definitions.CustomerServiceDefinition;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class CustomerServiceImpl implements CustomerServiceDefinition {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String Save(MultipartFile file) throws IOException {

        List<CustomerRequest> customerList=CsvTOCustomer(file);

        for (CustomerRequest customerRequest : customerList){
            System.out.println("Name "+customerRequest.getName()+", Employees "+customerRequest.getEmployees()+", Rating "+customerRequest.getRating());
        }
        this.customerRepository.saveAll(dtoToEntity(customerList));

        return "Save Successful";
    }

    @Override
    public List<CustomerRequest> CsvTOCustomer(MultipartFile file) throws IOException {



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));


        CSVFormat format = CSVFormat.RFC4180.builder().setAllowMissingColumnNames(true).
                setHeader("Name","Employees","Rating").setSkipHeaderRecord(true).build();

        CSVParser csvParser = new CSVParser(bufferedReader, format);

          List<CustomerRequest> customerList= new ArrayList<>();

        for (CSVRecord record : csvParser) {

            String name= record.get(0);
            int employees = Integer.parseInt(record.get(1));
            double rating= Double.parseDouble(record.get(2));

            CustomerRequest customerRequest = new CustomerRequest();
            customerRequest.setName(name);
            customerRequest.setEmployees(employees);
            customerRequest.setRating(rating);

            customerList.add(customerRequest);
        }
        return customerList;
    }

    @Override
    public List<Customer> dtoToEntity(List<CustomerRequest> customerRequests) {

        List<Customer> customerList = new ArrayList<>();

        for (CustomerRequest customerRequest : customerRequests){

            Customer customer = new Customer();

            customer.setName(customerRequest.getName());
            customer.setEmployees(customerRequest.getEmployees());
            customer.setRating(customerRequest.getRating());
            customer.setCreated(new Date());

            customerList.add(customer);

        }

        return customerList;
    }
}

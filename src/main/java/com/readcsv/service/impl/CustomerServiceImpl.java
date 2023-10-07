package com.readcsv.service.impl;


import com.readcsv.dto.request.CustomerRequest;
import com.readcsv.dto.response.CustomerResponse;
import com.readcsv.entity.Customer;
import com.readcsv.repository.CustomerRepository;
import com.readcsv.service.definitions.CustomerServiceDefinition;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class CustomerServiceImpl implements CustomerServiceDefinition {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String Save(MultipartFile file) throws IOException {

        List<CustomerRequest> customerList=CsvTOCustomer(file);
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

    @Override
    public List<CustomerResponse> getAllCustomerListSortByName() {
        //findAllSortedByName();

        Sort sort= Sort.by(Sort.Direction.ASC,"name");
        List<Customer> getAllCustomer = this.customerRepository.findAll(sort);

        List<CustomerResponse> customers = entityToDto(getAllCustomer);


        return customers;
    }

    @Override
    public List<CustomerResponse> entityToDto(List<Customer> customerList) {

        List<CustomerResponse> getAllCustomer= new ArrayList<>();

        for (Customer customer : customerList){
            CustomerResponse customerResponse = new CustomerResponse();

            customerResponse.setName(customer.getName());
            customerResponse.setEmployees(customer.getEmployees());
            customerResponse.setRating(customer.getRating());
            customerResponse.setCreated(customer.getCreated());

            getAllCustomer.add(customerResponse);
        }


        return getAllCustomer;
    }
}

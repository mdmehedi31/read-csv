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


import java.io.IOException;
import java.io.StringReader;

import java.util.*;



@Service
public class CustomerServiceImpl implements CustomerServiceDefinition {

    private boolean used = false;
    @Autowired
    private CustomerRepository customerRepository;


    /*
     * SaveCustomerInfo() method store the data into DB
     * */
    @Override
    public String SaveCustomerInfo(List<String[]> csvData) {

        List<CSVRecord> list = convertListToCSVParse(csvData);
        List<CustomerRequest> customerList = CsvTOCustomer(list);
        this.customerRepository.saveAll(dtoToEntity(customerList));

        if (used) {
            return "All Data Was Not Imported Correctly";
        }
        else {
            return "Save Successful";
        }
    }

    /*
     * Using dtoToEntity() method, i convert the data from request data to entity data
     * and return it.
     * */
    @Override
    public List<Customer> dtoToEntity(List<CustomerRequest> customerRequests) {

        List<Customer> getCustomerList = new ArrayList<>();

        System.out.println("From Dto to entity...");
        for (CustomerRequest customerRequest : customerRequests) {

            Customer findCustomer = findByName(customerRequest.getCompanyName());
            if (findCustomer != null) {
                String updateMessage = updateValue(findCustomer, customerRequest);
                System.out.println("Your result is " + updateMessage);
            } else {
                Customer aCustomer = new Customer();

                aCustomer.setCompanyName(customerRequest.getCompanyName());
                aCustomer.setNumberOfEmployees(customerRequest.getNumberOfEmployees());
                aCustomer.setEmployeesRating(customerRequest.getEmployeesRating());
                aCustomer.setCreated(customerRequest.getCreated());
                getCustomerList.add(aCustomer);
            }

        }

        return getCustomerList;
    }


    /*
     * this method return the list of customer, it's return sorted data, which is sort as
     * ascending order by company name.
     * */
    @Override
    public List<CustomerResponse> getAllCustomerListSortByName() {
        //findAllSortedByName();

        Sort sort = Sort.by(Sort.Direction.ASC, "companyName");
        List<Customer> getAllCustomer = this.customerRepository.findAll(sort);

        List<CustomerResponse> customersList = entityToDto(getAllCustomer);
        return customersList;
    }

    @Override
    public List<CustomerResponse> entityToDto(List<Customer> customerList) {

        List<CustomerResponse> getAllCustomer = new ArrayList<>();

        for (Customer customer : customerList) {
            CustomerResponse customerResponse = new CustomerResponse();

            customerResponse.setCompanyName(customer.getCompanyName());
            customerResponse.setNumberOfEmployees(customer.getNumberOfEmployees());
            customerResponse.setEmployeesRating(customer.getEmployeesRating());
            customerResponse.setCreated(customer.getCreated());

            getAllCustomer.add(customerResponse);
        }


        return getAllCustomer;
    }


    /*
     * this method call the Customer Repository and find the data based on provided name
     * and it's return Customer types data.
     * */
    @Override
    public Customer findByName(String companyName) {

        return customerRepository.findByCompanyName(companyName);
    }

    @Override
    public List<CSVRecord> convertListToCSVParse(List<String[]> csvListData) {


        List<CSVRecord> csvRecordList = new ArrayList<>();

        StringBuilder csvString = new StringBuilder();
        for (String[] row : csvListData) {
            for (String cell : row) {
                csvString.append(cell).append(",");
            }
            csvString.deleteCharAt(csvString.length() - 1); // Remove the trailing comma
            csvString.append("\n");
        }

        CSVFormat format = CSVFormat.RFC4180.builder().setAllowMissingColumnNames(true).
                setHeader("Name", "Employees", "Rating").setSkipHeaderRecord(true).build();

        try (CSVParser csvParser = CSVFormat.RFC4180.builder().setAllowMissingColumnNames(true).
                setHeader("Name", "Employees", "Rating").
                setSkipHeaderRecord(true).
                build().
                parse(new StringReader(csvString.toString()))) {

            for (CSVRecord record : csvParser) {
                csvRecordList.add(record);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvRecordList;
    }

    /*
     * While we want to store any value in DB, which is already exist in the DB,
     * then we just update that data based on new data.
     * so this function mainly update the data which is already existing the DB.
     * */
    public String updateValue(Customer customer, CustomerRequest customerRequest) {

        customer.setCompanyName(customerRequest.getCompanyName());
        customer.setNumberOfEmployees(customerRequest.getNumberOfEmployees());
        customer.setEmployeesRating(customerRequest.getEmployeesRating());

        this.customerRepository.save(customer);

        return "Update Successfull";
    }


    @Override
    public List<CustomerRequest> CsvTOCustomer(List<CSVRecord> csvRecordList) {


        List<CustomerRequest> customerList = new ArrayList<>();

        System.out.println("from CsvToCustomer Method Service");


        for (CSVRecord record : csvRecordList) {
            if (isValid(record)) {

                String name = record.get(0);
                double employees = Double.parseDouble(record.get(1));
                double rating = Double.parseDouble(record.get(2));

                CustomerRequest customerRequest = new CustomerRequest();
                customerRequest.setCompanyName(name);
                customerRequest.setNumberOfEmployees(employees);
                customerRequest.setEmployeesRating(rating);
                customerList.add(customerRequest);
            } else {
                int i = 0;
                if (i == 0) {
                    i=1;
                    invalidNotification();
                }
            }
        }
            return customerList;
        }

    private void invalidNotification() {

        used=true;

    }

        public boolean isValid (CSVRecord record){

            if ((!record.get(0).isBlank()) || (!record.get(0).isEmpty()) || record != null) {
                if (isDouble(record.get(1))) {
                    if (isDouble(record.get(2))) {
                        return true;
                    }
                }
            }


    return false;

        }
        private boolean isDouble (String val){

            try {
                Double.parseDouble(val);
                return true;
            } catch (NumberFormatException numberFormatException) {
                return false;
            }

        }
    }
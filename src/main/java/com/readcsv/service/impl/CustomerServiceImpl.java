package com.readcsv.service.impl;


import com.readcsv.dto.request.CustomerRequest;
import com.readcsv.dto.response.CustomerResponse;
import com.readcsv.entity.Customer;
import com.readcsv.repository.CustomerRepository;
import com.readcsv.service.definitions.CustomerServiceDefinition;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import java.util.*;



@Service
public class CustomerServiceImpl implements CustomerServiceDefinition {


    @Autowired
    private CustomerRepository customerRepository;


    /*
    * SaveCustomerInfo() method store the data into DB
    * */
    @Override
    public String SaveCustomerInfo(List<CustomerRequest> customerRequests)  {
        this.customerRepository.saveAll(dtoToEntity(customerRequests));
        return "Save Successful";
    }

    /*
    * Using dtoToEntity() method, i convert the data from request data to entity data
    * and return it.
    * */
    @Override
    public List<Customer> dtoToEntity(List<CustomerRequest> customerRequests) {

        List<Customer> getCustomerList = new ArrayList<>();

        for (CustomerRequest customerRequest : customerRequests){

            Customer findCustomer=findByName(customerRequest.getCompanyName());
            if(findCustomer!=null){
                String updateMessage= updateValue(findCustomer,customerRequest);
                System.out.println("Your result is "+updateMessage);
            }
            else{
                Customer aCustomer = new Customer();

                aCustomer.setCompanyName(customerRequest.getCompanyName());
                aCustomer.setNumberOfEmployees(customerRequest.getNumberOfEmployees());
                aCustomer.setEmployeesRating(customerRequest.getEmployeesRating());
                aCustomer.setCreated(new Date());


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

        Sort sort= Sort.by(Sort.Direction.ASC,"companyName");
        List<Customer> getAllCustomer = this.customerRepository.findAll(sort);

        List<CustomerResponse> customersList = entityToDto(getAllCustomer);
        return customersList;
    }

    @Override
    public List<CustomerResponse> entityToDto(List<Customer> customerList) {

        List<CustomerResponse> getAllCustomer= new ArrayList<>();

        for (Customer customer : customerList){
            CustomerResponse customerResponse = new CustomerResponse();

            customerResponse.setCompanyName(customer.getCompanyName());
            customerResponse.setEmployees(customer.getNumberOfEmployees());
            customerResponse.setRating(customer.getEmployeesRating());
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

    /*
    * While we want to store any value in DB, which is already exist in the DB,
    * then we just update that data based on new data.
    * so this function mainly update the data which is already existing the DB.
    * */
    public String updateValue(Customer customer, CustomerRequest customerRequest){

        customer.setCompanyName(customerRequest.getCompanyName());
        customer.setNumberOfEmployees(customerRequest.getNumberOfEmployees());
        customer.setEmployeesRating(customerRequest.getEmployeesRating());

        this.customerRepository.save(customer);

        return "Update Successfull";
    }


    // for multipart result
//    @Override
//    public List<CustomerRequest> CsvTOCustomer(MultipartFile file) throws IOException {
//
//
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
//
//
//        CSVFormat format = CSVFormat.RFC4180.builder().setAllowMissingColumnNames(true).
//                setHeader("Name","Employees","Rating").setSkipHeaderRecord(true).build();
//
//        CSVParser csvParser = new CSVParser(bufferedReader, format);
//
//          List<CustomerRequest> customerList= new ArrayList<>();
//
//        for (CSVRecord record : csvParser) {
//
//            String name= record.get(0);
//            int employees = Integer.parseInt(record.get(1));
//            double rating= Double.parseDouble(record.get(2));
//
//            CustomerRequest customerRequest = new CustomerRequest();
//            customerRequest.setName(name);
//          //  customerRequest.setEmployees(employees);
//            customerRequest.setRating(rating);
//
//            customerList.add(customerRequest);
//        }
//        return customerList;
//    }

}

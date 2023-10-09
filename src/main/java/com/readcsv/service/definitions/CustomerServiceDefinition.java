package com.readcsv.service.definitions;

import com.readcsv.dto.request.CustomerRequest;
import com.readcsv.dto.response.CustomerResponse;
import com.readcsv.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;
import java.util.Set;

public interface CustomerServiceDefinition {

    String Save(List<CustomerRequest> customerRequests) throws IOException;

    //List<CustomerRequest> CsvTOCustomer(MultipartFile file) throws IOException;

    List<Customer> dtoToEntity(List<CustomerRequest> customerRequests);

    List<CustomerResponse> getAllCustomerListSortByName();

    List<CustomerResponse> entityToDto(List<Customer> customerList);
}

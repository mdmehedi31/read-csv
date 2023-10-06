package com.readcsv.service.definitions;

import com.readcsv.dto.request.CustomerRequest;
import com.readcsv.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;

public interface CustomerServiceDefinition {

    String Save(MultipartFile file) throws IOException;

    List<CustomerRequest> CsvTOCustomer(MultipartFile file) throws IOException;

    List<Customer> dtoToEntity(List<CustomerRequest> customerRequests);
}

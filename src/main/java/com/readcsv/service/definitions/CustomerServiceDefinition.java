package com.readcsv.service.definitions;

import com.readcsv.dto.request.CustomerRequest;
import com.readcsv.dto.response.CustomerResponse;
import com.readcsv.entity.Customer;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;
import java.util.Set;

public interface CustomerServiceDefinition {

    String SaveCustomerInfo(List<String[]> csvData) throws IOException;

    List<CustomerRequest> CsvTOCustomer(List<CSVRecord> csvRecordList) throws IOException;

    List<Customer> dtoToEntity(List<CustomerRequest> customerRequests);

    List<CustomerResponse> getAllCustomerListSortByName();

    List<CustomerResponse> entityToDto(List<Customer> customerList);

    Customer findByName(String name);

    List<CSVRecord> convertListToCSVParse(List<String[]> csvListData);
}

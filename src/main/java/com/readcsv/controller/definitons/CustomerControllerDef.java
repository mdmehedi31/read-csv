package com.readcsv.controller.definitons;


import com.readcsv.dto.request.CustomerRequest;
import com.readcsv.dto.response.CustomerResponse;
import com.readcsv.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/csv")
public interface CustomerControllerDef {

    @PostMapping("/upload-csv")
    String uploadCSV(@RequestBody List<CustomerRequest> customerRequestList) throws IOException;

    @GetMapping("/get-all-customer")
    List<CustomerResponse> getAllCustomerList();


//    @GetMapping("/get-by-name/{name}")
//    Customer findByName(@PathVariable String name);
}

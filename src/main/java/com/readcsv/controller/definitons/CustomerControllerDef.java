package com.readcsv.controller.definitons;


import com.readcsv.dto.response.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/csv")
public interface CustomerControllerDef {

    @PostMapping("/upload-csv")
    String uploadCSV(@RequestParam("file") MultipartFile file) throws IOException;

    @GetMapping("/get-all-customer")
    List<CustomerResponse> getAllCustomer();
}
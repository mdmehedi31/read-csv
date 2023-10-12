package com.readcsv.controller.definitons;


import com.readcsv.dto.response.CustomerResponse;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import java.io.IOException;
import java.util.List;

@RequestMapping("/csv")
public interface CustomerControllerDef {

    @PostMapping("/upload-csv")
    @Consumes()
    String uploadCSV(@RequestBody List<String[]> csvData) throws IOException;

    @GetMapping("/get-all-customer")
    List<CustomerResponse> getAllCustomerList();


//    @GetMapping("/get-by-name/{name}")
//    Customer findByName(@PathVariable String name);
}

package com.readcsv.controller.definitons;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/csv")
public interface CustomerControllerDef {

    @PostMapping("/upload-csv")
    String uploadCSV(@RequestParam("file") MultipartFile file) throws IOException;
}

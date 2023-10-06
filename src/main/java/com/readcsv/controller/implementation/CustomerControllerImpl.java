package com.readcsv.controller.implementation;

import com.readcsv.controller.definitons.CustomerControllerDef;
import com.readcsv.service.definitions.CustomerServiceDefinition;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;


@RestController
public class CustomerControllerImpl implements CustomerControllerDef {

    @Autowired
    private CustomerServiceDefinition customerServiceDefinition;

    @Override
    public String uploadCSV(MultipartFile file) throws IOException {


        String result = this.customerServiceDefinition.Save(file);
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(bufferedReader,
                CSVFormat.DEFAULT);
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        System.out.println("Your input data is");

        for (CSVRecord record : csvRecords) {

            String rc0=record.get(0);
            String rc1= record.get(1);
            int rc2= Integer.parseInt(record.get(2));
            double rc3= Double.parseDouble(record.get(3));


            System.out.println(rc0 + ", " + rc1 + ", " + rc2 + ", " + rc3);
        }*/
//            byte[] bytes = file.getBytes();
//            String csvContents = new String(bytes);
//
//            Reader reader= new FileReader(csvContents);
//
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//
//            System.out.println("Hello this is from controller method.");
//            System.out.println("Your CSV File Data Is: ");
//            for (CSVRecord record : csvParser){
//
//                System.out.println(record.get(0)+", "+record.get(1)+", "+record.get(2)+", "+record.get(3));
//            }


        return result;
    }
}

package com.readcsv.repository;

import com.readcsv.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

//    @Transactional
//    @Query("select name,employees,rating,created from Customer order by name asc")
//    List<Customer> findAll();


//    @Query("select name,employees,rating,created from Customer order by name asc")
//    List<Customer> findAllSortedByName();
}

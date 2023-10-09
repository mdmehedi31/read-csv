package com.readcsv.repository;

import com.readcsv.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByCompanyName(String name);
}

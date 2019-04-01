package com.ccanoprojects.aldeas.domain;

import com.ccanoprojects.aldeas.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface CustomersRepository extends JpaRepository<Customer, Serializable> {

    Customer findById(int id);

    List<Customer> findAll();
}

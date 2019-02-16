package com.ccanoprojects.aldeas.domain;

import com.ccanoprojects.aldeas.domain.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CustomersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersService.class);

    private CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public Customer save(Customer customer) {
        Timestamp today = new Timestamp(new Date().getTime());

        customer.setCreated(today);
        customer.setUpdated(today);
        customer.setStatus(Customer.RequestStatus.PENDING);

        LOGGER.info(customer.toString());

        return customersRepository.save(customer);
    }

    public Customer findCustomerById(int id) {
        return customersRepository.findById(id);
    }

    public List<Customer> findAll() {
        return customersRepository.findAll();
    }
}

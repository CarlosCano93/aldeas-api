package com.ccanoprojects.aldeas.api;

import com.ccanoprojects.aldeas.domain.CustomersService;
import com.ccanoprojects.aldeas.domain.EmailService;
import com.ccanoprojects.aldeas.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomersController {

    private CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/status")
    public String status() {
        return "OK";
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customersService.findAll();
    }

    @PostMapping(value = "/customers")
    Customer createCustomer(@RequestBody Customer customer) {
        //emailService.sendMailToHearthOfSouthAmericaFrom(customer);
        return customersService.save(customer);
    }
}

package com.ccanoprojects.aldeas.api;

import com.ccanoprojects.aldeas.domain.CustomersService;
import com.ccanoprojects.aldeas.domain.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomersController {

    private CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customersService.findAll();
    }

    @PostMapping
    public Customer post(@RequestBody Customer customer) {
        //emailService.sendMailToHearthOfSouthAmericaFrom(customer);
        return customersService.save(customer);
    }

    @GetMapping(value = "/{id}")
    public Customer getById(@PathVariable Integer id) {
        return customersService.findCustomerById(id);
    }
}

package com.ccanoprojects.aldeas;

import com.ccanoprojects.aldeas.domain.CustomersRepository;
import com.ccanoprojects.aldeas.domain.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mail.properties")
public class AldeasConfiguration {

    @Bean
    @Autowired
    CustomersService customersService(CustomersRepository customerRepository) {
        return new CustomersService(customerRepository);
    }

}

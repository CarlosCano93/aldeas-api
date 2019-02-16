package com.ccanoprojects.aldeas.domain;

import com.ccanoprojects.aldeas.domain.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceShould {

    private static final int CUSTOMER_1_ID = 1;
    private static final String CUSTOMER_1_NAME = "Carlos";
    private static final String CUSTOMER_1_EMAIL = "carlos@example.com";
    private static final Customer CUSTOMER_1 = Customer.builder()
            .id(CUSTOMER_1_ID)
            .name(CUSTOMER_1_NAME)
            .email(CUSTOMER_1_EMAIL).build();

    private static final int CUSTOMER_2_ID = 2;
    private static final String CUSTOMER_2_NAME = "Customer 2";
    private static final String CUSTOMER_2_EMAIL = "customer@two.com";
    private static final Customer CUSTOMER_2 = Customer.builder()
            .id(CUSTOMER_2_ID)
            .name(CUSTOMER_2_NAME)
            .email(CUSTOMER_2_EMAIL).build();

    private static final List<Customer> ALL_CUSTOMERS = List.of(CUSTOMER_1, CUSTOMER_2);
    
    @Mock CustomersRepository customerRepository;

    private CustomersService customersService;

    @Before public void
    initialize() {
        customersService = new CustomersService(customerRepository);
    }

    @Test public void
    create_new_user() {
        given(customerRepository.save(CUSTOMER_1)).willReturn(CUSTOMER_1);
        assertThat(customersService.save(CUSTOMER_1), is(CUSTOMER_1));
    }

    @Test public void
    return_a_customer_by_id() {
        given(customerRepository.findById(CUSTOMER_1_ID)).willReturn(CUSTOMER_1);
        assertThat(customersService.findCustomerById(CUSTOMER_1_ID), is(CUSTOMER_1));
    }

    @Test public void
    return_list_of_all_customers() {
        given(customerRepository.findAll()).willReturn(ALL_CUSTOMERS);
        assertThat(customersService.findAll(), is(ALL_CUSTOMERS));
    }
}

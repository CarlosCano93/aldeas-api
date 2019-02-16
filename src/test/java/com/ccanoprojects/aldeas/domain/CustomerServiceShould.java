package com.ccanoprojects.aldeas.domain;

import com.ccanoprojects.aldeas.domain.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceShould {

    private static final String NAME = "Carlos";
    private static final String EMAIL = "carlos@example.com";

    private static final Customer CUSTOMER = Customer.builder()
            .name(NAME)
            .email(EMAIL).build();

    @Mock CustomersRepository customerRepository;

    private CustomersService customersService;

    @Before public void
    initialize() {
        customersService = new CustomersService(customerRepository);
    }

    @Test public void
    create_new_user() {
        given(customerRepository.save(CUSTOMER)).willReturn(CUSTOMER);
        assertThat(customersService.save(CUSTOMER), is(CUSTOMER));
    }
}

package com.ccanoprojects.aldeas.api;

import com.ccanoprojects.aldeas.domain.CustomersRepository;
import com.ccanoprojects.aldeas.domain.entity.Customer;
import com.eclipsesource.json.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CustomersControllerShould {

    private static final Customer CUSTOMER_1 = Customer.builder()
            .id(1)
            .name("Customer 1")
            .email("customer@one.com").build();

    private static final Customer CUSTOMER_2 = Customer.builder()
            .id(2)
            .name("Customer 2")
            .email("customer@two.com").build();

    private static final Customer CUSTOMER_3 = Customer.builder()
            .id(3)
            .name("Customer 3")
            .email("customer@three.com").build();

    @Autowired MockMvc mvc;

    @Autowired CustomersRepository customersRepository;

    @Test public void
    return_customer_when_post_customer() throws Exception {
        mvc.perform(post("/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonContaining(CUSTOMER_1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(CUSTOMER_1.getName())))
                .andExpect(jsonPath("$.email", is(CUSTOMER_1.getEmail())));
    }

    @Test public void
    return_customer_by_id() throws Exception {
        customersRepository.save(CUSTOMER_1);

        mvc.perform(get("/v1/customers/{id}", CUSTOMER_1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(CUSTOMER_1.getId())))
                .andExpect(jsonPath("$.name", is(CUSTOMER_1.getName())))
                .andExpect(jsonPath("$.email", is(CUSTOMER_1.getEmail())));
    }

    @Test public void
    return_all_customers() throws Exception {
        customersRepository.save(CUSTOMER_1);
        customersRepository.save(CUSTOMER_2);
        customersRepository.save(CUSTOMER_3);

        mvc.perform(get("/v1/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.[0].name", is(CUSTOMER_1.getName())))
                .andExpect(jsonPath("$.[2].name", is(CUSTOMER_3.getName())));
    }

    @Test public void
    return_status_ok() throws Exception {
        mvc.perform(get("/v1/status")).andExpect(status().isOk())
        .andExpect(content().string("OK"));
    }

    private String jsonContaining(Customer customer) {
        return new JsonObject()
                .add("name", customer.getName())
                .add("email", customer.getEmail()).toString();
    }
}

package com.ccanoprojects.aldeas.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CustomersControllerShould {

    @Autowired MockMvc mvc;

    @Test public void
    return_status_ok() throws Exception {

        mvc.perform(get("/v1/status"))
                .andExpect(content().string("OK"));
    }
}

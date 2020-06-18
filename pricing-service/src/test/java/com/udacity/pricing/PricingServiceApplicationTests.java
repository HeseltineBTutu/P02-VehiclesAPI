package com.udacity.pricing;


import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.is;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JacksonTester<Price> json;


    @Test
    public void contextLoads() {
    }

    /**
     * Test for appropriate list of prices
     *
     * @throws Exception if test fails
     */
    @Test
    public void testGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/services/price?vehicleId=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
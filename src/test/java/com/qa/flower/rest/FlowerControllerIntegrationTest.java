package com.qa.flower.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.flower.domain.Flower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

@SpringBootTest
@AutoConfigureMockMvc
public class FlowerControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    void testCreate() throws Exception {
        Flower testFlower = new Flower("Rose","Red", "Sweet");
        RequestBuilder req = post("/createFlower").content(this.mapper.writeValueAsString(testFlower))
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        Flower testSavedFlower = new Flower(1,"Rose", "Red", "Sweet");
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedFlower));


        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);





    }

    @Test
    void testCreateButHardToRead() throws Exception {
        this.mvc.perform(post("/createFlower").content(this.mapper.writeValueAsString(new Flower("Rose", "Red", "Sweet")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(this.mapper.writeValueAsString(new Flower(1,"Rose", "Red", "Sweet"))));
    }


}

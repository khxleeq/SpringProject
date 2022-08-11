package com.qa.flower.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.flower.domain.Flower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:flower-schema.sql",
        "classpath:flower-data.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
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
        Flower testSavedFlower = new Flower(3,"Rose", "Red", "Sweet");
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedFlower));


        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);


    }

    @Test
    void testCreateButHardToRead() throws Exception {
        this.mvc.perform(post("/createFlower").content(this.mapper.writeValueAsString(new Flower("Rose", "Red", "Sweet")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(this.mapper.writeValueAsString(new Flower(3,"Rose", "Red", "Sweet"))));
    }


    @Test
    void testGetAll() throws Exception {
        List<Flower> flowers = List.of(
                new Flower(1, "Rose", "Red", "Sweet"),
                new Flower(2, "Rose", "White", "Sweet"));
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(flowers));
        this.mvc.perform(get("/getAll")).andExpect(status().isOk()).andExpect(checkBody);
    }

    @Test
    void testGetById() throws Exception {
        ResultMatcher checkBody = content()
                .json(this.mapper.writeValueAsString(new Flower(1, "Rose", "Red", "Sweet")));

        this.mvc.perform(get("/get/1")).andExpect(status().isOk()).andExpect(checkBody);
    }

    @Test
    void testUpdateById() throws Exception {
        this.mvc.perform(
                        patch("/update/1")
                                .param("name", "Rose")
                                .param("colour", "Red")
                                .param("scent", "Sweet"))
                .andExpect(status().isOk())
                .andExpect(content().json(this.mapper.writeValueAsString(new Flower(1, "Rose", "Red", "Sweet"))));
    }

    @Test
    void testDelete() throws Exception{
        List<Flower> flower = List.of(
                new Flower(1, "Rose", "Red", "Sweet"),
                new Flower(2, "Rose", "White", "Sweet"));
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(flower));
        this.mvc.perform(delete("/remove/1"));
    }

}

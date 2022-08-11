package com.qa.flower.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.flower.domain.Flower;
import com.qa.flower.repos.FlowerRepo;
import com.qa.flower.service.FlowerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test") // set Profile to "test" so it uses the test app-test.properties
public class FlowerServiceUnitTest {


    @Autowired
    private FlowerService service;

    @MockBean
    private FlowerRepo repo;



    @Test
    void testUpdate() throws Exception {
        final int id = 1;
        final String name = "Rose";
        final String newcolour = "Red";
        final String newscent = "Sweet";

        Flower expected = new Flower(id, name, newcolour, newscent);

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Flower(id, name, "White", "Sour")));
        Mockito.when(this.repo.save(new Flower(id, name, newcolour, newscent)))
                .thenReturn(new Flower(id, name, newcolour, newscent));

        Flower actual = this.service.updateFlower(id, null, newcolour, newscent);

        assertEquals(expected, actual);
    }

}

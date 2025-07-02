package me.juhokim.SpringBootApplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {


    // MockMvc (HTTP Request)
    @Autowired
    MockMvc mockMvc;

    // WebApplicationContext (Configure MockMvc)
    @Autowired
    WebApplicationContext webApplicationContext;


    // TestRepository (Accessing Database)
    @Autowired
    TestRepository testRepository;


    // Configure MocMvc
    @BeforeEach
    public void setUpMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    // Delete everything in database
    @AfterEach
    public void deleteAll() {
        testRepository.deleteAll();
    }

    @Test
    public void getAllMembers() throws Exception{
        // Given (Initial dummy data)
        final String url = "/dreams";
        Dream dummyDream = testRepository.save(new Dream(1L, "FIRE"));

        // When (Make Request)
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        // Then (Compare response with the new data)
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(dummyDream.getId()))
                .andExpect(jsonPath("$[0].dream").value(dummyDream.getDream()));
    }
}

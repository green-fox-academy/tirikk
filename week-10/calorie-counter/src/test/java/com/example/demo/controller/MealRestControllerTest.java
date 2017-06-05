package com.example.demo.controller;

import com.example.demo.CalorieCounterApplication;
import com.example.demo.model.Meal;
import com.example.demo.model.MealType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalorieCounterApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class MealRestControllerTest {
  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testPost_withCorrectInput() throws Exception {
    Meal toSave = new Meal("2017-06-05", new MealType("Breakfast"), "steak", 600);
    ObjectMapper mapper = new ObjectMapper();
    String jsonInput = mapper.writeValueAsString(toSave);

    mockMvc.perform(post("/meal")
            .contentType(contentType)
            .content(jsonInput))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status", is("ok")));
  }

  @Test
  public void testPost_withIncompleteInput() throws Exception {
    String jsonInput = "{\"date\": \"2018-07-03\"," +
            "\"type\": {\"name\": \"Breakfast\"}}";

    mockMvc.perform(post("/meal")
            .contentType(contentType)
            .content(jsonInput))
            .andExpect(status().isIAmATeapot())
            .andExpect(jsonPath("$.status", is("error")));
  }
}
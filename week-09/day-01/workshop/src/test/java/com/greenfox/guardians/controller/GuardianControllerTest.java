package com.greenfox.guardians.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.greenfox.guardians.GuardiansApplication;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GuardiansApplication.class)
@WebAppConfiguration
@EnableWebMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GuardianControllerTest {
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
  public void testForCorrectInput() throws Exception {
    mockMvc.perform(get("/groot?message=somemessage"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.received", is("somemessage")))
            .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  @Test
  public void testWithoutInput() throws Exception {
    mockMvc.perform(get("/groot"))
            .andExpect(status().isIAmATeapot())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.error", is("I am Groot!")));
  }

  @Test
  public void testYonduWithValidInput() throws Exception {
    mockMvc.perform(get("/yondu?distance=100.0&time=10.0"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.distance", is(100.0)))
            .andExpect(jsonPath("$.time", is(10.0)))
            .andExpect(jsonPath("$.speed", is(10.0)));
  }

  @Test
  public void testYonduWithZero() throws Exception {
    mockMvc.perform(get("/yondu?distance=100.0&time=0.0"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.error", is("Division by zero")));
  }

  @Test
  public void testYonduWithoutInput() throws Exception {
    mockMvc.perform(get("/yondu"))
            .andExpect(status().isIAmATeapot())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.error", is("I am Groot!")));
  }

  @Test
  public void testRocket() throws Exception {
    mockMvc.perform(get("/rocket"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.caliber25", is(0)))
            .andExpect(jsonPath("$.caliber30", is(0)))
            .andExpect(jsonPath("$.caliber50", is(0)))
            .andExpect(jsonPath("$.shipstatus", is("empty")))
            .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void testFill() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.50&amount=5000"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.received", is(".50")))
            .andExpect(jsonPath("$.amount", is(5000)))
            .andExpect(jsonPath("$.shipstatus", is("40%")))
            .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void testFillWithOverload() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.50&amount=50000"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.received", is(".50")))
            .andExpect(jsonPath("$.amount", is(50000)))
            .andExpect(jsonPath("$.shipstatus", is("overloaded")))
            .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void testFillWithFull() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.30&amount=12500"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType))
            .andExpect(jsonPath("$.received", is(".30")))
            .andExpect(jsonPath("$.amount", is(12500)))
            .andExpect(jsonPath("$.shipstatus", is("full")))
            .andExpect(jsonPath("$.ready", is(true)));
  }
}
package com.example.girl.controller;

import com.example.girl.demain.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class girlControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getGirList() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/girl/getGirlList"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addGirl() {
    }

    @Test
    public void getGirlById() {
    }

    @Test
    public void updateGirlById() {
    }

    @Test
    public void deleteGirlById() {
    }

    @Test
    public void getGirlByAge() {
    }

    @Test
    public void judgeGirlByAge() {
    }
}
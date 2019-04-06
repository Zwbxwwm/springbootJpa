package com.example.girl.service;

import com.example.girl.demain.Girl;
import com.example.girl.service.impl.IGirlServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private IGirlServiceImpl iGirlService;
    @Test
    public void getGirlsList() {
        List<Girl> girlList = iGirlService.getGirlsList();
        Assert.assertEquals(true,girlList.size()>0);
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
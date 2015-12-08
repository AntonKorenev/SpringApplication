package com.company.spring_application.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
public class MapperFromCSVTest {
    @Autowired
    WebApplicationContext context;

    @Before
    public void init() {
    }

    @Test
    public void connectorCSVGenerateProperFormat() {
        System.out.println("It will be possible to test correctness of this class methods only by using integrated" +
                " testing. Now it has one private method and one void.");
    }

}
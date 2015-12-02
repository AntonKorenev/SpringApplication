package com.company.spring_application.mapper;

import com.company.spring_application.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("classpath:web.xml")
@ContextConfiguration("classpath:spring_config.xml")
public class MapperFromCSVTest {
    @Autowired
    WebApplicationContext context;

    Order order;

    @Before
    public void init() {
        MapperFromCSV mapperFromCSV = (MapperFromCSV) context.getBean("mapperFromCSV");
        try {
            Class[] cArg = new Class[1];
            cArg[0] = String.class;
            Method method = mapperFromCSV.getClass().getDeclaredMethod("formOrderFromCSV", cArg);
            method.setAccessible(true);
            order = (Order) method.invoke(mapperFromCSV, "1,Anton,Korenev,buy\n1,1000,tv\n2,200,monitor");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectorCSVGenerateProperFormat() {
        assertTrue(order != null);
        assertEquals(order.getClass().getName(), "com.company.spring_application.domain.Order");
    }

    @Test
    public void orderObjectWasFormedProperly() {
        assertTrue(1 == order.getId());
        assertEquals("Anton", order.getClient().getFirstName());
        assertEquals("Korenev", order.getClient().getLastName());
        assertEquals("buy", order.getTaskDescription());
        assertTrue(order.getProducts().get(0).getId() == 1);
    }
}
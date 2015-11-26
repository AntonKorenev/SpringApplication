package com.company.spring_application.mapper;

import com.company.spring_application.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MapperFromCSVTest {
    Order order;

    @Before
    public void init(){
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("src/main/webapp/WEB_INF/spring_config.xml");
        MapperFromCSV mapperFromCSV = (MapperFromCSV) context.getBean("mapperFromCSV");
        try {
            Class[] cArg = new Class[1];
            cArg[0] = String.class;
            Method method = mapperFromCSV.getClass().getDeclaredMethod("formOrderFromCSV",cArg);
            method.setAccessible(true);
            order = (Order) method.invoke(mapperFromCSV, "1,Anton,Korenev,buy\n1,1000,tv\n2,200,monitor");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectorCSVGenerateProperFormat(){
        assertTrue(order!=null);
        assertEquals(order.getClass().getName(),"com.company.spring_application.domain.Order");
    }

    @Test
    public void orderObjectWasFormedProperly(){
        assertTrue(1 == order.getId());
        assertEquals("Anton", order.getFirstName());
        assertEquals("Korenev", order.getLastName());
        assertEquals("buy", order.getTaskDescription());
        assertTrue(order.getProducts().get(0).getId() == 1);
    }
}
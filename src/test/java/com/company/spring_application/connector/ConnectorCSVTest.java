package com.company.spring_application.connector;

import com.company.spring_application.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ConnectorCSVTest {
    Order order;

    @Before
    public void init(){
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        ConnectorCSV connectorCSV = (ConnectorCSV) context.getBean("connectorCSV");
        try {
            Class[] cArg = new Class[1];
            cArg[0] = String.class;
            Method method = connectorCSV.getClass().getDeclaredMethod("formOrderFromCSV",cArg);
            method.setAccessible(true);
            order = (Order) method.invoke(connectorCSV, "1,Anton,Korenev,buy,1 1000 tv,2 200 monitor");
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
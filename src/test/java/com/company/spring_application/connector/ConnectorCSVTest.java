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
    ConnectorCSV connectorCSV;

    @Before
    public void init(){
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        connectorCSV = (ConnectorCSV) context.getBean("connectorCSV");

    }

    @Test
    public void connectorCSVGenerateProperFormat(){
        Order order = null;
        try {
            Class[] cArg = new Class[1];
            cArg[0] = String.class;
            Method method = connectorCSV.getClass().getDeclaredMethod("formOrderFromCSV",cArg);
            method.setAccessible(true);
            order = (Order) method.invoke(connectorCSV, "1,Anton,Korenev,Intern,He wants to learn Spring");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assertTrue(order!=null);
        assertEquals(order.getClass().getName(),"com.company.spring_application.domain.Order");
    }

    @Test
    public void orderObjectWasFormedProperly(){
        Order order = null;
        try {
            Class[] cArg = new Class[1];
            cArg[0] = String.class;
            Method method = connectorCSV.getClass().getDeclaredMethod("formOrderFromCSV",cArg);
            method.setAccessible(true);
            order = (Order) method.invoke(connectorCSV, "1,Anton,Korenev,Intern,He wants to learn Spring");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertTrue(1 == order.getId());
        assertEquals("Anton", order.getFirstName());
        assertEquals("Korenev", order.getLastName());
        assertEquals("Intern", order.getPosition());
        assertEquals("He wants to learn Spring", order.getTaskDescription());
    }
}
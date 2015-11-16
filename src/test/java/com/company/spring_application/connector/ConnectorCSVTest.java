package com.company.spring_application.connector;

import com.company.spring_application.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;


public class ConnectorCSVTest {
    Order orderFromService;

    @Before
    public void init(){
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        ConnectorCSV connectorCSV = (ConnectorCSV) context.getBean("connectorCSV");
        try {
            Method method = connectorCSV.getClass().getDeclaredMethod("getOrderFromService");
            method.setAccessible(true);
            orderFromService = (Order) method.invoke(connectorCSV);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //Now just testing a static request
    @Test
    public void connectorCSVReceivesRequestFromService(){
        assertTrue(orderFromService != null);
    }

    @Test
    public void connectorCSVGenerateProperFormat(){
        assertTrue(orderFromService.getClass().getName().equals("com.company.spring_application.domain.Order"));
    }

    @Test
    public void orderObjectWasFormedProperly(){
        boolean passed = false;
        if(orderFromService.getId() == -1 && orderFromService.getFirstName().equals("Anton")
                && orderFromService.getLastName().equals("Korenev") && orderFromService.getPosition().equals("Intern")
                && orderFromService.getTaskDescription().equals("He wants to learn spring")){
            passed = true;
        }
        assertTrue(passed);
    }
}
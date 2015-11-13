package com.company.SpringApplication.Connectors;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertTrue;

public class ConnectorCSVTest {
    ConnectorCSV csv;

    //Temporary solution. Will be replaced with spring-test methods as soon as I will bew familiar with them
    @Before
    public void initialize() {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        csv = (ConnectorCSV) context.getBean("connectorCSV");
    }

    @Test(timeout=1000)//after adding servlet/service I'll set up more appropriate timeout
    public void connectorAchievesFileFromService() {
        try {
            Method method = csv.getClass().getDeclaredMethod("getFileFromService");
            method.setAccessible(true);
            File fileFormService = (File) method.invoke(csv);
            assertTrue(fileFormService.exists());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void formatOfFileFromServiceIsCSV() {
        try {
            Method method = csv.getClass().getDeclaredMethod("getFileFromService");
            method.setAccessible(true);
            File fileFormService = (File) method.invoke(csv);
            String fileFromServiceName = fileFormService.getName();
            assertTrue(fileFromServiceName.contains(".csv"));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
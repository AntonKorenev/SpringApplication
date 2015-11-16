package com.company.spring_application;

import com.company.spring_application.connector.ConnectorCSV;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        System.out.println("asd");
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        ConnectorCSV csv = (ConnectorCSV) context.getBean("connectorCSV");
    }
}

package com.company.SpringApplication;

import com.company.SpringApplication.Connectors.ConnectorCSV;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by anton.korenev on 11/12/2015.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("asd");
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        ConnectorCSV csv = (ConnectorCSV) context.getBean("connectorCSV");
    }
}

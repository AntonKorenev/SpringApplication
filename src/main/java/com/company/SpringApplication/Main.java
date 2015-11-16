package com.company.SpringApplication;

import com.company.SpringApplication.Connectors.ConnectorCSV;
import com.company.SpringApplication.Mappers.MapperJSON;
import com.company.SpringApplication.domain.Order;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by anton.korenev on 11/12/2015.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("asd");
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        ConnectorCSV csv = (ConnectorCSV) context.getBean("connectorCSV");
        MapperJSON mj = new MapperJSON();
        Order testOrder = new Order(-1, "Anton", "Korenev", "Intern", "He wants to test class Order");
        try {
            System.out.println(mj.convert(testOrder));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

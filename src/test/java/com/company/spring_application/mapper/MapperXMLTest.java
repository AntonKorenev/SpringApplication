package com.company.spring_application.mapper;

import com.company.spring_application.domain.Client;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MapperXMLTest {
    @Test
    public void conversionOfFileToXMLWasSuccessful() {
        Product product1 = new Product(1,1000,"tv");
        Product product2 = new Product(2,200,"monitor");
        Order testOrder = new Order(new Client("Anton","Korenev"), "buy", product1, product2);
        testOrder.setId(-1);
        String responseXml = new MapperXML().convert(testOrder);
        System.out.println(responseXml);
        String expectedXml = "<com.company.spring__application.domain.Order>\n" +
                "  <id>-1</id>\n" +
                "  <client>\n" +
                "    <id>0</id>\n" +
                "    <firstName>Anton</firstName>\n" +
                "    <lastName>Korenev</lastName>\n" +
                "  </client>\n" +
                "  <taskDescription>buy</taskDescription>\n" +
                "  <products class=\"java.util.Collections$UnmodifiableList\">\n" +
                "    <list class=\"linked-list\">\n" +
                "      <com.company.spring__application.domain.Product>\n" +
                "        <id>1</id>\n" +
                "        <name>tv</name>\n" +
                "        <price>1000.0</price>\n" +
                "      </com.company.spring__application.domain.Product>\n" +
                "      <com.company.spring__application.domain.Product>\n" +
                "        <id>2</id>\n" +
                "        <name>monitor</name>\n" +
                "        <price>200.0</price>\n" +
                "      </com.company.spring__application.domain.Product>\n" +
                "    </list>\n" +
                "  </products>\n" +
                "</com.company.spring__application.domain.Order>";
        assertTrue(responseXml.equals(expectedXml));
    }
}
package com.company.spring_application.mapper;

import com.company.spring_application.domain.Order;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MapperXMLTest {
    @Test
    public void conversionOfFileToXMLWasSuccessful() {
        Order testOrder = new Order(-1, "Anton", "Korenev", "Intern", "He wants to test class Order");
        String responseXml = new MapperXML().convert(testOrder);
        System.out.println(responseXml);
        String expectingXml = "<com.company.spring__application.domain.Order>\n" +
                "  <id>-1</id>\n" +
                "  <firstName>Anton</firstName>\n" +
                "  <lastName>Korenev</lastName>\n" +
                "  <position>Intern</position>\n" +
                "  <taskDescription>He wants to test class Order</taskDescription>\n" +
                "</com.company.spring__application.domain.Order>";
        assertTrue(responseXml.equals(expectingXml));
    }
}
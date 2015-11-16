package com.company.SpringApplication.Mappers;

import com.company.SpringApplication.domain.Order;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MapperXMLTest {
    @Test
    public void conversionOfFileToXMLWasSuccessful() {
        Order testOrder = new Order(-1, "Anton", "Korenev", "Intern", "He wants to test class Order");
        String responseXml = new MapperXML().convert(testOrder);
        String expectingXml = "<com.company.SpringApplication.domain.Order>\n" +
                "  <id>-1</id>\n" +
                "  <firstName>Anton</firstName>\n" +
                "  <lastName>Korenev</lastName>\n" +
                "  <position>Intern</position>\n" +
                "  <taskDescription>He wants to test class Order</taskDescription>\n" +
                "</com.company.SpringApplication.domain.Order>";
        assertTrue(responseXml.equals(expectingXml));
    }
}
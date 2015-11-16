package com.company.spring_application.mapper;

import com.company.spring_application.domain.Order;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class MapperJSONTest {
    @Test
    public void conversionOfOrderToJsonWasSuccessful() {
        Order testOrder = new Order(-1, "Anton", "Korenev", "Intern", "He wants to test class Order");
        String responseJson = null;
        try {
            responseJson = new MapperJSON().convert(testOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String expectingJson = "{\"id\":-1,\"firstName\":\"Anton\",\"lastName\":\"Korenev\"," +
                "\"position\":\"Intern\",\"taskDescription\":\"He wants to test class Order\"}";
        assertTrue(responseJson.equals(expectingJson));
    }
}
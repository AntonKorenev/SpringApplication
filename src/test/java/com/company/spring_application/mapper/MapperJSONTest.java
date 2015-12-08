package com.company.spring_application.mapper;

import com.company.spring_application.domain.Client;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MapperJSONTest {
    @Test
    public void conversionOfOrderToJsonWasSuccessful() {
        Product product1 = new Product(1, 1000, "tv");
        Product product2 = new Product(2, 200, "monitor");
        Order testOrder = new Order(new Client("Anton", "Korenev"), "buy", product1, product2);
        testOrder.setId(-1);

        String responseJson = null;
        try {
            responseJson = new MapperJSON().convert(testOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String expectingJson = "{\"id\":-1,\"client\":{\"id\":0,\"firstName\":\"Anton\"," +
                "\"lastName\":\"Korenev\",\"order\":null},\"taskDescription\":\"buy\",\"products\":[" +
                "{\"id\":1,\"name\":\"tv\",\"price\":1000.0,\"order\":null}," +
                "{\"id\":2,\"name\":\"monitor\",\"price\":200.0,\"order\":null}]}";
        assertTrue(responseJson.equals(expectingJson));
    }
}
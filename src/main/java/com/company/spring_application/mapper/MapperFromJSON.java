package com.company.spring_application.mapper;

import com.company.spring_application.domain.Client;
import com.company.spring_application.domain.Order;
import com.company.spring_application.domain.Product;
import com.company.spring_application.processor.Processor;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.LinkedList;

public class MapperFromJSON {
    private Processor processor;

    public MapperFromJSON(Processor processor){
        this.processor = processor;
    }

    private Order formOrderFromJSON(String jsonString) throws NullPointerException, IOException{
        JSONObject orderJson = new JSONObject(jsonString);
        JSONArray productsJson = orderJson.getJSONArray("products");
        LinkedList<Product> products = new LinkedList<>();
        for(int i = 0; i < productsJson.length(); i++){
            final JSONObject productJson = productsJson.getJSONObject(i);
            int id = productJson.getInt("id");
            double price = productJson.getDouble("price");
            String name = productJson.getString("name");
            products.add(new Product(id, price, name));
        }

        int id = orderJson.getInt("id");
        String firstName = orderJson.getString("firstName");
        String lastName = orderJson.getString("lastName");
        String taskDecription = orderJson.getString("taskDescription");

        return new Order(id, new Client(firstName, lastName), taskDecription, products);
    }

    public void sendForProcessing(String jsonString){
        try {
            processor.proccess(formOrderFromJSON(jsonString));
        } catch (NullPointerException | IOException ex){
            ex.printStackTrace();
        }
    }
}

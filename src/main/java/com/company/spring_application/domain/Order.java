package com.company.spring_application.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Order implements Serializable{
    private final int id;
    Client client;
    private final String taskDescription;
    private List products;

    public Order(int id, Client client, String taskDescription, Product... products) {
        this.id = id;
        this.client = client;
        this.products = Collections.unmodifiableList(new LinkedList<>(Arrays.asList(products)));
        this.taskDescription = taskDescription;
    }

    public Order(int id, Client client, String taskDescription, List products) {
        this.id = id;
        this.client = client;
        this.taskDescription = taskDescription;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order:");
        sb.append("\nid=").append(id)
                .append("\nfirst name=").append(client.getFirstName())
                .append("\nlast name='").append(client.getLastName())
                .append("\ntask'").append(taskDescription);
        products.forEach((p) -> sb.append("\t").append(p.toString()).append("\n"));
        return sb.toString();
    }
}


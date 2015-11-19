package com.company.spring_application.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Order implements Serializable{
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String taskDescription;
    private List products;

    public Order(int id, String firstName, String lastName, String taskDescription, Product... products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.products = Collections.unmodifiableList(new LinkedList<>(Arrays.asList(products)));
        this.taskDescription = taskDescription;
    }

    public Order(int id, String firstName, String lastName, String taskDescription,
                 List<Product> products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.taskDescription = taskDescription;
        this.products = Collections.unmodifiableList(products);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
                .append("\nfirst name=").append(firstName)
                .append("\nlast name='").append(lastName)
                .append("\ntask'").append(taskDescription);
        products.forEach((p) -> sb.append("\t").append(p.toString()).append("\n"));
        return sb.toString();
    }
}


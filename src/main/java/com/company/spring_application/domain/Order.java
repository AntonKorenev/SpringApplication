package com.company.spring_application.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Order implements Serializable{
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String taskDescription;
    private CopyOnWriteArrayList<Product> products;
    //CopyOnWrite Arraylist was used because of its thread safe structure. This decision is better than making some array
    //or collection final and creating a new copy of it each time.

    public Order(int id, String firstName, String lastName, String taskDescription, Product... products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.products = new CopyOnWriteArrayList<Product>(products);
        this.taskDescription = taskDescription;
    }

    public Order(int id, String firstName, String lastName, String taskDescription,
                 List<Product> products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.taskDescription = taskDescription;
        this.products = new CopyOnWriteArrayList<>(products);
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

    //returning a copy to avoid changing inner collection from outside but without using of final identificator
    public List<Product> getProducts() {
        return new LinkedList<Product>(products);
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Order changeId(int id){
        return new Order(id,firstName,lastName,taskDescription, products);
    }

    public void addProductToOrder(Product newProduct){
        products.add(newProduct);
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


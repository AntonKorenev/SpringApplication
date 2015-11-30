package com.company.spring_application.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "orders")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int inDatabaseId;

    @Column(name = "order_number")
    private final int id;

    @Embedded
    @OneToOne
    @JoinColumn(name = "id")
    private final Client client;

    @Column(name = "task")
    private final String taskDescription;

    @Embedded
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<Product> products;

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

    public Order() {
        id = 0;
        client = new Client();
        List<Product> prs = new LinkedList<>();
        prs.add(new Product());
        products = Collections.unmodifiableList(prs);
        taskDescription="buy";
    }

    public void setInDatabaseId(int databaseId) {
        this.inDatabaseId = databaseId;
    }

    public int getInDatabaseId() {
        return inDatabaseId;
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
                .append("\nlast name=").append(client.getLastName())
                .append("\ntask=").append(taskDescription);
        products.forEach((p) -> sb.append("\t").append(p.toString()).append("\n"));
        return sb.toString();
    }
}


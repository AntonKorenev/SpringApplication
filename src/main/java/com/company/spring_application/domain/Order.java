package com.company.spring_application.domain;

import com.company.spring_application.databasehelpers.DOInterface;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "orders")
public class Order implements DOInterface {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(name = "task")
    private final String taskDescription;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private List<Product> products;

    public Order(Client client, String taskDescription, Product... products) {
        this.client = client;
        this.products = Collections.unmodifiableList(new LinkedList<>(Arrays.asList(products)));
        this.taskDescription = taskDescription;
    }

    public Order(Client client, String taskDescription, List products) {
        this.client = client;
        this.taskDescription = taskDescription;
        this.products = products;
    }

    public Order() {
        List<Product> prs = new LinkedList<>();
        prs.add(new Product());
        products = Collections.unmodifiableList(prs);
        taskDescription="buy";
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setClient(Client client) {
        this.client = client;
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


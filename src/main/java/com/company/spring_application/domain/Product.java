package com.company.spring_application.domain;

import com.company.spring_application.databasehelpers.DOInterface;

import javax.persistence.*;

@Entity(name = "products")
public class Product implements DOInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private final String name;

    @Column(name = "price")
    private final double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = true)
    Order order;

    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Product() {
        price = 0;
        name = "nothing";
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Product:");
        sb.append("\nid=").append(id)
                .append("\nprice=").append(price)
                .append("\nname=").append(name);
        return sb.toString();
    }
}

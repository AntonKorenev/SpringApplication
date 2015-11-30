package com.company.spring_application.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "products")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final int id;

    @Column(name = "price")
    private final double price;

    @Column(name = "name")
    private final String name;

    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
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

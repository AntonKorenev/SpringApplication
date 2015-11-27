package com.company.spring_application.domain;

import java.io.Serializable;

public class Product implements Serializable{
    private final int id;
    private final double price;
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

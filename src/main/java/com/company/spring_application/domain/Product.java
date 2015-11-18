package com.company.spring_application.domain;

public class Product {
    private final int id;
    private final double price;
    private final String name;

    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Product changeId(int id){
        return new Product(id, price, name);
    }

    public Product changePrice(double price){
        return new Product(id, price, name);
    }

    public Product changeName(String name){
        return new Product(id, price, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Product:");
        sb.append("\nid=").append(id)
                .append("\nprice=").append(price)
                .append("\nname='").append(name);
        return sb.toString();
    }
}

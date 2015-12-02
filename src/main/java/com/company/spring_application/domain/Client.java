package com.company.spring_application.domain;

import com.company.spring_application.databasehelpers.DOInterface;

import javax.persistence.*;

@Entity(name = "clients")
public class Client implements DOInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private final String firstName;

    @Column(name = "last_name")
    private final String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
    private Order order;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client() {
        firstName = "Anton";
        lastName = "Korenev";
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

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Client:");
        sb.append("\nfirst name=").append(firstName)
                .append("\nlast name=").append(lastName);
        return sb.toString();
    }
}

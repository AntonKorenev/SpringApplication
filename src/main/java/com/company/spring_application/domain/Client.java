package com.company.spring_application.domain;

import javax.persistence.*;

@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="first_name")
    private final String firstName;

    @Column(name="last_name")
    private final String lastName;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

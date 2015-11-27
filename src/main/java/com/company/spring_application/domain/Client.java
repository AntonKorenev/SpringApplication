package com.company.spring_application.domain;

public class Client {
    private final String firstName;
    private final String lastName;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

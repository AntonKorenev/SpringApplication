package com.company.SpringApplication.domain;

/**
 * Created by anton.korenev on 11/16/2015.
 */
public class Order {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String position;
    private final String taskDescription;

    public Order(int id, String firstName, String lastName, String position, String taskDescription) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.taskDescription = taskDescription;
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

    public String getPosition() {
        return position;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Order changeId(int id){
        return new Order(id,firstName,lastName,position,taskDescription);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}


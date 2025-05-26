package com.company.collection.employee;

public class Employee {
    private final int id;
    private final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}
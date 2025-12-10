package com.company.java25.constructor;

// super must be the first statement in a constructor
class Person {
    String name;
    int age;

    Person(String name, int age) {
        System.out.println("Person constructor called");
        if (age > 18) {
            System.out.println("Person age is greater than 18");
        }
        this.name = name;
        this.age = age;
    }
}
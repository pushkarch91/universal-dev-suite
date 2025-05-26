package com.company.collection.employee;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class NullTester {

    public static void main(String[] args) {

        Employee john = new Employee(1, "John");
        Employee mark = new Employee(2, "Mark");
        Employee adam = new Employee(3, "Adam");

        // HashMap allows one null key
        Map<String, Employee> hashMap = new HashMap<>();
        hashMap.put(null, john);
        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap allows one null key
        Map<String, Employee> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(null, mark);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // TreeMap does NOT allow null keys — will throw NullPointerException
        Map<String, Employee> treeMap = new TreeMap<>();
        try {
            treeMap.put(null, adam);
        } catch (NullPointerException e) {
            System.out.println("TreeMap: Cannot insert null key – " + e.getMessage());
        }
    }
}

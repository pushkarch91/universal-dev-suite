package com.company.eg01.defaultAndStaticMethodsInInterfaces.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable, Comparable<Product> {

    private long id;
    private String name;
    private double price;

    @Override
    public int compareTo(Product product) {
        return this.getName().compareTo(product.getName());
    }

}

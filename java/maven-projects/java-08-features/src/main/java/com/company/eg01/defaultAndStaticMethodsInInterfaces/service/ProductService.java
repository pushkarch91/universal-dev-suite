package com.company.eg01.defaultAndStaticMethodsInInterfaces.service;

import com.company.eg01.defaultAndStaticMethodsInInterfaces.model.Product;

import java.util.Collections;
import java.util.List;

public interface ProductService {

    default List<Product> sortProducts(List<Product> products) {
        Collections.sort(products);
        return products;
    }

    static void displayProductPrice(Product product) {
        System.out.printf("Price: %.2f%n", product.getPrice());
    }

    int findMaxPrice(List<Integer> prices);
}

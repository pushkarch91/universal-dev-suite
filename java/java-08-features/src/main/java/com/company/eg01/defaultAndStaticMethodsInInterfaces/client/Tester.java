package com.company.eg01.defaultAndStaticMethodsInInterfaces.client;

import com.company.eg01.defaultAndStaticMethodsInInterfaces.model.Product;
import com.company.eg01.defaultAndStaticMethodsInInterfaces.service.ProductService;
import com.company.eg01.defaultAndStaticMethodsInInterfaces.service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        Product iphone = new Product();
        iphone.setId(1L);
        iphone.setName("iphone");
        iphone.setPrice(Double.parseDouble("100.00"));

        Product samsung = new Product();
        samsung.setId(2L);
        samsung.setName("samsung");
        samsung.setPrice(Double.parseDouble("200.00"));

        Product google = new Product();
        google.setId(3L);
        google.setName("google");
        google.setPrice(Double.parseDouble("300.00"));

        products.add(iphone);
        products.add(samsung);
        products.add(google);

        ProductService productService = new ProductServiceImpl();
        productService.sortProducts(products);

        products.forEach(System.out::println);

    }
}

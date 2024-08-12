package com.company.eg01.defaultAndStaticMethodsInInterfaces.service;

import com.company.eg01.defaultAndStaticMethodsInInterfaces.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> sortProducts(List<Product> products) {
        return ProductService.super.sortProducts(products);
    }

    @Override
    public int findMaxPrice(List<Integer> prices) {
        return prices.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Price list cannot be empty"));
    }

}

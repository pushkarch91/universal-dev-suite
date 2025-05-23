package com.company.projectmultipledatabasemybatis;

import com.company.projectmultipledatabasemybatis.ordermapper.OrderMapper;
import com.company.projectmultipledatabasemybatis.productmapper.ProductMapper;
import com.company.projectmultipledatabasemybatis.model.Order;
import com.company.projectmultipledatabasemybatis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ProjectMultipleDatabaseMybatisApplication implements CommandLineRunner {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    public static void main(String[] args) {
        SpringApplication.run(ProjectMultipleDatabaseMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setName("laptop");
        product.setPrice(3000.00);
        productMapper.insert(product);

        Order order = new Order();
        order.setId(101);
        order.setOrderCode("nqa-982601");
        order.setCustomerName("Pushkar");
        order.setProductId(1);
        order.setQuantity(1);
        order.setPrice(1000);
        order.setCreatedAt(LocalDateTime.now());
        orderMapper.insert(order);
    }

}

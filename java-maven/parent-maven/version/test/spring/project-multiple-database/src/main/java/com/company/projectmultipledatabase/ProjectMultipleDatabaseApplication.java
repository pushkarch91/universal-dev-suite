package com.company.projectmultipledatabase;

import com.company.projectmultipledatabase.orderentity.Order;
import com.company.projectmultipledatabase.orderrepository.OrderDao;
import com.company.projectmultipledatabase.productentity.Product;
import com.company.projectmultipledatabase.productrepository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ProjectMultipleDatabaseApplication implements CommandLineRunner {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    public static void main(String[] args) {
        SpringApplication.run(ProjectMultipleDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setName("laptop");
        product.setPrice(3000.00);
        productDao.save(product);

        Order order = new Order();
        order.setId(101);
        order.setOrderFrom("Pushkar");
        order.setOrderDateTime(LocalDateTime.now());
        orderDao.save(order);
    }
}

package com.company.projectmultipledatabase.productrepository;

import com.company.projectmultipledatabase.productentity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}

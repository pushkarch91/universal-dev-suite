package com.company.projectmultipledatabase.productentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    private Integer id;
    private String name;
    private double price;
}

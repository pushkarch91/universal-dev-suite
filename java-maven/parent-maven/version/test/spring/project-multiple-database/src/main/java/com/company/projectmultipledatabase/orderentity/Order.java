package com.company.projectmultipledatabase.orderentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    private Integer id;
    private String orderFrom;
    private LocalDateTime orderDateTime;
}

package com.company.projectmultipledatabasemybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String orderCode;
    private String customerName;
    private int productId;
    private int quantity;
    private int price;
    private LocalDateTime createdAt;
}


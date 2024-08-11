package com.company.product;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private double price;

}

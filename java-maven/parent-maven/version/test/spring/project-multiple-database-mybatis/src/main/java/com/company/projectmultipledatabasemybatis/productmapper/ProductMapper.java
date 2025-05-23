package com.company.projectmultipledatabasemybatis.productmapper;

import com.company.projectmultipledatabasemybatis.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void insert(Product product);
    Product findById(int id);
    void batchInsert(@Param("products") List<Product> products);
}

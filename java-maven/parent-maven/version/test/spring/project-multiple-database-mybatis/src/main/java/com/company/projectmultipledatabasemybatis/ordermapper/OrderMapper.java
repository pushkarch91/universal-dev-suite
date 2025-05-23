package com.company.projectmultipledatabasemybatis.ordermapper;

import com.company.projectmultipledatabasemybatis.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insert(Order order);

    Order findById(int id);

    void batchInsert(@Param("orders") List<Order> orders);
}

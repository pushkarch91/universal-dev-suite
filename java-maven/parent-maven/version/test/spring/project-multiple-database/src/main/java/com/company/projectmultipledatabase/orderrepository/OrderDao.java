package com.company.projectmultipledatabase.orderrepository;

import com.company.projectmultipledatabase.orderentity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}

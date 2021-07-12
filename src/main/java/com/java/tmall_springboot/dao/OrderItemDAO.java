package com.java.tmall_springboot.dao;

import com.java.tmall_springboot.pojo.Order;
import com.java.tmall_springboot.pojo.OrderItem;
import com.java.tmall_springboot.pojo.Product;
import com.java.tmall_springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
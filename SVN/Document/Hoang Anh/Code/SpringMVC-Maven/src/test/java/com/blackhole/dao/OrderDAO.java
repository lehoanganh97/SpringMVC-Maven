package com.blackhole.dao;

import java.util.List;
import com.blackhole.entities.Order;

public interface OrderDAO {
 
 public List<Order> getOrders();
 public void saveOrder(Order newOrder);
 public Order getOrder(int orderId);
 public void deleteOrder(int orderId);
}

package com.blackhole.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.blackhole.dao.OrderDAO;
import com.blackhole.entities.Order;

@Service
public class OrderServiceImpl implements OrderService {
 
  @Autowired
  private OrderDAO orderDAO;
 
  @Override
  @Transactional
  public List<Order> getOrders() {
   return orderDAO.getOrders();
  }
 
  @Override
  @Transactional
  public void saveOrder(Order newOrder) {
    orderDAO.saveOrder(newOrder);
  }
 
  @Override
  @Transactional
  public Order getOrder(int orderId) {
    return orderDAO.getOrder(orderId);
  }
 
  @Override
  @Transactional
  public void deleteOrder(int orderId) {
    orderDAO.deleteOrder(orderId);
  }
}
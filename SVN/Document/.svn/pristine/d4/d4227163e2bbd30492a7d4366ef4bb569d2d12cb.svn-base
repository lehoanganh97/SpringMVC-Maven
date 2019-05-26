package com.blackhole.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.blackhole.dao.OrderDAO;
import com.blackhole.entities.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
 
  @Autowired
  private SessionFactory factory;
  
  @Override
  public List<Order> getOrders(){
	// get the current hibernate session
	  Session session = factory.getCurrentSession();
	  
	  // create a query to select all orders
	  String sql="FROM Order";
	  Query theQuery = session.createQuery(sql);
	   
	  // execute query and get result list
	  List<Order> orders = theQuery.list();
	  
	  // return the result
	  return orders;
  }
 
  @Override
  public void saveOrder(Order newOrder) { 
	// get the current hibernate session
	  Session session = factory.getCurrentSession();
	  
	  // create/update  the order object to the database table
	  session.saveOrUpdate(newOrder);
	  
  }
 
 
  @Override
  public Order getOrder(int orderId) {
    
    // get the current hibernate session
    Session session = factory.getCurrentSession();
    
    // get the order using the passed id (primary key)
    return session.get(Order.class, orderId);
  }
 
  
  @Override
  public void deleteOrder(int orderId) {
    
    // get the current hibernate session
    Session session = factory.getCurrentSession();
    
    // delete the order using the passed id (primary key)
    Query theQuery = session.createQuery("delete from Order where id=:Id");
    theQuery.setParameter("Id", orderId);
    theQuery.executeUpdate();
  }
  
}
package com.servicingportal.admin.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.servicingportal.admin.dao.AdminOrderServiceDetailDAO;
import com.servicingportal.entity.DetailOrder;

@Transactional
@Repository
public class AdminOrderServiceDetailDAOImpl implements AdminOrderServiceDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetailOrder> getDetailOrderByOrderService(int orderServiceID) {
		// TODO Auto-generated method stub
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "select do from DetailOrder do where do.orderservice.orderId = :orderServiceID" ;
			Query query = session.createQuery(sql);
			query.setParameter("orderServiceID", orderServiceID);
			List<DetailOrder> ldOrder = query.list();
			return ldOrder;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error getDetailOrderByOrderService " + e.getMessage());
			return null;
		}
	}
}

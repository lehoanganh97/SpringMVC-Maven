package com.servicingportal.admin.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.servicingportal.admin.dao.AdminOrderServiceDAO;
import com.servicingportal.entity.OrderService;

@Transactional
@Repository
public class AdminOrderServiceDAOImpl implements AdminOrderServiceDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderService> listOrderService() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "SELECT O FROM OrderService O";
			Query query = session.createQuery(hql);
			List<OrderService> list = query.list();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}

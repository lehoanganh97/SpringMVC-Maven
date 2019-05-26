package com.servicingportal.customer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.customer.dao.CustomerOrderServiceDAO;
import com.servicingportal.entity.OrderService;

@Transactional
public class CustomerOrderServiceDAOImpl implements CustomerOrderServiceDAO{

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderService> getCustomerOrderSerivce(int icustomerID) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		try {
			String hql = "SELECT os FROM OrderService os WHERE CustomerID = :icustomerID";
			Query query = session.createQuery(hql).setParameter("icustomerID", icustomerID);
			List<OrderService> listResult = query.list();
			return listResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int deleteOrderServicebyCustomer(int iorderID, boolean booAdminCheck) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderService getCustomerOrderbyID(int iorderID) {
		// TODO Auto-generated method stub
		return null;
	}
}

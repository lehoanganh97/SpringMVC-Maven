package com.servicingportal.customer.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.customer.dao.CustomerOrderServiceDAO;
import com.servicingportal.entity.OrderService;

@Transactional
@Repository
public class CustomerOrderServiceDAOImpl implements CustomerOrderServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderService> getCustomerOrderSerivce(int icustomerID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "SELECT os FROM OrderService os WHERE CustomerID = :icustomerID";
			TypedQuery<OrderService> query = session.createQuery(hql).setParameter("icustomerID", icustomerID);
			List<OrderService> listResult = query.getResultList();
			return listResult;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteOrderServicebyCustomer(int iorderID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "UPDATE OrderService set isDelete = 1, DeleteDate ='" + LocalDateTime.now().toString()
					+ "', OrderStatus = -1, DeleteNote = Customer WHERE OrderID = :iorderID";
			TypedQuery<OrderService> query = session.createQuery(hql).setParameter("iorderID", iorderID);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrderService getCustomerOrderbyID(int icustomerID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "SELECT os FROM OrderService os WHERE CustomerID = :icustomerID ";
			TypedQuery<OrderService> query = session.createQuery(hql).setParameter("icustomerID", icustomerID);
			OrderService result = query.getSingleResult();
			return result;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
}

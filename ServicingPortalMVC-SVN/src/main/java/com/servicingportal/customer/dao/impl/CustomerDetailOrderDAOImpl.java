package com.servicingportal.customer.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.customer.dao.CustomerDetailOrderDAO;
import com.servicingportal.entity.DetailOrder;

@Repository
@Transactional
public class CustomerDetailOrderDAOImpl implements CustomerDetailOrderDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public DetailOrder getDetailOrderbyId(Integer iorderId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "SELECT do FROM DetailOrder as do WHERE do.detailOrderId =: iorderId";
			TypedQuery<DetailOrder> typedQuery = session.createQuery(hql).setParameter("iorderId", iorderId);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailOrder> getDetailOrder(Integer iorderId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "SELECT do FROM DetailOrder as do WHERE do.detailOrderId =: iorderId";
			TypedQuery<DetailOrder> typedQuery = session.createQuery(hql).setParameter("iorderId", iorderId);
			return typedQuery.getResultList();
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

}

package com.servicingportal.customer.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.customer.dao.CustomerFieldServiceDAO;
import com.servicingportal.entity.FieldService;

@Repository
@Transactional
public class CustomerFieldServiceDAOImpl implements CustomerFieldServiceDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<FieldService> getAllFieldServices() {
		Session session = this.sessionFactory.getCurrentSession();
		List<FieldService> listFieldService = session.createQuery("from FieldService").list();
		return listFieldService;
	}
	
}

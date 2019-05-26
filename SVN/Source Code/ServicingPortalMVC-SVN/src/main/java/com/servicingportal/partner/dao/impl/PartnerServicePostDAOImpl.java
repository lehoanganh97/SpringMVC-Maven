package com.servicingportal.partner.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.entity.ServicePost;
import com.servicingportal.partner.dao.PartnerServicePostDAO;

@Transactional
public class PartnerServicePostDAOImpl implements PartnerServicePostDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createServicePost(ServicePost servicepost) {
		Session session = this.sessionFactory.getCurrentSession();
		try{	
			//session.getTransaction().begin();
			session.save(servicepost);
			//Long lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
			//return servicepost.getServicePostID();
			//session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
	           // Rollback trong trường hợp có lỗi xẩy ra.
	        //session.getTransaction().rollback();
			return false;
		}
	}

}

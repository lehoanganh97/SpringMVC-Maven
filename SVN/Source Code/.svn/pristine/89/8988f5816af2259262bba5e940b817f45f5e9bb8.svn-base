package com.servicingportal.partner.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.entity.ServicePostDetail;
import com.servicingportal.partner.dao.PartnerDetailServicePostDAO;

@Transactional
public class PartnerDetailServicePostDAOImpl implements PartnerDetailServicePostDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createDetailServicePost(ServicePostDetail servicePostDetail) {
		Session session = this.sessionFactory.getCurrentSession();
		try{	
			//session.getTransaction().begin();
			session.save(servicePostDetail);

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

package com.servicingportal.admin.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.servicingportal.admin.dao.AdminFServiceDAO;
import com.servicingportal.entity.FieldService;

@Transactional
@Repository
public class AdminFServiceDAOImpl implements AdminFServiceDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Integer getMaxFieldServiceID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "SELECT max(fserviceId) FROM FieldService ";
		    Query query = session.createQuery(sql);
		    Integer maxFServiceID = (Integer) query.getSingleResult();
		    return maxFServiceID;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public FieldService getFieldServiceByID(int id) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			FieldService fser = (FieldService)session.get(FieldService.class, id);
			return fser;
		} catch(Exception e) {
			return null;
		}
	}
	@Override
	public boolean createFieldService(FieldService fservice) {
//		try{
//			Session session = this.sessionFactory.getCurrentSession();
//		    session.persist(fservice);
//		    session.getTransaction().commit();
//			return true;
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//			// TODO: handle exception
//			return false;
//		}

		// Diễm 22/10/2018
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.save(fservice);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
}

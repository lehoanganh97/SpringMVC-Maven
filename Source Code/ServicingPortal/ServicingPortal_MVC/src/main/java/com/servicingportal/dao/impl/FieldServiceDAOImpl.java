package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.FieldServiceDAO;
import com.servicingportal.entity.FieldService;

@Transactional
public class FieldServiceDAOImpl implements FieldServiceDAO {
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FieldService> listAllFieldService() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<FieldService> list = session.createQuery("from FieldService").list();
			return list;
		} catch (Exception e)
		{
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

	@Override
	public int getMaxFieldServiceID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(a.FServiceID) from FieldService a ";
		    Query query = session.createQuery(sql);
		    Integer maxFServiceID = (Integer) query.uniqueResult();
		    if (maxFServiceID == null) {
		    	return -1;
		    }
		    return maxFServiceID;
		} catch(Exception e){
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

	@SuppressWarnings("unchecked")
	@Override
	public List<FieldService> getField() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select * from fieldservice where PFServiceID IS NULL";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(FieldService.class);
			List<FieldService> list = query.list();
			
			return list;
		} catch(Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FieldService> getAllServiceByField(int id) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select * from fieldservice where PFServiceID =" + id;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(FieldService.class);
			List<FieldService> list = query.list();
			
			return list;
		} catch(Exception e) {
			return null;
		}
	}

}

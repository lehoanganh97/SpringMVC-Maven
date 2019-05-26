package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.TypeServiceDAO;
import com.servicingportal.entity.TypeService;

@Transactional
public class TypeServiceDAOImpl implements TypeServiceDAO{
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createTypeService(TypeService typeService) {
		boolean checkCreate = true;
		
		try{
			// Phước 1/10/2018
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(typeService);
			session.beginTransaction().commit();
		}catch(Exception e)
		{
			System.out.println("Error of createTypeService: "+e.getMessage());
			checkCreate = false;
		}
		return checkCreate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeService> getListTypeService() {
		// Phước 1/10/2018
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<TypeService> liTypeService = session.createQuery("from TypeService").list();
			return liTypeService;
		} catch (Exception e) {
			return null;
		}		
	}
	
	@Override
	public TypeService getTypeServiceByID(int idTypeService) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			TypeService typeService = (TypeService) session.get(TypeService.class, idTypeService);
			return typeService;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getTypeServiceByID: "+e.getMessage());
			return null;
		}

	}
	
	@Override
	public int getMaxTypeServiceID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(t.typeServiceID) from TypeService t ";
		    Query query = session.createQuery(sql);
		    Integer inMaxTypeServiceID = (Integer) query.uniqueResult();
		    if (inMaxTypeServiceID == null) {
		    	return -1;
		    }
		    return inMaxTypeServiceID;
		} catch(Exception e) {
			return -1;
		}
		
	}
}

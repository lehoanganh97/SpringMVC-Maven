package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.EmployeeManageFServiceDAO;
import com.servicingportal.entity.EmployeeManageFservice;

@Transactional
public class EmployeeManageFServiceDAOImpl implements EmployeeManageFServiceDAO{

	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeManageFservice> listEmployeeMangerFservice() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<EmployeeManageFservice> list = session.createQuery("from EmployeeManageFservice").list();
			return list;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean creatEmployeeManageFservice(EmployeeManageFservice eManageFservice) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(eManageFservice);
			session.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public int getMaxEmployeeManageFserviceID() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(emf.emfID) from EmployeeManageFservice emf ";
		    Query query = session.createQuery(sql);
		    Integer emfID = (Integer) query.uniqueResult();
		    if (emfID == null) {
		    	return -1;
		    }
		    return emfID;
		} catch(Exception e) {
			return -1;
		}
	}

	@Override
	public EmployeeManageFservice getEmployeeManageFservicebyID(int iemfID) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			EmployeeManageFservice emf = (EmployeeManageFservice)session.get(EmployeeManageFservice.class, iemfID);
			return emf;
		} catch(Exception e) {
			return null;
		}
	}
}

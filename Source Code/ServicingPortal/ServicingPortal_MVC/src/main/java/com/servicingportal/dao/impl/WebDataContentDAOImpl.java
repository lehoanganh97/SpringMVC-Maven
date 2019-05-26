package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.WebDataContentDAO;
import com.servicingportal.entity.WebDataContent;

@Transactional
public class WebDataContentDAOImpl implements WebDataContentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createWebDataContent(WebDataContent webDataContent) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(webDataContent);
			session.beginTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WebDataContent> listAllWebDataContent() {
		String sql = "select w from WebDataContent w";
		try {
			Session session =  this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<WebDataContent> listResult = query.list();
			return listResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int getMaxWebDataContentID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select Max(w.WebDataContent) From WebDataContent w";
			Query query = session.createQuery(sql);
			return (int)query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	@Override
	public WebDataContent getWebDataContentByID(int webDataContentID) {
		String sql = "select w from WebDataContent w where w.webDataContentID = :strWebDataContentID";
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("strWebDataContentID", webDataContentID);
			return (WebDataContent) query.list().get(0);			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
}

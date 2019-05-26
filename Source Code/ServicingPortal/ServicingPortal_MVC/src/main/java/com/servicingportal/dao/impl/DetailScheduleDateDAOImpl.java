package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.DetailScheduleDateDAO;
import com.servicingportal.entity.DetailScheduleDate;

@Transactional
public class DetailScheduleDateDAOImpl implements DetailScheduleDateDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean createDetailScheduleDate(DetailScheduleDate detailScheduleDate) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(detailScheduleDate);
			session.beginTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailScheduleDate> listAllDetailScheduleDate() {
		String sql = "select d from DetailScheduleDate";
		try {
			Session session =  this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<DetailScheduleDate> listResult = query.list();
			return listResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int getMaxDetailScheduleDateID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select Max(d.detailScheduleDateID) From DetailScheduleDate d";
			Query query = session.createQuery(sql);
			return (int)query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	@Override
	public DetailScheduleDate getDetailScheduleByID(int detailScheduleID) {
		String sql = "select d from DetailScheduleDate d where d.detailScheduleDateID = :strDetailScheduleID";
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("strDetailScheduleID", detailScheduleID);
			return (DetailScheduleDate) query.list().get(0);			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}

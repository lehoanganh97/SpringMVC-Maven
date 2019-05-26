package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.ScheduleDateDAO;
import com.servicingportal.entity.ScheduleDate;

@Transactional
public class ScheduleDateDAOImpl implements ScheduleDateDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createScheduleDate(ScheduleDate scheduleDate) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(scheduleDate);
			session.beginTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleDate> listAllScheduleDate() {
		String sql = "select s from ScheduleDate s";
		try {
			Session session =  this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<ScheduleDate> listResult = query.list();
			return listResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int getMaxScheduleDateID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select Max(s.ScheduleDateID) From ScheduleDate s";
			Query query = session.createQuery(sql);
			return (int)query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	@Override
	public ScheduleDate getScheduleDateByID(int scheduleDateID) {
		String sql = "select s from ScheduleDate s where s.scheduleDateID = :strScheduleID";
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("strScheduleID", scheduleDateID);
			return (ScheduleDate) query.list().get(0);			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}

package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.ScheduleManageDAO;
import com.servicingportal.entity.PartnerAccount;
import com.servicingportal.entity.ScheduleManage;

@Transactional
public class ScheduleManageDAOImpl implements ScheduleManageDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean createScheduleManage(ScheduleManage scheduleManage) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(scheduleManage);
			session.beginTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleManage> listAllScheduleManage() {
		String sql = "select s from ScheduleManage s";
		try {
			Session session =  this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<ScheduleManage> listResult = query.list();
			return listResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int getMaxScheduleManageID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select Max(s.ScheduleManage) From ScheduleManage s";
			Query query = session.createQuery(sql);
			return (int)query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	@Override
	public ScheduleManage getScheduleManageByID(int scheduleManageID) {
		String sql = "select s from ScheduleManage s where s.scheduleManageID = :strScheduleManageID";
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("strScheduleManageID", scheduleManageID);
			return (ScheduleManage) query.list().get(0);			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<PartnerAccount> getListPartnerAccountBySchedule(int ScheduleID) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

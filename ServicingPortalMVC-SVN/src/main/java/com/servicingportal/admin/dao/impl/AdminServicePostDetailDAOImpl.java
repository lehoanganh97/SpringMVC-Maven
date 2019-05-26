package com.servicingportal.admin.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.servicingportal.admin.dao.AdminServicePostDetailDAO;
import com.servicingportal.entity.ServicePostDetail;

@Transactional
@Repository
public class AdminServicePostDetailDAOImpl implements  AdminServicePostDetailDAO{
	@Autowired
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePostDetail> getServicePostDetailByServicePostIDAndIsModify(int iServicePostID,boolean isModify) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String sql = "select spd from ServicePostDetail spd JOIN FETCH spd.servicepost where spd.servicepost.servicePostId = :iServicePostID and spd.isModify = :isModify";
			Query query = session.createQuery(sql); 
			query.setParameter("iServicePostID", iServicePostID);
			query.setParameter("isModify", isModify);
			List<ServicePostDetail> liServicePostDetail = query.list();
			
			return liServicePostDetail;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getServicePostDetailByServicePostIDAndIsModify : " + e.getMessage());
			return null;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePostDetail> getServicePostDetailByServicePostIDAndIsAccept(int iServicePostID, boolean isAccept) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String sql = "select spd from ServicePostDetail spd JOIN FETCH spd.servicepost where spd.servicepost.servicePostId = :iServicePostID and spd.isAccept = :isAccept";
			Query query = session.createQuery(sql);
			query.setParameter("iServicePostID", iServicePostID);
			query.setParameter("isAccept", isAccept);                                          
			List<ServicePostDetail> lspd = query.list();
			return lspd;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getServicePostDetailByServicePostIDAndIsAccept : " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public ServicePostDetail getServicePostDetailByID(int id) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "SELECT spd FROM ServicePostDetail spd WHERE spd.spdid= :ispdid";
			Query query = session.createQuery(sql);
			query.setParameter("ispdid", id);
			ServicePostDetail spd = (ServicePostDetail) query.getSingleResult();
			return spd;
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateServicePostDetail(ServicePostDetail servicePostDetail) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			session.update(servicePostDetail);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of updateServicePostDetailByServicePostDetailID : " + e.getMessage());
			return false;
		}
	}

}

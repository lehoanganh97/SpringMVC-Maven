package com.servicingportal.partner.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.entity.FieldService;
import com.servicingportal.partner.dao.PartnerFieldServiceDAO;
import com.servicingportal.partner.model.ShortFieldServiceInfo;

@Transactional
public class PartnerFieldServiceDAOImpl implements PartnerFieldServiceDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShortFieldServiceInfo> getShortFieldInfo() {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			String sql = "Select new "+ShortFieldServiceInfo.class.getName() 
					+" (fs.fserviceId, fs.fieldservice.fserviceId, fs.fserviceName, fs.fserviceDescription"
					+ ", fs.fserviceImage, fs.fserviceHref)"
					+ " from " + FieldService.class.getName() + " fs where fs.fieldservice = null";
			
			Query<ShortFieldServiceInfo> query = session.createQuery(sql);
			
			List<ShortFieldServiceInfo> fServiceInfos = query.getResultList();

			return fServiceInfos;
		}
		catch (Exception e) {
			e.printStackTrace();
	        return null;
		}
	}

	@Override
	public List<ShortFieldServiceInfo> getShortFieldServiceInfoByID(int FServiceID) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShortFieldServiceInfo> getShortFieldServiceInfoByParentID(int FServiceID) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			String sql = "Select new "+ShortFieldServiceInfo.class.getName() 
					+" (fs.fserviceId, fs.fieldservice.fserviceId, fs.fserviceName, fs.fserviceDescription"
					+ ", fs.fserviceImage, fs.fserviceHref)"
					+ " from " + FieldService.class.getName() + " fs where fs.fieldservice.fserviceId = " + FServiceID;
			
			Query<ShortFieldServiceInfo> query = session.createQuery(sql);
			
			List<ShortFieldServiceInfo> fServiceInfos = query.getResultList();
			
			return fServiceInfos;
		}
		catch (Exception e) {
			e.printStackTrace();
	        return null;
		}
	}

	@Override
	public FieldService getFieldServiceByID(int FServiceID) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			FieldService fService = (FieldService)session.get(FieldService.class, FServiceID);
			return fService;
		}
		catch (Exception e) {
			e.printStackTrace();
	        return null;
		}
	}

}

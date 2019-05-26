package com.servicingportal.partner.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.entity.DetailService;
import com.servicingportal.partner.dao.PartnerDetailServiceDAO;
import com.servicingportal.partner.model.ShortDetailServiceInfo;

@Transactional
public class PartnerDetailServiceDAOImpl implements PartnerDetailServiceDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShortDetailServiceInfo> getShortDetailServiceInfoByServiceID(int ServiceID) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			String sql = "Select new "+ShortDetailServiceInfo.class.getName() 
					+" (ds.detailServiceId, ds.detailServiceName, ds.detailServiceDescription)"
					+ " from " + DetailService.class.getName() + " ds where ds.fieldservice.fserviceId = " + ServiceID;
			
			Query<ShortDetailServiceInfo> query = session.createQuery(sql);
			
			List<ShortDetailServiceInfo> dServiceInfos = query.getResultList();

			return dServiceInfos;
		}
		catch (Exception e) {
			e.printStackTrace();
	        return null;
		}
	}

	@Override
	public DetailService getDetailServiceByID(int DetailServiceID) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			DetailService detailService = (DetailService)session.get(DetailService.class, DetailServiceID);
			return detailService;
		} catch (Exception e) {
			e.printStackTrace();
	        return null;
		}
	}

}

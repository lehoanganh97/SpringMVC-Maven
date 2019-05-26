package com.servicingportal.partner.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.entity.OrderService;
import com.servicingportal.partner.dao.PartnerOrderServiceDAO;

@Transactional
public class PartnerOrderServiceDAOImpl implements PartnerOrderServiceDAO{

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderService> getPartnerOrderService(int ipartnerID) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			String hql = "SELECT os FROM OrderService os WHERE os.PartnerID = :ipartnerID";
			Query query = session.createQuery(hql).setParameter("ipartnerID", ipartnerID);
			List<OrderService> listResult = query.list();
			return listResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int deleteOrderServicebyPartner(int iorderID) {
		// TODO Auto-generated method stub
		return 0;
	}

}

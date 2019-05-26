package com.servicingportal.partner.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.entity.PartnerAccount;
import com.servicingportal.partner.dao.PartnerPartnerAccountDAO;

@Transactional
public class PartnerPartnerAccountDAOImpl implements PartnerPartnerAccountDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public PartnerAccount getPartnerAccountByID(int PartnerID) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			PartnerAccount partnerAccount = (PartnerAccount)session.get(PartnerAccount.class, PartnerID);
			return partnerAccount;
		} catch (Exception e) {
			e.printStackTrace();
	        return null;
		}
	}

}

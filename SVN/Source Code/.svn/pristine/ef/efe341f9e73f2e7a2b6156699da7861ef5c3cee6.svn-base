package com.servicingportal.customer.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.customer.dao.CustomerAccountDAO;
import com.servicingportal.customer.model.CustomerProfile;
import com.servicingportal.entity.CustomerAccount;

@Transactional
public class CustomerAccountDAOImpl implements CustomerAccountDAO{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public CustomerProfile checkCustomerAccount(String strEmail, String strPass) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "SELECT ca.CustomerName FROM CustomerAccount WHERE ca.CustomerEmail = :strEmail and ca.CustomerPassword = :strPass";
			Query<CustomerProfile> query = session.createQuery(hql);
			query.setParameter("strEmail", strEmail);
			query.setParameter("strPass", strPass);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return new CustomerProfile();	
		}	
	}
	
	@Override
	public boolean createCustomerAccount(CustomerAccount customerAccount){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(customerAccount);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

}

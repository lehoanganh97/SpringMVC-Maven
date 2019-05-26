package com.servicingportal.customer.dao.impl;

import org.hibernate.query.Query;

import static org.junit.Assert.assertNull;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.customer.dao.CustomerAccountDAO;
import com.servicingportal.customer.model.CustomerProfile;
import com.servicingportal.entity.CustomerAccount;

@Transactional
@Repository
public class CustomerAccountDAOImpl implements CustomerAccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CustomerProfile checkCustomerAccount(String strEmail, String strPass) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "Select new " + CustomerProfile.class.getName()
					+ "(c.customerId, c.customerEmail, c.customerFullName, c.customerDob, c.customerImage) from CustomerAccount c where c.customerEmail = :strEmail and c.customerPassword = :strPass";
			Query<CustomerProfile> query = session.createQuery(hql);
			query.setParameter("strEmail", strEmail);
			query.setParameter("strPass", strPass);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errors: "+e.getMessage());
			return new CustomerProfile();	
		}	
	}

	@Override
	public boolean createCustomerAccount(CustomerAccount customerAccount) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(customerAccount);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public CustomerAccount getCustomerInformation(String strEmail, String strPass) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "SELECT ca FROM CustomerAccount as ca WHERE ca.customerEmail= :strEmail and ca.customerPassword = :strPass";
			TypedQuery<CustomerAccount> typedQuery = session.createQuery(hql).setParameter("strEmail", strEmail);
			typedQuery.setParameter("strPass", strPass);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

}

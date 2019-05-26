package com.servicingportal.admin.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.admin.model.AdminProfile;
import com.servicingportal.customer.model.CustomerProfile;
import com.servicingportal.entity.EmployeeAccount;

@Transactional
public class AdminLoginDAOImpl {
	private String queryLogin = "select new"+AdminProfile.class.getName()+"(empl.empId, empl.empFullName, empl.empImage, empl.empIdentityNumber) from "
								+EmployeeAccount.class.getName()+" empl where empl.empEmail = :strEmail and empl.empPassword = :strPass";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AdminProfile login(String strEmail, String strPass) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query<AdminProfile> query = session.createQuery(this.queryLogin);
			query.setParameter("strEmail", strEmail);
			query.setParameter("strPass", strPass);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errors: "+e.getMessage());
			return new AdminProfile();	
		}	
	}
}

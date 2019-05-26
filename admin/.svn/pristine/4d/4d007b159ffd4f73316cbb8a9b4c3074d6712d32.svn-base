package com.blackhole.dao;

import java.util.List;

//import javax.persistence.Query;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.blackhole.entities.EmployeeAccount;

@Repository
public class AdminActionDAOImpl implements AdminActionDAO {
	@Autowired
	private SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeAccount> getStaffs(){
		//get the current hibernate session
		Session session = factory.getCurrentSession();
		  
		// create a query to select all orders
		String sql="FROM EmployeeAccount";
		Query theQuery = session.createQuery(sql);
		   
		// execute query and get result list
//		List<EmployeeAccount> staffs = theQuery.getResultList();
		  
		// return the result
		
		return theQuery.list();
	}
}

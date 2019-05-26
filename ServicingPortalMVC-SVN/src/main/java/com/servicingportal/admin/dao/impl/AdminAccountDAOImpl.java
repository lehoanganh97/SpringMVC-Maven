package com.servicingportal.admin.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.servicingportal.admin.dao.AdminAccountDAO;
import com.servicingportal.entity.EmployeeAccount;

@Transactional
@Repository
public class AdminAccountDAOImpl implements AdminAccountDAO {
	@Autowired 
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public EmployeeAccount getEmployeeAccountByEmployeeId(int emId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "select e from EmployeeAccount e where e.empId = :iEmId";
			Query query = session.createQuery(sql).setParameter("iEmId", emId);
			EmployeeAccount employeeAccount = (EmployeeAccount) query.getSingleResult();
			return employeeAccount;
		}
		catch(Exception ex) {
			System.out.println("error 1 : " +ex.getMessage());
			return null;
		}
	}
}

package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.EmployeeAccountDAO;
import com.servicingportal.entity.EmployeeAccount;

@SuppressWarnings("unused")
@Transactional
public class EmployeeAccountDAOImpl implements EmployeeAccountDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean createEmployeeAccount(EmployeeAccount empl){
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(empl);//đối tượng được tạo tại Controller
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean updateEmployeeAccount(EmployeeAccount empl){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(empl);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}		
	}
	
	public boolean deleteEmployeeAccount(int emplID, EmployeeAccount employeeAdmin){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			EmployeeAccount employeeAccount = this.getEmployeeAccountByID(emplID);
	        //session.delete(EmployeeAccount);
			employeeAccount.setIsActive((byte)0);
			employeeAccount.setEmployeeaccount2(employeeAdmin);//set InActiveBy
			boolean check = this.updateEmployeeAccount(employeeAccount);
	        return check;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public EmployeeAccount checkEmployeeAccount(String strEmplEmail, String strEmplPass){
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select e from EmployeeAccount e where e.empEmail = :strEmail and e.empPassword = :strPass";
		Query query = session.createQuery(sql);
		query.setParameter("strEmail", strEmplEmail);
		query.setParameter("strPass", strEmplPass);
		EmployeeAccount result = (EmployeeAccount) query.list().get(0);
		if( result == null ){
			return null;
		}
		return result;
	}
	
	public EmployeeAccount getEmployeeAccountByID(int iEmplID){
//		String sql = "Select e From EmployeeAccount e Where e.EmployeeID = :iEmplID";
//		try{
//			Session session = this.sessionFactory.getCurrentSession();
//			Query query = session.createQuery(sql);
//			query.setParameter("iEmplID", iEmplID);
//			return (EmployeeAccount) query.list().get(0);
//		}catch (Exception e) {
//			// TODO: handle exception
//			// diễm
//			System.out.println(e.getMessage());
//			return null;
//		}
		//diễm 22/10/2018
		try {
			Session session = this.sessionFactory.getCurrentSession();
			EmployeeAccount em = (EmployeeAccount) session.get(EmployeeAccount.class, iEmplID);
			return em;
		} catch(Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeAccount> getlistEmployeeAccount(){
		String sql = "Select e From EmployeeAccount e";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<EmployeeAccount> result = query.list();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public EmployeeAccount getEmployeeAccountByEmail(String strEmail){
		String sql = "Select e From EmployeeAccount e Where e.EmployeeEmail = :strEmail";
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("strEmail", strEmail);
			return (EmployeeAccount) query.list().get(0);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public List<EmployeeAccount> searchEmployeeAccountByName(String strName){
		return null;
	}
	
	public int getMaxEmployeeAccountID() {
		String sql = "Seclect Max(e.EmployeeID) From EmployeeAccount e";
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			return (int)query.list().get(0);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
}

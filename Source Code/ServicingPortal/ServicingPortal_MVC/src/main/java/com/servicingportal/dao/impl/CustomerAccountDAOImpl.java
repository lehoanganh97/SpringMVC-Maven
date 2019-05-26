package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.CustomerAccountDAO;
import com.servicingportal.entity.CustomerAccount;
import org.hibernate.Query;

@Transactional
public class CustomerAccountDAOImpl implements CustomerAccountDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean createCustomerAccount(CustomerAccount CustomerAccount){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			/*QuyDH fix function persist -> save 20/10/2018*/
			//session.persist(CustomerAccount); //đối tượng được tạo tại Controller bao gồm đầy đủ set
			//session.getTransaction().commit();
			session.save(CustomerAccount);
			/*End fix*/
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean editCustomerAccount(CustomerAccount CustomerAccount){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(CustomerAccount);
			session.beginTransaction().commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}		
	}
	
	public boolean deleteCustomerAccount(int iID){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			CustomerAccount CustomerAccount = this.getInformationCustomerAccountByID(iID);
	        session.delete(CustomerAccount);
	        session.beginTransaction().commit();
    	return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public CustomerAccount checkCustomerAccount(String strEmail, String strPass){
		try {
			Session session = this.sessionFactory.getCurrentSession();
			/*QuyDH fix tham số 20/10/2018*/
			//String sql = "Select c from CustomerAccount c where c.CustomerEmail = :strEmail and c.CustomerPassword = :strPass ";
			String sql = "Select c from CustomerAccount c where c.customerEmail = :strEmail and c.customerPassword = :strPass ";
			/*End fix*/
			Query query = session.createQuery(sql);
			query.setParameter("strEmail", strEmail);
			query.setParameter("strPass", strPass);
			CustomerAccount result = (CustomerAccount) query.list().get(0);
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public CustomerAccount getInformationCustomerAccountByID(int iID){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			CustomerAccount CustomerAccount = (CustomerAccount) session.get(CustomerAccount.class, iID);
			if(CustomerAccount == null){
				return null;
			}
			return CustomerAccount;
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public List<CustomerAccount> getListCustomerAccount(){
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select u from CustomerAccount u";
			@SuppressWarnings("unchecked")
			List<CustomerAccount> list = session.createQuery(sql).list();
			return list;
		} catch (Exception e){
			return null;
		}	
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerAccount> getListCustomerAccountByEmail(String strEmail){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select u from CustomerAccount u where u.customerEmail = :strEmail";
			Query query = session.createQuery(sql);
			query.setParameter("strEmail", strEmail);
			List<CustomerAccount> liCustomerAccount = query.list();
			return liCustomerAccount;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomerAccount> searchCustomerAccountByName(String strName){
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select u from CustomerAccount u where u.customerFullName like :strName1 or u.customerFullName like :strName2 or u.customerFullName like :strName3";
			Query query = session.createQuery(sql);
			query.setParameter("strName1", strName+"%");
			query.setParameter("strName2", "%"+strName+"%");
			query.setParameter("strName2", "%"+strName);
			List<CustomerAccount> liCustomerAccount = query.list();
			return liCustomerAccount;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public int getMaxCustomerAccountID(){
		String sql = "Select Max(u.customerID) From CustomerAccount u";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			int result = (int) query.list().get(0);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
}

package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.PartnerAccountDAO;
import com.servicingportal.entity.OrderService;
import com.servicingportal.entity.PartnerAccount;

@Transactional
public class PartnerAccountDAOImpl implements PartnerAccountDAO{
	//@Autowired //QuyDH delete 21/10/2018
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean createPartnerAccount(PartnerAccount PartnerAccount){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			/*QuyDH Fix persist -> save*/
			//session.persist(PartnerAccount);
			//session.beginTransaction().commit();
			session.save(PartnerAccount);
			/* QuyDH End Update*/
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean deletePartnerAccount(int iPartnerID){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(this.getPartnerByID(iPartnerID));
			session.beginTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean editPartnerAccount(PartnerAccount PartnerAccount){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.update(PartnerAccount);
			session.beginTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public PartnerAccount getPartnerByID(int iPartnerID){
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select * from partneraccount where PartnerID = " + iPartnerID;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(PartnerAccount.class);
			PartnerAccount partnerAccount = (PartnerAccount)query.list().get(0);
			return partnerAccount;
		} catch (Exception e) {
			return null;
		}
		
		/*try {
			Session session =  this.sessionFactory.getCurrentSession();
			PartnerAccount part = (PartnerAccount)session.get(PartnerAccount.class, iPartnerID);
			return part;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		*/
	}
	
	public PartnerAccount checkPartnerAccount(String strUserName, String strPass){
		/*QuyDH Fix checkAccount 21/10/2018*/
		//String sql = "Select p From PartnerAccount p Where p.partnerEmail like :strEmail and p.partnerPassword like :strPass and p.IsAccept = 1";
		String sql = "Select p From PartnerAccount p Where p.partnerEmail = :strEmail and p.partnerPassword = :strPass";
		/*QuyDH End Update*/
		try {
			Session session =  this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("strEmail", strUserName);
			query.setParameter("strPass", strPass);
			return (PartnerAccount) query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<PartnerAccount> listAllPartnerAccount(){
		String sql = "Select p From PartnerAccount p";
		try {
			Session session =  this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<PartnerAccount> listResult = query.list();
			return listResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<PartnerAccount> listPartnerAccountUncheck(){
		String sql = "Select p From PartnerAccount p Where p.isAccept = 0";
		try {
			Session session =  this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<PartnerAccount> listResult = query.list();
			return listResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
	
	public PartnerAccount searchPartnerAccountByEmail(String strEmail){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select p from PartnerAccount p Where p.partnerEmail like :strEmail";
			Query query = session.createQuery(sql);
			query.setParameter("strEmail", strEmail);
			return (PartnerAccount) query.list().get(0);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public int getMaxPartnerAccountID(){
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select Max(p.partnerID) From PartnerAccount p";
			Query query = session.createQuery(sql);
			return (int)query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}		
	}
	
}

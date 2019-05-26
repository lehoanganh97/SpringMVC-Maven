package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.DetailServiceDAO;
import com.servicingportal.entity.DetailService;

@Transactional
public class DetailServiceDAOImpl implements DetailServiceDAO {
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetailService> listAllDetailService() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<DetailService> list = session.createQuery("from DetailService").list();
			return list;
		} catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean createDetailService(DetailService dservice) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
		    session.persist(dservice);
		    session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public int getMaxDetailServiceID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(a.detailServiceID) from DetailService a ";
		    Query query = session.createQuery(sql);
		    Integer maxdetailServiceID = (Integer) query.uniqueResult();
		    if (maxdetailServiceID == null) {
		    	return -1;
		    }
		    return maxdetailServiceID;
		} catch(Exception e){
			return -1;
		}
	}

	@Override
	public DetailService getDetailServiceByID(int id) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			DetailService dservice = (DetailService)session.get(DetailService.class, id);
			return dservice;
		} catch(Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailService> getDetailServiceByFServiceID(int fServiceID) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String Sql = "Select ds From DetailService ds Where ds.fieldservice.FServiceID = :iID";
			Query query = session.createQuery(Sql);
			query.setParameter("iID",fServiceID);
			List<DetailService> liDetailService = query.list();
			return liDetailService;
		}catch(Exception e)
		{
			System.out.println("Error of getDetailServiceByFServiceID: "+e.getMessage());
			return null;
		}
	}

}

package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.DetailOrderDAO;
import com.servicingportal.entity.DetailOrder;

@Transactional
public class DetailOrderDAOImpl implements DetailOrderDAO{

	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetailOrder> listDetailOrder() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<DetailOrder> list = session.createQuery("from DetailOrder").list();
			return list;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean createDetailOrder(DetailOrder detailOrder) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			transaction  = session.beginTransaction();
			session.persist(detailOrder);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			System.out.println("Exception here: " + e.getMessage());
			return false;
		}
	}
	
	@Override
	public int getMaxDetailOrderID() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select max(do.detailOrderID) from DetailOrder do ";
	    Query query = session.createQuery(sql);
	    Integer detailOrderID = (Integer) query.uniqueResult();
	    if (detailOrderID == null) {
	    	return 0;
	    }
	    return detailOrderID;
	}
	@Override
	public DetailOrder getDetailOrderbyID(int idetailOrderID) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			DetailOrder dorder = (DetailOrder)session.get(DetailOrder.class, idetailOrderID);
			return dorder;
		} catch (Exception e) {
			return null;
		}
	}

	// Xem chi tiết đơn hàng: Diễm 03/11/2018
	@SuppressWarnings("unchecked")
	@Override
	public List<DetailOrder> getDetailOrderByOrderService(int orderServiceID) {
		// TODO Auto-generated method stub
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "select do from DetailOrder do where do.orderservice.orderID = :orderServiceID" ;
			Query query = session.createQuery(sql);
			query.setParameter("orderServiceID", orderServiceID);
			List<DetailOrder> ldOrder = query.list();
			return ldOrder;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

}

package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.ServicePostDAO;
import com.servicingportal.entity.ServicePost;
import java.math.BigInteger;
import static java.lang.Math.toIntExact;

@Transactional
public class ServicePostDAOImpl implements ServicePostDAO {
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePost> listAllServicePost() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<ServicePost> list = session.createQuery("from ServicePost").list();
			return list;
		} catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public int createServicePost(ServicePost servicepost) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.save(servicepost);
			//Long lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
			return servicepost.getServicePostID();
		}
		catch(Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	@Override
	public int getMaxServicePostID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(a.ServicePostID) from ServicePost a ";
		    Query query = session.createQuery(sql);
		    Integer maxServicePostID = (Integer) query.uniqueResult();
		    if (maxServicePostID == null) {
		    	return -1;
		    }
		    return maxServicePostID;
		} catch(Exception e){
			return -1;
		}
	}

	@Override
	public ServicePost getServicePostByID(int id) {
		String sql = "Select sp From ServicePost sp Where sp.servicePostID = :iID";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("iID", id);
			return (ServicePost) query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePost> getListServicePostByPartnerID(int partnerID) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String Sql = "Select s From ServicePost s Where s.partneraccount.partnerID = :iID";
			Query query = session.createQuery(Sql);
			query.setParameter("iID",partnerID);
			List<ServicePost> liServicePost = query.list();
			return liServicePost;
		}catch(Exception e)
		{
			System.out.println("Error of getServicePostByPartnerID: "+e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePost> getListServicePostByFserviceID(int fserviceID) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String Sql = "Select s From ServicePost s Where s.fieldservice.FServiceID = :iID";
			Query query = session.createQuery(Sql);
			query.setParameter("iID",fserviceID);
			List<ServicePost> liServicePost = query.list();
			return liServicePost;
		}catch(Exception e)
		{
			System.out.println("Error of getServicePostByFserviceID: "+e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePost> getListServicePostByListDetailService(List<String> liID) {
		// TODO Auto-generated method stub
		StringBuilder sql= new StringBuilder("SELECT sp.* FROM servicepost sp left join servicepostdetail spd on sp.ServicePostID = spd.ServicePostID where spd.DetailServiceID in (");
		for(int i =0;i<liID.size()-1;i++)
		{
			sql.append(liID.get(i)+",");
		}
		sql.append(liID.get(liID.size()-1)+") group by sp.ServicePostID");
		Session session = this.sessionFactory.getCurrentSession();
		try{
			SQLQuery query = session.createSQLQuery(new String(sql));
			query.addEntity(ServicePost.class);
			List<ServicePost> liServicePost = query.list();
			return liServicePost;
			
		}catch(Exception e)
		{
			System.out.println("Error of getListServicePostByLdistDetailService: "+ e.getMessage());
			return null;
		}
		
	}

	// Lấy danh sách bài đăng theo isAccept -- isAccept = 0: bài đăng mới, isAccept = 1: bài đăng cũ
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePost> getListServicePostByIsAccept(byte isAccept) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String sql = "select sp from ServicePost sp where sp.isAccept = :isAccept";
			Query query = session.createQuery(sql);
			query.setParameter("isAccept", isAccept);
			List<ServicePost> lsp = query.list();
			return lsp;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of get ListServicePost By IsAccept " + e.getMessage());
			return null;
		}
	}

	//Lấy danh sách bài đăng theo isModify -- isModify = 1: bài đăng đang sửa
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePost> getListServicePostByIsModify(byte isModify) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			String sql = "select sp from ServicePost sp where sp.isModify = :isModify";
			Query query = session.createQuery(sql);
			query.setParameter("isModify", isModify);
			List<ServicePost> lsp = query.list();
			return lsp;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error get List ServicePost By Is Modify : "+ e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateServicePost(ServicePost servicePost) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		try{
			session.update(servicePost);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error updateServicePost : " + e.getMessage());
			return false;
		}
	}
}

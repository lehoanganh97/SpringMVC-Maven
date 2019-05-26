package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.ServicePostDetailDAO;
import com.servicingportal.entity.DetailService;
import com.servicingportal.entity.ServicePost;
import com.servicingportal.entity.ServicePostDetail;

@Transactional
public class ServicePostDetailDAOImpl implements ServicePostDetailDAO {
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePostDetail> listAllServicePostDetail() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<ServicePostDetail> list = session.createQuery("from ServicePostDetail").list();
			return list;
		} catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public int createServicePostDetail(ServicePostDetail servicepostdetail) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
		    session.save(servicepostdetail);
			return servicepostdetail.getSpdID();
		}
		catch(Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	@Override
	public int getMaxServicePostDetailID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(a.servicePostDetailID) from ServicePostDetail a ";
		    Query query = session.createQuery(sql);
		    Integer maxservicePostDetailID = (Integer) query.uniqueResult();
		    if (maxservicePostDetailID == null) {
		    	return -1;
		    }
		    return maxservicePostDetailID;
		} catch(Exception e){
			return -1;
		}
	}

	@Override
	public ServicePostDetail getServicePostDetailByID(int id) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			ServicePostDetail spd = (ServicePostDetail)session.get(ServicePostDetail.class, id);
			return spd;
		} catch(Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePostDetail> getDetailServicePostByServicePostID(int inServicePostID) {
		String Sql = "Select s From ServicePostDetail s Where s.servicepost.servicePostID = :iID";
		
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(Sql);
			query.setParameter("iID",inServicePostID);
			List<ServicePostDetail> liDetailServicePost = query.list();
			return liDetailServicePost;
		}catch(Exception e)
		{
			System.out.println("Error of getDetailServicePostByServicePostID: "+e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePostDetail> getDetailServicePostByServicePostAndDetailService(List<ServicePost> liServicePost,
			List<DetailService> liDetailService) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String sql = "Select spd From ServicePostDetail spd Where spd.detailservice in (:listDetailService) AND spd.servicepost in (:liServicePost)";
			Query query = session.createQuery(sql);
			query.setParameter("listDetailService", liDetailService);
			query.setParameter("liServicePos", liServicePost);
			List<ServicePostDetail> liServicePostDetail = query.list();
			return liServicePostDetail;
		}catch(Exception e)
		{
			System.out.println("Error of getDetailServicePostByServicePostAndDetailService: "+e.getMessage());
			return null;
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePostDetail> getServicePostDetailByServicePostIDAndIsModify(int iServicePostID,byte isModify) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String sql = "select spd from ServicePostDetail spd where spd.servicepost.servicePostID = :iServicePostID and spd.isModify = :isModify";
			Query query = session.createQuery(sql);
			query.setParameter("iServicePostID", iServicePostID);
			query.setParameter("isModify", isModify);
			List<ServicePostDetail> liServicePostDetail = query.list();
			return liServicePostDetail;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getServicePostDetailByServicePostIDAndIsModify : " + e.getMessage());
			return null;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePostDetail> getServicePostDetailByServicePostIDAndIsAccept(int iServicePostID, byte isAccept) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			String sql = "select spd from ServicePostDetail spd where spd.servicepost.servicePostID = :iServicePostID and spd.isAccept = :isAccept";
			Query query = session.createQuery(sql);
			query.setParameter("iServicePostID", iServicePostID);
			query.setParameter("isAccept", isAccept);
			List<ServicePostDetail> lspd = query.list();
			return lspd;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getServicePostDetailByServicePostIDAndIsAccept : " + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateServicePostDetail(ServicePostDetail servicePostDetail) {
		Session session = this.sessionFactory.getCurrentSession();
		try{
			session.update(servicePostDetail);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of updateServicePostDetailByServicePostDetailID : " + e.getMessage());
			return false;
		}
	}

}

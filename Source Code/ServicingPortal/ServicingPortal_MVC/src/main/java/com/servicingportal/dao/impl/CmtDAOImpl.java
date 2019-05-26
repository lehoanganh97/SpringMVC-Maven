package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.CmtDAO;
import com.servicingportal.entity.Comment;

@Transactional
public class CmtDAOImpl implements CmtDAO {
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listAllComment() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<Comment> list = session.createQuery("from Comment").list();
			return list;
		} catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public boolean createCmt(Comment cmt) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
		    session.persist(cmt);
		    session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public int getMaxCommentID() {
		// TODO Auto-generated method stub
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(c.cmtID) from Comment c ";
			Query query = session.createQuery(sql);
			Integer maxCmtID = (Integer) query.uniqueResult();
			if (maxCmtID == null) {
				return -1;
			}
			return maxCmtID;
		} catch(Exception e) {
			return -1;
		}
	}

	@Override
	public Comment getCommentByID(int cmtID) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Comment cmt = (Comment) session.get(Comment.class, cmtID);
			return cmt;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getCommentByID: "+e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getListCommentByServicePostID(int idServicePost) {
		// TODO Auto-generated method stub
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select c From Comment  c Where c.servicepost.servicePostID = :iID";
			Query query = session.createQuery(sql);
			query.setParameter("iID",idServicePost);
			List<Comment> liComments = query.list();
			return liComments;

		}catch(Exception e)
		{
			System.out.println("Error of getListCommentByServicePostID: "+e.getMessage());
			return null;
		}	
	}
	@Override
	public boolean reviewsOrder(Comment cmt, int iorderStatus, int iServicePostID) {
		// TODO Auto-generated method stub
		try {
			if (iServicePostID==0) {
				return false;
			}
			if (iorderStatus==3) {
				Session session = this.sessionFactory.getCurrentSession();
				session.save(cmt);
			}
			return true;
		} catch (Exception e){
			return false;
		}
	}
}

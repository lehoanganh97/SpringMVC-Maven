package com.servicingportal.admin.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.servicingportal.admin.dao.AdminServicePostDAO;
import com.servicingportal.entity.ServicePost;

@Transactional
@Repository
public class AdminServicePostDAOImpl implements AdminServicePostDAO {
	@Autowired
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	// Lấy danh sách bài đăng theo isAccept -- isAccept = 0: bài đăng mới, isAccept = 1: bài đăng cũ
	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePost> getListServicePostByIsAccept(boolean isAccept) {
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
	public List<ServicePost> getListServicePostByIsModify(boolean isModify) {
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
	public ServicePost getServicePostByID(int id) {
		String sql = "Select sp From ServicePost sp Where sp.servicePostId = :iID";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("iID", id);
			ServicePost sPost = (ServicePost) query.getSingleResult();
			return sPost;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public boolean updateServicePost(ServicePost servicePost) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		try
		{
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

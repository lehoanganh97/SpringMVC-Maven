package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.ImageCategoryDAO;
import com.servicingportal.entity.ImageCategory;

@Transactional
public class ImageCategoryDAOImpl implements ImageCategoryDAO{
	
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ImageCategory> listImageCategory() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<ImageCategory> list = session.createQuery("from ImageCategory").list();
			return list;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean createImageCategory(ImageCategory imageCategory) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(imageCategory);
			session.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public int getMaxImageCategoryID() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(ic.imgCatID) from ImageCategory ic ";
		    Query query = session.createQuery(sql);
		    Integer imgCatID = (Integer) query.uniqueResult();
		    if (imgCatID == null) {
		    	return -1;
		    }
		    return imgCatID;
		} catch(Exception e) {
			return -1;
		}
	}

	@Override
	public ImageCategory getImageCategorybyID(int iimgCatID) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			ImageCategory ic = (ImageCategory)session.get(ImageCategory.class, iimgCatID);
			return ic;
		} catch(Exception e) {
			return null;
		}
	}
	

}

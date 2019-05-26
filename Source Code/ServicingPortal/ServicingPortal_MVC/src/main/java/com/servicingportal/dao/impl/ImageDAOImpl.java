package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.ImageDAO;
import com.servicingportal.entity.Image;

@Transactional
public class ImageDAOImpl implements ImageDAO{

	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Image> listImage() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<Image> list = session.createQuery("from Image").list();
			return list;
		} catch(Exception e) {
			return null;					
		}
	}

	@Override
	public boolean createImage(Image image) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(image);
			session.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public int getMaxImageID() {
		// TODO Auto-generated method stub
		try{
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(i.imageID) from Image i ";
		    Query query = session.createQuery(sql);
		    Integer imageID = (Integer) query.uniqueResult();
		    if (imageID == null) {
		    	return -1;
		    }
		    return imageID;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public Image getImagebyID(int iimageID) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Image img = (Image)session.get(Image.class, iimageID);
			return img;
		} catch(Exception e) {
			return null;
		}
	}
}

package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.AreaDAO;
import com.servicingportal.entity.Area;

@Transactional
public class AreaDAOImpl implements AreaDAO {
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Area> listAllArea() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<Area> list = session.createQuery("from Area").list();
			return list;
		} catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean createArea(Area area) {
		// TODO Auto-generated method stub
		try{
			Session session = this.sessionFactory.getCurrentSession();
		    session.persist(area);
		    session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			// TODO: handle exception
			return false;
		}		
	}

	@Override
	public int getMaxAreaID() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(a.areaID) from Area a ";
		    Query query = session.createQuery(sql);
		    Integer maxAreaID = (Integer) query.uniqueResult();
		    if (maxAreaID == null) {
		    	return -1;
		    }
		    return maxAreaID;
		} catch(Exception e){
			return -1;
		}
		
	}

	@Override
	public Area getAreaByID(int areaid) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Area area = (Area)session.get(Area.class, areaid);
			return area;
		} catch(Exception e) {
			return null;
		}
	}

}

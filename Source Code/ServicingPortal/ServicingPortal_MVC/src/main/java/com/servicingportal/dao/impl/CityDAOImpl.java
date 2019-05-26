package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.servicingportal.dao.CityDAO;
import com.servicingportal.entity.City;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CityDAOImpl implements CityDAO {
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> listAllCity() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<City> list = session.createQuery("from City").list();
			return list;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean createCity(City city) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
		    session.persist(city);
		    session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public int getMaxCityID() {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(c.cityID) from City c ";
		    Query query = session.createQuery(sql);
		    Integer maxCityID = (Integer) query.uniqueResult();
		    if (maxCityID == null) {
		    	return -1;
		    }
		    return maxCityID;
		} catch (Exception e) {
			return -1;
		}
		
	}

	@Override
	public City getCityByID(int cityID) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			City city = (City)session.get(City.class, cityID);
			return city;
		} catch(Exception e) {
			return null;
		}
	}
}

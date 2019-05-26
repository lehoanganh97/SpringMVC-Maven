package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.RoleDAO;
import com.servicingportal.entity.Role;

@Transactional
public class RoleDAOImpl implements RoleDAO{
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createRole(Role role) {
		boolean checkCreate = true;
		
		try{
			// Phước 1/10/2018
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(role);
		}catch(Exception e)
		{
			System.out.println("Error of createRole: "+e.getMessage());
			checkCreate = false;
		}
		return checkCreate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getListRole() {
		// TODO Auto-generated method stub
		// Phước 1/10/2018
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<Role> liRole = session.createQuery("from Role").list();
			return liRole;
		} catch (Exception e){
			return null;
		}
	}
	
	@Override
	public Role getRoleByID(int idRole) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		try{
			Role role = (Role) session.get(Role.class, idRole);
			return role;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getRoleByID: "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public int getMaxRoleID() {
		// TODO Auto-generated method stub
		//Phước 1/10/2018
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(r.roleID) from Role r ";
		    Query query = session.createQuery(sql);
		    Integer inMaxRoleID = (Integer) query.uniqueResult();
		    if (inMaxRoleID == null) {
		    	return -1;
		    }
		    return inMaxRoleID;
		} catch (Exception e) {
			return -1;
		}
	}
}

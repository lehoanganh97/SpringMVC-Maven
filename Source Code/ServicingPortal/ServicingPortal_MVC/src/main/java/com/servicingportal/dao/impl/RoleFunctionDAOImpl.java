package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.RoleFunctionDAO;
import com.servicingportal.entity.RoleFunction;

@Transactional
public class RoleFunctionDAOImpl implements RoleFunctionDAO {
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createRoleFunction(RoleFunction roleFunction) {
		// TODO Auto-generated method stub
		try{
			// Phước 1/10/2018
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(roleFunction);
			session.beginTransaction().commit();
			return true;
		}catch(Exception e)
		{
			System.out.println("Error of createRole: "+e.getMessage());
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleFunction> getListRoleFunction() {
		// TODO Auto-generated method stub
		// Phước 1/10/2018
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<RoleFunction> liRole = session.createQuery("from RoleFunction").list();
			return liRole;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public RoleFunction getRoleFunctionByID(int idRoleFunction) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		try{
			RoleFunction role = (RoleFunction) session.get(RoleFunction.class, idRoleFunction);
			return role;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getRoleFunctionByID: "+e.getMessage());
			return null;
		}
	}

	@Override
	public int getMaxRoleFunctionID() {
		//Phước 1/10/2018
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(r.roleFuncID) from RoleFunction r ";
			Query query = session.createQuery(sql);
			Integer inMaxRoleFunctionID = (Integer) query.uniqueResult();
			if (inMaxRoleFunctionID == null) {
				  return -1;
			}
			return inMaxRoleFunctionID;	
		} catch (Exception e) {
			return -1;
		}
	}
}

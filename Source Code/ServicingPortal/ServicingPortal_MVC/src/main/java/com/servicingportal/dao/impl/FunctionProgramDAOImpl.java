package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.FunctionProgramDAO;
import com.servicingportal.entity.FunctionProgram;


@Transactional
public class FunctionProgramDAOImpl implements FunctionProgramDAO{
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean createFunctionProgram(FunctionProgram functionProgram) {
		// TODO Auto-generated method stub
		try{
			// Phước 1/10/2018
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(functionProgram);
			session.beginTransaction().commit();
			return true;
		}catch(Exception e)
		{
			System.out.println("Error of createFunctionProgram: "+e.getMessage());
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FunctionProgram> getListFuctionProgram() {
		// TODO Auto-generated method stub
		//Phước 1/10/2018
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<FunctionProgram> liFunctionProgram = session.createQuery("from FunctionProgram").list();
			return liFunctionProgram;
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public FunctionProgram getFunctionProgramByID(int idFunctionProgram) {
		// TODO Auto-generated method stub
	//Phước 1/10/2018
		try{
			Session session = this.sessionFactory.getCurrentSession();
			FunctionProgram functionProgram = (FunctionProgram) session.get(FunctionProgram.class, idFunctionProgram);
			return functionProgram;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getFunctionProgramByID: "+e.getMessage());
			return null;
		}
	}

	@Override
	public int getMaxFunctionProgramID() {
		// TODO Auto-generated method stub
		//Phước 1/10/2018
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = "Select max(f.funcID) from FinctionProgram f ";
		    Query query = session.createQuery(sql);
		    Integer inMaxFunctionProgramID = (Integer) query.uniqueResult();
		    if (inMaxFunctionProgramID == null) {
		    	return -1;
		    }
		    return inMaxFunctionProgramID;
		} catch(Exception e) {
			return -1;
		}
		
	}

}

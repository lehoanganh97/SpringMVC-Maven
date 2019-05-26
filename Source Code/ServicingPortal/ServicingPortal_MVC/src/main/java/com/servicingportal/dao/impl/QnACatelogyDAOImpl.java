package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.QnACatelogyDAO;
import com.servicingportal.entity.QnACatelogy;

@Transactional
public class QnACatelogyDAOImpl implements QnACatelogyDAO{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<QnACatelogy> listQnACatelogy(){
		String sql = "Select q From QnACatelogy q";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<QnACatelogy> liResult = query.list();
			return liResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public boolean createQnACatelogy(QnACatelogy qnaCatelogy){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			/*QuyDH fix presist -> save 23/10/2018*/
			//session.persist(qna); //đối tượng được tạo tại Controller bao gồm đầy đủ set
			//session.getTransaction().commit();
			session.save(qnaCatelogy);
			/*QuyDH EndFix*/
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public int getMaxQnACatelogyID(){
		String sql = "Select Max(q.qnACatelogyID) From QnACatelogy q";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			return (int)query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	/*QuyDH fix kiểu trả về DAOImpl 20/10/2018*/
	//public QnA getQnACatelogyByID(int iQnAID){
	public QnACatelogy getQnACatelogyByID(int iQnAID){	
		try {
			Session session = this.sessionFactory.getCurrentSession();
			//QnA qna = (QnA)session.get(QnA.class, iQnAID);
			/*End fix*/	
			QnACatelogy qna = (QnACatelogy)session.get(QnACatelogy.class, iQnAID);
			return qna;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}

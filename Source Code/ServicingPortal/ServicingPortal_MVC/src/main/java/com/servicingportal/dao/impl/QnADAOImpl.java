package com.servicingportal.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.servicingportal.dao.QnADAO;
import com.servicingportal.entity.QnA;

@Transactional
public class QnADAOImpl implements QnADAO{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<QnA> listQnA(){
		String sql = "Select q From QnA q";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<QnA> liResult = query.list();
			return liResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public boolean createQnA(QnA qna){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			/*QuyDH fix presist -> save 23/10/2018*/
			//session.persist(qna); //đối tượng được tạo tại Controller bao gồm đầy đủ set
			//session.getTransaction().commit();
			session.save(qna);
			/*QuyDH EndFix*/
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public int getMaxQnAID(){
		String sql = "Select Max(q.qnAID) From QnA q";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			return (int)query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public QnA getQnAByID(int iQnAID){
		String sql = "Select q From QnA q Where q.qnAID = :iID";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			query.setParameter("iID", iQnAID);
			return (QnA) query.list().get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	/*QuyDH Update Function 30/10/2018*/
	public boolean editQnaA(QnA qna) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(qna);
			//session.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<QnA> listQnANullAnwser(){
		String sql = "Select q From QnA q where q.qnAISReply = 0";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(sql);
			List<QnA> liResult = query.list();
			return liResult;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	/*QuyDH EndUpdate 30/10/2018*/
}

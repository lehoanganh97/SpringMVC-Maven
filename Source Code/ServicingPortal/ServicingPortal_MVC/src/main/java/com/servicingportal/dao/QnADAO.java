package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.QnA;

public interface QnADAO {
	public List<QnA> listQnA();
	public boolean createQnA(QnA qna);
	public int getMaxQnAID();
	public QnA getQnAByID(int iQnAID);
	/*QuyDH update function 30/10/2018*/
	public boolean editQnaA(QnA qna);
	List<QnA> listQnANullAnwser();
	/*QuyDH End Update 30/10/2018*/
}

package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.QnACatelogy;

public interface QnACatelogyDAO {
	public List<QnACatelogy> listQnACatelogy();
	public boolean createQnACatelogy(QnACatelogy qnaCatelogy);
	public int getMaxQnACatelogyID();
	/*QuyDH fix DAO 20/10/2018*/
	//public QnA getQnACatelogyByID(int iQnAID);
	public QnACatelogy getQnACatelogyByID(int iQnAID);
	/*End fix*/
}

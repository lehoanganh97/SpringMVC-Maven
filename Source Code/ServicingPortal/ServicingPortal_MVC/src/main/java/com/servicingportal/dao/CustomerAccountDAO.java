package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.CustomerAccount;



public interface CustomerAccountDAO {
	public boolean createCustomerAccount(CustomerAccount CustomerAccount);//Nếu để void thì sao bắt lỗi trả về? Dùng try catch cả ở Bean và Logic? 
	public boolean editCustomerAccount(CustomerAccount CustomerAccount);
	public boolean deleteCustomerAccount(int iID);
	public List<CustomerAccount> getListCustomerAccountByEmail(String strEmail);
	public List<CustomerAccount> searchCustomerAccountByName(String name);
	public CustomerAccount checkCustomerAccount(String strEmail, String strPass);
	public CustomerAccount getInformationCustomerAccountByID(int iID);
	public List<CustomerAccount> getListCustomerAccount();
	public int getMaxCustomerAccountID();
}

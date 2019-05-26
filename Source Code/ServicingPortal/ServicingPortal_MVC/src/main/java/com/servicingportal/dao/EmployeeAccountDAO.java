package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.EmployeeAccount;

public interface EmployeeAccountDAO {
	public boolean createEmployeeAccount(EmployeeAccount empl);
	public boolean updateEmployeeAccount(EmployeeAccount empl);
	public boolean deleteEmployeeAccount(int emplID, EmployeeAccount employeeAdmin);
	public EmployeeAccount getEmployeeAccountByEmail(String strEmail);
	public List<EmployeeAccount> searchEmployeeAccountByName(String strName);
	public EmployeeAccount checkEmployeeAccount(String strEmplEmail, String strEmplPass);
	public EmployeeAccount getEmployeeAccountByID(int iEmplID);
	public List<EmployeeAccount> getlistEmployeeAccount();
	public int getMaxEmployeeAccountID();
}

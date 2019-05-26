package com.blackhole.dao;

import java.util.List;

import com.blackhole.entities.EmployeeAccount;

public interface AdminActionDAO {
	//get accounts under role of admin 
	public List<EmployeeAccount> getStaffs();
	//create a new account and set role
//	public int createNewAccountStaff(EmployeeAccount employeeAccount);
	//
}

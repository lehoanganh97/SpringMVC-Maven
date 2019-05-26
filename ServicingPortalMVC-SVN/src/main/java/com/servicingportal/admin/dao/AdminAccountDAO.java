package com.servicingportal.admin.dao;

import com.servicingportal.entity.EmployeeAccount;

public interface AdminAccountDAO {
	public EmployeeAccount getEmployeeAccountByEmployeeId(int emId);
}

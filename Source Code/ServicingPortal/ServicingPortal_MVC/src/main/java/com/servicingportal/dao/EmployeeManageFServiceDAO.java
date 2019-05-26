package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.EmployeeManageFservice;

public interface EmployeeManageFServiceDAO {
	public List<EmployeeManageFservice> listEmployeeMangerFservice();
	public boolean creatEmployeeManageFservice(EmployeeManageFservice eManageFservice);
	public int getMaxEmployeeManageFserviceID();
	public EmployeeManageFservice getEmployeeManageFservicebyID(int iemfID); // EmployeeManageFservice == emf
}

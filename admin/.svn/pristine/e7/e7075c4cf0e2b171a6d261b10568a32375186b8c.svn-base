package com.blackhole.service;

import java.util.List;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackhole.dao.AdminActionDAO;

import com.blackhole.entities.EmployeeAccount;

@Service
public class AdminActionServiceImpl implements AdminActionService {
	@Autowired
	private AdminActionDAO adminActionDAO;
	@Override
	@Transactional
	//get accounts under role of admin 
	public List<EmployeeAccount> getStaffs(){
		return adminActionDAO.getStaffs();
	}
//	@Override
//	@Transactional
//	//create a new account and set role
//	public int createNewAccountStaff(EmployeeAccount employeeAccount) {
//		return adminActionDAO.createNewAccountStaff(employeeAccount);
//	}

}

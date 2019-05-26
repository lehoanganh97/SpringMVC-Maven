package com.portalservice.service;

import java.util.List;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicingportal.admin.dao.AdminActionDAO;

import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.FieldService;
import com.servicingportal.entity.Role;


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
	
	@Override
	@Transactional
	public void saveStaff(EmployeeAccount theStaff) {
		adminActionDAO.saveStaff(theStaff);
	}

	@Override
	@Transactional
    public EmployeeAccount getStaff(int theId) {
		return adminActionDAO.getStaff(theId);
	}
	
	@Override
	@Transactional
    public void deleteStaff(int theId) {
		adminActionDAO.deleteStaff(theId);
	}

	@Override
	@Transactional
	public List<Role> getAllRolesToCreateAccount(){
		return adminActionDAO.getAllRolesToCreateAccount();
	}
	
	@Override
	@Transactional
	public List<FieldService> getAllFieldsToCreateAccount(){
		return adminActionDAO.getAllFieldsToCreateAccount();
	}
	
	@Override
	@Transactional
	public Role getRole(int theId) {
		return adminActionDAO.getRole(theId);
	}
}

package com.portalservice.service;

import java.util.List;

import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.FieldService;
import com.servicingportal.entity.Role;

public interface AdminActionService {
	//get accounts under role of admin 
	public List<EmployeeAccount> getStaffs();
	
	public void saveStaff(EmployeeAccount theStaff);

    public EmployeeAccount getStaff(int theId);

    public void deleteStaff(int theId);
    
    public List<Role> getAllRolesToCreateAccount();
    
    public List<FieldService> getAllFieldsToCreateAccount();
    
    public Role getRole(int theId);
}

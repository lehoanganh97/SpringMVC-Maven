package com.blackhole.service;

import java.util.List;

import com.blackhole.entities.EmployeeAccount;
import com.blackhole.entities.FieldService;
import com.blackhole.entities.Role;

public interface AdminActionService {
	//get accounts under role of admin 
	public List<EmployeeAccount> getStaffs();
	
	public void saveStaff(EmployeeAccount theStaff);

    public EmployeeAccount getStaff(int theId);

    public void deleteStaff(int theId);
    
    public List<Role> getAllRolesToCreateAccount();
    
    public List<FieldService> getAllFieldsToCreateAccount();
    
    public Role getRole(String theId);
}

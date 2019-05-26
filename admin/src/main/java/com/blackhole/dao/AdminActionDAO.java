package com.blackhole.dao;

import java.util.List;
import com.blackhole.entities.Role;

import com.blackhole.entities.EmployeeAccount;
import com.blackhole.entities.FieldService;

public interface AdminActionDAO {
	//get accounts under role of admin 
	public List<EmployeeAccount> getStaffs();
	
	public void saveStaff(EmployeeAccount theStaff);

    public EmployeeAccount getStaff(int theId);

    public void deleteStaff(int theId);
    
    public List<Role> getAllRolesToCreateAccount();
    
    public List<FieldService> getAllFieldsToCreateAccount();
    
    public Role getRole(int theId);
    
//    public Role getRoleToView(int theId);
}

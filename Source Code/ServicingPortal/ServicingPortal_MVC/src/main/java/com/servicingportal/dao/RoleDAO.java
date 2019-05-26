package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.Role;

public interface RoleDAO {
	// Phước 1/10/2019
	public boolean createRole(Role role);
	public List<Role> getListRole();
	public Role getRoleByID(int idRole);
	public int getMaxRoleID();
}

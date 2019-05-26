package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.RoleFunction;

public interface RoleFunctionDAO {
	public boolean createRoleFunction(RoleFunction roleFunction);
	public List<RoleFunction> getListRoleFunction();
	public RoleFunction getRoleFunctionByID(int idRoleFunction);
	public int getMaxRoleFunctionID();
}

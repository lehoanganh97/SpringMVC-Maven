package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name = "role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role  {
	@Id
	@GeneratedValue
	private int roleID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	private String roleDescription;

	private String roleName;

	//bi-directional many-to-one association to EmployeeAccount
	@OneToMany(mappedBy="role", fetch=FetchType.LAZY)
	private List<EmployeeAccount> employeeaccounts;

	//bi-directional many-to-one association to RoleFunction
	@OneToMany(mappedBy="role", fetch=FetchType.LAZY)
	private List<RoleFunction> rolefunctions;

	public Role() {
	}

	public int getRoleID() {
		return this.roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<EmployeeAccount> getEmployeeaccounts() {
		return this.employeeaccounts;
	}

	public void setEmployeeaccounts(List<EmployeeAccount> employeeaccounts) {
		this.employeeaccounts = employeeaccounts;
	}

	public EmployeeAccount addEmployeeaccount(EmployeeAccount employeeaccount) {
		getEmployeeaccounts().add(employeeaccount);
		employeeaccount.setRole(this);

		return employeeaccount;
	}

	public EmployeeAccount removeEmployeeaccount(EmployeeAccount employeeaccount) {
		getEmployeeaccounts().remove(employeeaccount);
		employeeaccount.setRole(null);

		return employeeaccount;
	}

	public List<RoleFunction> getRolefunctions() {
		return this.rolefunctions;
	}

	public void setRolefunctions(List<RoleFunction> rolefunctions) {
		this.rolefunctions = rolefunctions;
	}

	public RoleFunction addRolefunction(RoleFunction rolefunction) {
		getRolefunctions().add(rolefunction);
		rolefunction.setRole(this);

		return rolefunction;
	}

	public RoleFunction removeRolefunction(RoleFunction rolefunction) {
		getRolefunctions().remove(rolefunction);
		rolefunction.setRole(null);

		return rolefunction;
	}

}
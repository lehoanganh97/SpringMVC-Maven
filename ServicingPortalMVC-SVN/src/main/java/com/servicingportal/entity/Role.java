package com.servicingportal.entity;
// Generated Mar 1, 2019 9:23:01 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role")
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private String roleName;
	private String roleDescription;
	private Date createDate;
	private Date modifyDate;
	private Set<RoleFunction> rolefunctions = new HashSet<RoleFunction>(0);
	private Set<EmployeeAccount> employeeaccounts = new HashSet<EmployeeAccount>(0);

	public Role() {
	}

	public Role(String roleName, Date createDate, Date modifyDate) {
		this.roleName = roleName;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public Role(String roleName, String roleDescription, Date createDate, Date modifyDate,
			Set<RoleFunction> rolefunctions, Set<EmployeeAccount> employeeaccounts) {
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.rolefunctions = rolefunctions;
		this.employeeaccounts = employeeaccounts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "RoleID", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "RoleName", nullable = false, length = 100)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "RoleDescription", length = 500)
	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ModifyDate", nullable = false, length = 19)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RoleFunction> getRolefunctions() {
		return this.rolefunctions;
	}

	public void setRolefunctions(Set<RoleFunction> rolefunctions) {
		this.rolefunctions = rolefunctions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<EmployeeAccount> getEmployeeaccounts() {
		return this.employeeaccounts;
	}

	public void setEmployeeaccounts(Set<EmployeeAccount> employeeaccounts) {
		this.employeeaccounts = employeeaccounts;
	}

}

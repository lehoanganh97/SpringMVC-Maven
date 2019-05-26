package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rolefunction database table.
 * 
 */
@Entity
@Table(name = "rolefunction")
@NamedQuery(name="RoleFunction.findAll", query="SELECT r FROM RoleFunction r")
public class RoleFunction  {
	@Id
	@GeneratedValue
	private int roleFuncID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private byte isActive;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CreateBy")
	private EmployeeAccount employeeaccount1;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="InActiveBy")
	private EmployeeAccount employeeaccount2;

	//bi-directional many-to-one association to FunctionProgram
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FuncID")
	private FunctionProgram functionprogram;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="RoleID")
	private Role role;

	public RoleFunction() {
	}

	public int getRoleFuncID() {
		return this.roleFuncID;
	}

	public void setRoleFuncID(int roleFuncID) {
		this.roleFuncID = roleFuncID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public EmployeeAccount getEmployeeaccount1() {
		return this.employeeaccount1;
	}

	public void setEmployeeaccount1(EmployeeAccount employeeaccount1) {
		this.employeeaccount1 = employeeaccount1;
	}

	public EmployeeAccount getEmployeeaccount2() {
		return this.employeeaccount2;
	}

	public void setEmployeeaccount2(EmployeeAccount employeeaccount2) {
		this.employeeaccount2 = employeeaccount2;
	}

	public FunctionProgram getFunctionprogram() {
		return this.functionprogram;
	}

	public void setFunctionprogram(FunctionProgram functionprogram) {
		this.functionprogram = functionprogram;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
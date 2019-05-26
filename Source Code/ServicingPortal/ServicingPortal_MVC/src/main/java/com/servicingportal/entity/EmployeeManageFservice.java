package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the employeemanagefservice database table.
 * 
 */
@Entity
@Table(name = "employeemanagefservice")
@NamedQuery(name="EmployeeManageFservice.findAll", query="SELECT e FROM EmployeeManageFservice e")
public class EmployeeManageFservice  {
	@Id
	@GeneratedValue
	private int emfID;

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

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EmpManageID")
	private EmployeeAccount employeeaccount3;

	//bi-directional many-to-one association to FieldService
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FServiceID")
	private FieldService fieldservice;

	public EmployeeManageFservice() {
	}

	public int getEmfID() {
		return this.emfID;
	}

	public void setEmfID(int emfID) {
		this.emfID = emfID;
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

	public EmployeeAccount getEmployeeaccount3() {
		return this.employeeaccount3;
	}

	public void setEmployeeaccount3(EmployeeAccount employeeaccount3) {
		this.employeeaccount3 = employeeaccount3;
	}

	public FieldService getFieldservice() {
		return this.fieldservice;
	}

	public void setFieldservice(FieldService fieldservice) {
		this.fieldservice = fieldservice;
	}

}
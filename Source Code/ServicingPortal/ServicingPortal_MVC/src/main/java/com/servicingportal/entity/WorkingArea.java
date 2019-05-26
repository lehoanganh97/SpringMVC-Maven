package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the workingarea database table.
 * 
 */
@Entity
@Table(name = "workingarea")
@NamedQuery(name="WorkingArea.findAll", query="SELECT w FROM WorkingArea w")
public class WorkingArea  {
	@Id
	@GeneratedValue
	private int workAreaID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private byte isAccept;

	private byte isActive;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	private int workingFeeTransport;

	//bi-directional many-to-one association to Area
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AreaID")
	private Area area;

	//bi-directional many-to-one association to City
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CityID")
	private City city;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AcceptBy")
	private EmployeeAccount employeeaccount1;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="InActiveBy")
	private EmployeeAccount employeeaccount2;

	//bi-directional many-to-one association to PartnerAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PartnerID")
	private PartnerAccount partneraccount;

	public WorkingArea() {
	}

	public int getWorkAreaID() {
		return this.workAreaID;
	}

	public void setWorkAreaID(int workAreaID) {
		this.workAreaID = workAreaID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getIsAccept() {
		return this.isAccept;
	}

	public void setIsAccept(byte isAccept) {
		this.isAccept = isAccept;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getWorkingFeeTransport() {
		return this.workingFeeTransport;
	}

	public void setWorkingFeeTransport(int workingFeeTransport) {
		this.workingFeeTransport = workingFeeTransport;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public PartnerAccount getPartneraccount() {
		return this.partneraccount;
	}

	public void setPartneraccount(PartnerAccount partneraccount) {
		this.partneraccount = partneraccount;
	}

}
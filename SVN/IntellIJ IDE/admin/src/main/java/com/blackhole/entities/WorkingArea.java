package com.blackhole.entities;
// Generated Mar 1, 2019 9:23:01 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Workingarea generated by hbm2java
 */
@Entity
@Table(name = "workingarea", catalog = "servicingportaldb")
public class WorkingArea implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer workAreaId;
	private Area area;
	private City city;
	private EmployeeAccount employeeaccountByInActiveBy;
	private EmployeeAccount employeeaccountByAcceptBy;
	private PartnerAccount partneraccount;
	private Integer workingFeeTransport;
	private boolean isAccept;
	private Date createDate;
	private Date modifyDate;
	private boolean isActive;

	public WorkingArea() {
	}

	public WorkingArea(Area area, City city, EmployeeAccount employeeaccountByInActiveBy,
			EmployeeAccount employeeaccountByAcceptBy, PartnerAccount partneraccount, boolean isAccept, Date createDate,
			Date modifyDate, boolean isActive) {
		this.area = area;
		this.city = city;
		this.employeeaccountByInActiveBy = employeeaccountByInActiveBy;
		this.employeeaccountByAcceptBy = employeeaccountByAcceptBy;
		this.partneraccount = partneraccount;
		this.isAccept = isAccept;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.isActive = isActive;
	}

	public WorkingArea(Area area, City city, EmployeeAccount employeeaccountByInActiveBy,
			EmployeeAccount employeeaccountByAcceptBy, PartnerAccount partneraccount, Integer workingFeeTransport,
			boolean isAccept, Date createDate, Date modifyDate, boolean isActive) {
		this.area = area;
		this.city = city;
		this.employeeaccountByInActiveBy = employeeaccountByInActiveBy;
		this.employeeaccountByAcceptBy = employeeaccountByAcceptBy;
		this.partneraccount = partneraccount;
		this.workingFeeTransport = workingFeeTransport;
		this.isAccept = isAccept;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "WorkAreaID", unique = true, nullable = false)
	public Integer getWorkAreaId() {
		return this.workAreaId;
	}

	public void setWorkAreaId(Integer workAreaId) {
		this.workAreaId = workAreaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AreaID", nullable = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CityID", nullable = false)
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "InActiveBy", nullable = false)
	public EmployeeAccount getEmployeeaccountByInActiveBy() {
		return this.employeeaccountByInActiveBy;
	}

	public void setEmployeeaccountByInActiveBy(EmployeeAccount employeeaccountByInActiveBy) {
		this.employeeaccountByInActiveBy = employeeaccountByInActiveBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AcceptBy", nullable = false)
	public EmployeeAccount getEmployeeaccountByAcceptBy() {
		return this.employeeaccountByAcceptBy;
	}

	public void setEmployeeaccountByAcceptBy(EmployeeAccount employeeaccountByAcceptBy) {
		this.employeeaccountByAcceptBy = employeeaccountByAcceptBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PartnerID", nullable = false)
	public PartnerAccount getPartneraccount() {
		return this.partneraccount;
	}

	public void setPartneraccount(PartnerAccount partneraccount) {
		this.partneraccount = partneraccount;
	}

	@Column(name = "WorkingFeeTransport")
	public Integer getWorkingFeeTransport() {
		return this.workingFeeTransport;
	}

	public void setWorkingFeeTransport(Integer workingFeeTransport) {
		this.workingFeeTransport = workingFeeTransport;
	}

	@Column(name = "IsAccept", nullable = false)
	public boolean isIsAccept() {
		return this.isAccept;
	}

	public void setIsAccept(boolean isAccept) {
		this.isAccept = isAccept;
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

	@Column(name = "IsActive", nullable = false)
	public boolean isIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}

package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the webdatacontent database table.
 * 
 */
@Entity
@Table(name = "webdatacontent")
@NamedQuery(name="WebDataContent.findAll", query="SELECT w FROM WebDataContent w")
public class WebDataContent  {
	@Id
	@GeneratedValue
	private int wdcID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	private String WDCContent;

	private String WDCImage;

	private String WDCName;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CreateUpdateBy")
	private EmployeeAccount employeeaccount;

	public WebDataContent() {
	}

	public int getWdcID() {
		return this.wdcID;
	}

	public void setWdcID(int wdcID) {
		this.wdcID = wdcID;
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

	public String getWDCContent() {
		return this.WDCContent;
	}

	public void setWDCContent(String WDCContent) {
		this.WDCContent = WDCContent;
	}

	public String getWDCImage() {
		return this.WDCImage;
	}

	public void setWDCImage(String WDCImage) {
		this.WDCImage = WDCImage;
	}

	public String getWDCName() {
		return this.WDCName;
	}

	public void setWDCName(String WDCName) {
		this.WDCName = WDCName;
	}

	public EmployeeAccount getEmployeeaccount() {
		return this.employeeaccount;
	}

	public void setEmployeeaccount(EmployeeAccount employeeaccount) {
		this.employeeaccount = employeeaccount;
	}

}
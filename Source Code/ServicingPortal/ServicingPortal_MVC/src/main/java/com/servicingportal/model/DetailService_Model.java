package com.servicingportal.model;

import java.util.Date;

public class DetailService_Model {
	private int DetailServiceID;
	private int FServiceID;
	private int TypeServiceID;
	private int CreateBy;
	private String DetailServiceName;
	private String DetailServiceDescription;
	private Date CreateDate;
	public int getDetailServiceID() {
		return DetailServiceID;
	}
	public void setDetailServiceID(int detailServiceID) {
		DetailServiceID = detailServiceID;
	}
	public int getFServiceID() {
		return FServiceID;
	}
	public void setFServiceID(int fServiceID) {
		FServiceID = fServiceID;
	}
	public int getTypeServiceID() {
		return TypeServiceID;
	}
	public void setTypeServiceID(int typeServiceID) {
		TypeServiceID = typeServiceID;
	}
	public int getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(int createBy) {
		CreateBy = createBy;
	}
	public String getDetailServiceName() {
		return DetailServiceName;
	}
	public void setDetailServiceName(String detailServiceName) {
		DetailServiceName = detailServiceName;
	}
	public String getDetailServiceDescription() {
		return DetailServiceDescription;
	}
	public void setDetailServiceDescription(String detailServiceDescription) {
		DetailServiceDescription = detailServiceDescription;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	
	
}

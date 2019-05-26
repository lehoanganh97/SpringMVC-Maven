package com.servicingportal.model;

import java.util.Date;

public class FieldService_Model {
	private int FServiceID;
	private String FServiceName;
	private String FServiceDescription;

	private String FServiceHref;
	private Date createDate;
	private String FServiceImage;
	
	public int getFServiceID() {
		return FServiceID;
	}
	public void setFServiceID(int fServiceID) {
		FServiceID = fServiceID;
	}
	
	public String getFServiceName() {
		return FServiceName;
	}
	public void setFServiceName(String fServiceName) {
		FServiceName = fServiceName;
	}
	
	public String getFServiceDescription() {
		return FServiceDescription;
	}
	public void setFServiceDescription(String fServiceDescription) {
		FServiceDescription = fServiceDescription;
	}
	
	public String getFServiceHref() {
		return FServiceHref;
	}
	public void setFServiceHref(String fServiceHref) {
		FServiceHref = fServiceHref;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getFServiceImage() {
		return FServiceImage;
	}
	public void setFServiceImage(String fServiceImage) {
		FServiceImage = fServiceImage;
	}	
}

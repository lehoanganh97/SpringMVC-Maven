package com.servicingportal.partner.model;

public class ShortFieldServiceInfo {
	private Integer FServiceID;
	private Integer Parent_FieldServiceID;
	private String FServiceName;
	private String FServiceDescription;
	private String FServiceImage;
	private String FServiceHref;
	
	public ShortFieldServiceInfo(Integer ID, Integer PID, String Name, String Description, String Img, String Href) {
		this.FServiceID = ID;
		this.Parent_FieldServiceID = PID;
		this.FServiceName = Name;
		this.FServiceDescription = Description;
		this.FServiceImage = Img;
		this.FServiceHref = Href;
	}
	
	public Integer getFServiceID() {
		return FServiceID;
	}
	public void setFServiceID(Integer fServiceID) {
		FServiceID = fServiceID;
	}
	public Integer getParent_FieldServiceID() {
		return Parent_FieldServiceID;
	}
	public void setParent_FieldServiceID(Integer parent_FieldServiceID) {
		Parent_FieldServiceID = parent_FieldServiceID;
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
	public String getFServiceImage() {
		return FServiceImage;
	}
	public void setFServiceImage(String fServiceImage) {
		FServiceImage = fServiceImage;
	}
	public String getFServiceHref() {
		return FServiceHref;
	}
	public void setFServiceHref(String fServiceHref) {
		FServiceHref = fServiceHref;
	}
}

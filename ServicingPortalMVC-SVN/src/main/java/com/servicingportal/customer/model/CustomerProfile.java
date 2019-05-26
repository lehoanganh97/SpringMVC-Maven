package com.servicingportal.customer.model;

import java.util.Date;

public class CustomerProfile {
	private int customerId;
	private String customerEmail;
	private String customerFullName;
	private String customerDob;
	private String customerImage;
	public CustomerProfile(){
		
	}
	public CustomerProfile(int customerId, String customerEmail, String customerFullName, Date customerDob,
			String customerImage) {
		super();
		this.customerId = customerId;
		this.customerEmail = customerEmail;
		this.customerFullName = customerFullName;
		this.customerDob = customerDob.toString();
		this.customerImage = customerImage;
	}
	public int getCustomerID() {
		return customerId;
	}
	public void setCustomerID(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public String getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDOB(String customerDob) {
		this.customerDob = customerDob;
	}
	public String getCustomerImage() {
		return customerImage;
	}
	public void setCustomerImage(String customerImage) {
		this.customerImage = customerImage;
	}
	
}

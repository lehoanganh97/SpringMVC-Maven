package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customeraccount database table.
 * 
 */
@Entity
@Table(name = "customeraccount")
@NamedQuery(name="CustomerAccount.findAll", query="SELECT c FROM CustomerAccount c")
public class CustomerAccount  {
	@Id
	@GeneratedValue
	private int customerID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String customerAddress;

	private String customerBankAccount;

	@Temporal(TemporalType.DATE)
	private Date customerDOB;

	private String customerEmail;

	private String customerFullName;

	private String customerIdentityNumber;

	private String customerImage;

	private String customerPassword;

	private String customerPhone;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	//bi-directional many-to-one association to OrderService
	@OneToMany(mappedBy="customeraccount", fetch=FetchType.LAZY)
	private List<OrderService> orderservices;

	public CustomerAccount() {
	}

	public int getCustomerID() {
		return this.customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerBankAccount() {
		return this.customerBankAccount;
	}

	public void setCustomerBankAccount(String customerBankAccount) {
		this.customerBankAccount = customerBankAccount;
	}

	public Date getCustomerDOB() {
		return this.customerDOB;
	}

	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerFullName() {
		return this.customerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public String getCustomerIdentityNumber() {
		return this.customerIdentityNumber;
	}

	public void setCustomerIdentityNumber(String customerIdentityNumber) {
		this.customerIdentityNumber = customerIdentityNumber;
	}

	public String getCustomerImage() {
		return this.customerImage;
	}

	public void setCustomerImage(String customerImage) {
		this.customerImage = customerImage;
	}

	public String getCustomerPassword() {
		return this.customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public List<OrderService> getOrderservices() {
		return this.orderservices;
	}

	public void setOrderservices(List<OrderService> orderservices) {
		this.orderservices = orderservices;
	}

	public OrderService addOrderservice(OrderService orderservice) {
		getOrderservices().add(orderservice);
		orderservice.setCustomeraccount(this);

		return orderservice;
	}

	public OrderService removeOrderservice(OrderService orderservice) {
		getOrderservices().remove(orderservice);
		orderservice.setCustomeraccount(null);

		return orderservice;
	}

}
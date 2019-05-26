package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orderservice database table.
 * 
 */
@Entity
@Table(name = "orderservice")
@NamedQuery(name="OrderService.findAll", query="SELECT o FROM OrderService o")
public class OrderService  {
	@Id
	@GeneratedValue
	private int orderID;

	private byte isAccept;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date acceptDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	private int payMethod;

	private int orderStatus;

	private int orderTotalPrice;

	private byte isDelete;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deleteDate;
	
	private String deleteNote;

	//bi-directional many-to-one association to DetailOrder
	@OneToMany(mappedBy="orderservice", fetch=FetchType.LAZY)
	private List<DetailOrder> detailorders;

	//bi-directional many-to-one association to CustomerAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CustomerID")
	private CustomerAccount customeraccount;

	//bi-directional many-to-one association to ServicePost
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ServicePostID")
	private ServicePost servicepost;

	public OrderService() {
	}

	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getAcceptDate() {
		return this.acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderTotalPrice() {
		return this.orderTotalPrice;
	}

	public void setOrderTotalPrice(int orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public List<DetailOrder> getDetailorders() {
		return this.detailorders;
	}

	public void setDetailorders(List<DetailOrder> detailorders) {
		this.detailorders = detailorders;
	}

	public DetailOrder addDetailorder(DetailOrder detailorder) {
		getDetailorders().add(detailorder);
		detailorder.setOrderservice(this);

		return detailorder;
	}

	public DetailOrder removeDetailorder(DetailOrder detailorder) {
		getDetailorders().remove(detailorder);
		detailorder.setOrderservice(null);

		return detailorder;
	}

	public CustomerAccount getCustomeraccount() {
		return this.customeraccount;
	}

	public void setCustomeraccount(CustomerAccount customeraccount) {
		this.customeraccount = customeraccount;
	}

	public ServicePost getServicepost() {
		return this.servicepost;
	}

	public void setServicepost(ServicePost servicepost) {
		this.servicepost = servicepost;
	}

	public byte getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(byte isAccept) {
		this.isAccept = isAccept;
	}

	public byte getIsDelete() {
		return isDelete;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public String getDeleteNote() {
		return deleteNote;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public void setDeleteNote(String deleteNote) {
		this.deleteNote = deleteNote;
	}

	public int getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(int payMethod) {
		this.payMethod = payMethod;
	}
}
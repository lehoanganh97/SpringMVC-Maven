package com.servicingportal.entity;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the detailorder database table.
 * 
 */
@Entity
@Table(name = "detailorder")
@NamedQuery(name="DetailOrder.findAll", query="SELECT d FROM DetailOrder d")
public class DetailOrder  {
	@Id
	@GeneratedValue
	private int detailOrderID;

	private String note;

	private int price;

	private int quantity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date usingDate;

	//bi-directional many-to-one association to Servicepostdetail
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DetailServicePostID")
	private ServicePostDetail servicepostdetail;

	//bi-directional many-to-one association to OrderService
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="OrderID")
	private OrderService orderservice;

	public DetailOrder() {
	}

	public int getDetailOrderID() {
		return this.detailOrderID;
	}

	public void setDetailOrderID(int detailOrderID) {
		this.detailOrderID = detailOrderID;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getUsingDate() {
		return this.usingDate;
	}

	public void setUsingDate(Date usingDate) {
		this.usingDate = usingDate;
	}

	public ServicePostDetail getServicepostdetail() {
		return this.servicepostdetail;
	}

	public void setServicepostdetail(ServicePostDetail servicepostdetail) {
		this.servicepostdetail = servicepostdetail;
	}

	public OrderService getOrderservice() {
		return this.orderservice;
	}

	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}

}
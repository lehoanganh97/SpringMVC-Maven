package com.blackhole.entities;
// Generated Mar 1, 2019 9:23:01 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Orderservice generated by hbm2java
 */
@Entity
@Table(name = "orderservice", catalog = "servicingportaldb")
public class OrderService implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private CustomerAccount customeraccount;
	private ServicePost servicepost;
	private Date createDate;
	private Integer payMethod;
	private Boolean isAccept;
	private Date acceptDate;
	private Integer orderTotalPrice;
	private Integer orderStatus;
	private Boolean isDelete;
	private Date deleteDate;
	private String deleteNote;
	private Set<DetailOrder> detailorders = new HashSet<DetailOrder>(0);

	public OrderService() {
	}

	public OrderService(CustomerAccount customeraccount, ServicePost servicepost, Date createDate, Integer payMethod,
			Boolean isAccept, Date acceptDate, Integer orderTotalPrice, Integer orderStatus, Boolean isDelete,
			Date deleteDate, String deleteNote, Set<DetailOrder> detailorders) {
		this.customeraccount = customeraccount;
		this.servicepost = servicepost;
		this.createDate = createDate;
		this.payMethod = payMethod;
		this.isAccept = isAccept;
		this.acceptDate = acceptDate;
		this.orderTotalPrice = orderTotalPrice;
		this.orderStatus = orderStatus;
		this.isDelete = isDelete;
		this.deleteDate = deleteDate;
		this.deleteNote = deleteNote;
		this.detailorders = detailorders;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OrderID", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerID")
	public CustomerAccount getCustomeraccount() {
		return this.customeraccount;
	}

	public void setCustomeraccount(CustomerAccount customeraccount) {
		this.customeraccount = customeraccount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ServicePostID")
	public ServicePost getServicepost() {
		return this.servicepost;
	}

	public void setServicepost(ServicePost servicepost) {
		this.servicepost = servicepost;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "PayMethod")
	public Integer getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	@Column(name = "IsAccept")
	public Boolean getIsAccept() {
		return this.isAccept;
	}

	public void setIsAccept(Boolean isAccept) {
		this.isAccept = isAccept;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AcceptDate", length = 19)
	public Date getAcceptDate() {
		return this.acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	@Column(name = "OrderTotalPrice")
	public Integer getOrderTotalPrice() {
		return this.orderTotalPrice;
	}

	public void setOrderTotalPrice(Integer orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	@Column(name = "OrderStatus")
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "isDelete")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DeleteDate", length = 19)
	public Date getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	@Column(name = "DeleteNote", length = 100)
	public String getDeleteNote() {
		return this.deleteNote;
	}

	public void setDeleteNote(String deleteNote) {
		this.deleteNote = deleteNote;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderservice")
	public Set<DetailOrder> getDetailorders() {
		return this.detailorders;
	}

	public void setDetailorders(Set<DetailOrder> detailorders) {
		this.detailorders = detailorders;
	}

}

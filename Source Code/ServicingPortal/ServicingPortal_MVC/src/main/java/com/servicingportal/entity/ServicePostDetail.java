package com.servicingportal.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicepostdetail database table.
 * 
 */
@Entity
@Table(name = "servicepostdetail")
@NamedQuery(name="ServicePostDetail.findAll", query="SELECT s FROM ServicePostDetail s")
public class ServicePostDetail  {
	@Id
	@GeneratedValue
	private int spdID;
	
	private byte isAccept;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private byte isModify;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	private int SPDPrice;

	private int SPDPriceNew;

	//bi-directional many-to-one association to DetailOrder
	@OneToMany(mappedBy="servicepostdetail")
	private List<DetailOrder> detailorders;
	
	//bi-directional many-to-one association to DetailService
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DetailServiceID")
	private DetailService detailservice;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AcceptBy")
	private EmployeeAccount employeeaccount;

	//bi-directional many-to-one association to ServicePost
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ServicePostID")
	private ServicePost servicepost;

	public ServicePostDetail() {
	}

	public int getSpdID() {
		return this.spdID;
	}

	public void setSpdID(int spdID) {
		this.spdID = spdID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getIsModify() {
		return this.isModify;
	}

	public void setIsModify(byte isModify) {
		this.isModify = isModify;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getSPDPrice() {
		return this.SPDPrice;
	}

	public void setSPDPrice(int SPDPrice) {
		this.SPDPrice = SPDPrice;
	}

	public int getSPDPriceNew() {
		return this.SPDPriceNew;
	}

	public void setSPDPriceNew(int SPDPriceNew) {
		this.SPDPriceNew = SPDPriceNew;
	}

	public DetailService getDetailservice() {
		return this.detailservice;
	}

	public void setDetailservice(DetailService detailservice) {
		this.detailservice = detailservice;
	}

	public EmployeeAccount getEmployeeaccount() {
		return this.employeeaccount;
	}

	public void setEmployeeaccount(EmployeeAccount employeeaccount) {
		this.employeeaccount = employeeaccount;
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

	public List<DetailOrder> getDetailorders() {
		return this.detailorders;
	}

	public void setDetailorders(List<DetailOrder> detailorders) {
		this.detailorders = detailorders;
	}

	public DetailOrder addDetailorder(DetailOrder detailorder) {
		getDetailorders().add(detailorder);
		detailorder.setServicepostdetail(this);

		return detailorder;
	}

	public DetailOrder removeDetailorder(DetailOrder detailorder) {
		getDetailorders().remove(detailorder);
		detailorder.setServicepostdetail(null);

		return detailorder;
	}
}
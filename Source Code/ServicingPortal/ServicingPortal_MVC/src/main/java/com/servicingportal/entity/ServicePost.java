package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicepost database table.
 * 
 */
@Entity
@Table(name = "servicepost")
@NamedQuery(name="ServicePost.findAll", query="SELECT s FROM ServicePost s")
public class ServicePost  {
	@Id
	@GeneratedValue
	private int servicePostID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private byte isAccept;

	private byte isModify;
	
	private byte isDelete;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

	@Lob
	private String servicePostContent;

	@Lob
	private String servicePostContentModify;

	@Lob
	private String servicePostContentOld;

	private String servicePostDescription;

	private float servicePostRate;

	private String servicePostTitle;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="servicepost", fetch=FetchType.LAZY)
	private List<Comment> comments;

	//bi-directional many-to-one association to ImageCategory
	@OneToMany(mappedBy="servicepost", fetch=FetchType.LAZY)
	private List<ImageCategory> imagecategories;

	//bi-directional many-to-one association to OrderService
	@OneToMany(mappedBy="servicepost", fetch=FetchType.LAZY)
	private List<OrderService> orderservices;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AcceptBy")
	private EmployeeAccount employeeaccount;

	//bi-directional many-to-one association to FieldService
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FServiceID")
	private FieldService fieldservice;

	//bi-directional many-to-one association to PartnerAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PartnerID")
	private PartnerAccount partneraccount;

	//bi-directional many-to-one association to ServicePostDetail
	@OneToMany(mappedBy="servicepost", fetch=FetchType.LAZY)
	private List<ServicePostDetail> servicepostdetails;

	public ServicePost() {
	}

	public int getServicePostID() {
		return this.servicePostID;
	}

	public void setServicePostID(int servicePostID) {
		this.servicePostID = servicePostID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getIsAccept() {
		return this.isAccept;
	}

	public void setIsAccept(byte isAccept) {
		this.isAccept = isAccept;
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

	public String getServicePostContent() {
		return this.servicePostContent;
	}

	public void setServicePostContent(String servicePostContent) {
		this.servicePostContent = servicePostContent;
	}

	public String getServicePostContentModify() {
		return this.servicePostContentModify;
	}

	public void setServicePostContentModify(String servicePostContentModify) {
		this.servicePostContentModify = servicePostContentModify;
	}

	public String getServicePostContentOld() {
		return this.servicePostContentOld;
	}

	public void setServicePostContentOld(String servicePostContentOld) {
		this.servicePostContentOld = servicePostContentOld;
	}

	public String getServicePostDescription() {
		return this.servicePostDescription;
	}

	public void setServicePostDescription(String servicePostDescription) {
		this.servicePostDescription = servicePostDescription;
	}

	public float getServicePostRate() {
		return this.servicePostRate;
	}

	public void setServicePostRate(float servicePostRate) {
		this.servicePostRate = servicePostRate;
	}

	public String getServicePostTitle() {
		return this.servicePostTitle;
	}

	public void setServicePostTitle(String servicePostTitle) {
		this.servicePostTitle = servicePostTitle;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setServicepost(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setServicepost(null);

		return comment;
	}

	public List<ImageCategory> getImagecategories() {
		return this.imagecategories;
	}

	public void setImagecategories(List<ImageCategory> imagecategories) {
		this.imagecategories = imagecategories;
	}

	public ImageCategory addImagecategory(ImageCategory imagecategory) {
		getImagecategories().add(imagecategory);
		imagecategory.setServicepost(this);

		return imagecategory;
	}

	public ImageCategory removeImagecategory(ImageCategory imagecategory) {
		getImagecategories().remove(imagecategory);
		imagecategory.setServicepost(null);

		return imagecategory;
	}

	public List<OrderService> getOrderservices() {
		return this.orderservices;
	}

	public void setOrderservices(List<OrderService> orderservices) {
		this.orderservices = orderservices;
	}

	public OrderService addOrderservice(OrderService orderservice) {
		getOrderservices().add(orderservice);
		orderservice.setServicepost(this);

		return orderservice;
	}

	public OrderService removeOrderservice(OrderService orderservice) {
		getOrderservices().remove(orderservice);
		orderservice.setServicepost(null);

		return orderservice;
	}

	public EmployeeAccount getEmployeeaccount() {
		return this.employeeaccount;
	}

	public void setEmployeeaccount(EmployeeAccount employeeaccount) {
		this.employeeaccount = employeeaccount;
	}

	public FieldService getFieldservice() {
		return this.fieldservice;
	}

	public void setFieldservice(FieldService fieldservice) {
		this.fieldservice = fieldservice;
	}

	public PartnerAccount getPartneraccount() {
		return this.partneraccount;
	}

	public void setPartneraccount(PartnerAccount partneraccount) {
		this.partneraccount = partneraccount;
	}

	public List<ServicePostDetail> getServicepostdetails() {
		return this.servicepostdetails;
	}

	public void setServicepostdetails(List<ServicePostDetail> servicepostdetails) {
		this.servicepostdetails = servicepostdetails;
	}

	public ServicePostDetail addServicepostdetail(ServicePostDetail servicepostdetail) {
		getServicepostdetails().add(servicepostdetail);
		servicepostdetail.setServicepost(this);

		return servicepostdetail;
	}

	public ServicePostDetail removeServicepostdetail(ServicePostDetail servicepostdetail) {
		getServicepostdetails().remove(servicepostdetail);
		servicepostdetail.setServicepost(null);

		return servicepostdetail;
	}

}
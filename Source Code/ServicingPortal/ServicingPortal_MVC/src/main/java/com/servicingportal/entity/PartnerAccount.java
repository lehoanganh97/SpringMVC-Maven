package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the partneraccount database table.
 * 
 */
@Entity
@Table(name = "partneraccount")
@NamedQuery(name="PartnerAccount.findAll", query="SELECT p FROM PartnerAccount p")
public class PartnerAccount  {
	@Id
	@GeneratedValue
	private int partnerID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private byte isAccept;

	private byte isModify;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	private String partnerAddress;

	private String partnerBankAccount;

	@Temporal(TemporalType.DATE)
	private Date partnerDOB;

	private String partnerEmail;

	private String partnerFullName;

	private String partnerIdentityNumber;

	private String partnerImage;

	private String partnerName;

	private String partnerPassword;

	private String partnerPhone;

	private int partnerType;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="partneraccount", fetch=FetchType.LAZY)
	private List<Image> images;

	//bi-directional many-to-one association to ImageCategory
	@OneToMany(mappedBy="partneraccount", fetch=FetchType.LAZY)
	private List<ImageCategory> imagecategories;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AcceptBy")
	private EmployeeAccount employeeaccount;

	//bi-directional many-to-one association to ScheduleManage
	@OneToMany(mappedBy="partneraccount", fetch=FetchType.LAZY)
	private List<ScheduleManage> schedulemanages;

	//bi-directional many-to-one association to ServicePost
	@OneToMany(mappedBy="partneraccount", fetch=FetchType.LAZY)
	private List<ServicePost> serviceposts;

	//bi-directional many-to-one association to WorkingArea
	@OneToMany(mappedBy="partneraccount", fetch=FetchType.LAZY)
	private List<WorkingArea> workingareas;

	public PartnerAccount() {
	}

	public int getPartnerID() {
		return this.partnerID;
	}

	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
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

	public String getPartnerAddress() {
		return this.partnerAddress;
	}

	public void setPartnerAddress(String partnerAddress) {
		this.partnerAddress = partnerAddress;
	}

	public String getPartnerBankAccount() {
		return this.partnerBankAccount;
	}

	public void setPartnerBankAccount(String partnerBankAccount) {
		this.partnerBankAccount = partnerBankAccount;
	}

	public Date getPartnerDOB() {
		return this.partnerDOB;
	}

	public void setPartnerDOB(Date partnerDOB) {
		this.partnerDOB = partnerDOB;
	}

	public String getPartnerEmail() {
		return this.partnerEmail;
	}

	public void setPartnerEmail(String partnerEmail) {
		this.partnerEmail = partnerEmail;
	}

	public String getPartnerFullName() {
		return this.partnerFullName;
	}

	public void setPartnerFullName(String partnerFullName) {
		this.partnerFullName = partnerFullName;
	}

	public String getPartnerIdentityNumber() {
		return this.partnerIdentityNumber;
	}

	public void setPartnerIdentityNumber(String partnerIdentityNumber) {
		this.partnerIdentityNumber = partnerIdentityNumber;
	}

	public String getPartnerImage() {
		return this.partnerImage;
	}

	public void setPartnerImage(String partnerImage) {
		this.partnerImage = partnerImage;
	}

	public String getPartnerName() {
		return this.partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerPassword() {
		return this.partnerPassword;
	}

	public void setPartnerPassword(String partnerPassword) {
		this.partnerPassword = partnerPassword;
	}

	public String getPartnerPhone() {
		return this.partnerPhone;
	}

	public void setPartnerPhone(String partnerPhone) {
		this.partnerPhone = partnerPhone;
	}

	public int getPartnerType() {
		return this.partnerType;
	}

	public void setPartnerType(int partnerType) {
		this.partnerType = partnerType;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setPartneraccount(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setPartneraccount(null);

		return image;
	}

	public List<ImageCategory> getImagecategories() {
		return this.imagecategories;
	}

	public void setImagecategories(List<ImageCategory> imagecategories) {
		this.imagecategories = imagecategories;
	}

	public ImageCategory addImagecategory(ImageCategory imagecategory) {
		getImagecategories().add(imagecategory);
		imagecategory.setPartneraccount(this);

		return imagecategory;
	}

	public ImageCategory removeImagecategory(ImageCategory imagecategory) {
		getImagecategories().remove(imagecategory);
		imagecategory.setPartneraccount(null);

		return imagecategory;
	}

	public EmployeeAccount getEmployeeaccount() {
		return this.employeeaccount;
	}

	public void setEmployeeaccount(EmployeeAccount employeeaccount) {
		this.employeeaccount = employeeaccount;
	}

	public List<ScheduleManage> getSchedulemanages() {
		return this.schedulemanages;
	}

	public void setSchedulemanages(List<ScheduleManage> schedulemanages) {
		this.schedulemanages = schedulemanages;
	}

	public ScheduleManage addSchedulemanage(ScheduleManage schedulemanage) {
		getSchedulemanages().add(schedulemanage);
		schedulemanage.setPartneraccount(this);

		return schedulemanage;
	}

	public ScheduleManage removeSchedulemanage(ScheduleManage schedulemanage) {
		getSchedulemanages().remove(schedulemanage);
		schedulemanage.setPartneraccount(null);

		return schedulemanage;
	}

	public List<ServicePost> getServiceposts() {
		return this.serviceposts;
	}

	public void setServiceposts(List<ServicePost> serviceposts) {
		this.serviceposts = serviceposts;
	}

	public ServicePost addServicepost(ServicePost servicepost) {
		getServiceposts().add(servicepost);
		servicepost.setPartneraccount(this);

		return servicepost;
	}

	public ServicePost removeServicepost(ServicePost servicepost) {
		getServiceposts().remove(servicepost);
		servicepost.setPartneraccount(null);

		return servicepost;
	}

	public List<WorkingArea> getWorkingareas() {
		return this.workingareas;
	}

	public void setWorkingareas(List<WorkingArea> workingareas) {
		this.workingareas = workingareas;
	}

	public WorkingArea addWorkingarea(WorkingArea workingarea) {
		getWorkingareas().add(workingarea);
		workingarea.setPartneraccount(this);

		return workingarea;
	}

	public WorkingArea removeWorkingarea(WorkingArea workingarea) {
		getWorkingareas().remove(workingarea);
		workingarea.setPartneraccount(null);

		return workingarea;
	}

}
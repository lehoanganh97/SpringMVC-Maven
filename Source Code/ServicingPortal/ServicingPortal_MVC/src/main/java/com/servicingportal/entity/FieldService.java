package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fieldservice database table.
 * 
 */
@Entity
@Table(name = "fieldservice")
@NamedQuery(name="FieldService.findAll", query="SELECT f FROM FieldService f")
public class FieldService  {
	@Id
	@GeneratedValue
	private int FServiceID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String FServiceDescription;

	private String FServiceHref;

	private String FServiceImage;

	private String FServiceName;

	//bi-directional many-to-one association to DetailService
	@OneToMany(mappedBy="fieldservice", fetch=FetchType.LAZY)
	private List<DetailService> detailservices;

	//bi-directional many-to-one association to EmployeeManageFservice
	@OneToMany(mappedBy="fieldservice", fetch=FetchType.LAZY)
	private List<EmployeeManageFservice> employeemanagefservices;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CreateBy")
	private EmployeeAccount employeeaccount;

	//bi-directional many-to-one association to FieldService
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PFServiceID")
	private FieldService fieldservice;

	//bi-directional many-to-one association to FieldService
	@OneToMany(mappedBy="fieldservice", fetch=FetchType.LAZY)
	private List<FieldService> fieldservices;

	//bi-directional many-to-one association to ServicePost
	@OneToMany(mappedBy="fieldservice", fetch=FetchType.LAZY)
	private List<ServicePost> serviceposts;

	public FieldService() {
	}

	public int getFServiceID() {
		return this.FServiceID;
	}

	public void setFServiceID(int FServiceID) {
		this.FServiceID = FServiceID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getFServiceDescription() {
		return this.FServiceDescription;
	}

	public void setFServiceDescription(String FServiceDescription) {
		this.FServiceDescription = FServiceDescription;
	}

	public String getFServiceHref() {
		return this.FServiceHref;
	}

	public void setFServiceHref(String FServiceHref) {
		this.FServiceHref = FServiceHref;
	}

	public String getFServiceImage() {
		return this.FServiceImage;
	}

	public void setFServiceImage(String FServiceImage) {
		this.FServiceImage = FServiceImage;
	}

	public String getFServiceName() {
		return this.FServiceName;
	}

	public void setFServiceName(String FServiceName) {
		this.FServiceName = FServiceName;
	}

	public List<DetailService> getDetailservices() {
		return this.detailservices;
	}

	public void setDetailservices(List<DetailService> detailservices) {
		this.detailservices = detailservices;
	}

	public DetailService addDetailservice(DetailService detailservice) {
		getDetailservices().add(detailservice);
		detailservice.setFieldservice(this);

		return detailservice;
	}

	public DetailService removeDetailservice(DetailService detailservice) {
		getDetailservices().remove(detailservice);
		detailservice.setFieldservice(null);

		return detailservice;
	}

	public List<EmployeeManageFservice> getEmployeemanagefservices() {
		return this.employeemanagefservices;
	}

	public void setEmployeemanagefservices(List<EmployeeManageFservice> employeemanagefservices) {
		this.employeemanagefservices = employeemanagefservices;
	}

	public EmployeeManageFservice addEmployeemanagefservice(EmployeeManageFservice employeemanagefservice) {
		getEmployeemanagefservices().add(employeemanagefservice);
		employeemanagefservice.setFieldservice(this);

		return employeemanagefservice;
	}

	public EmployeeManageFservice removeEmployeemanagefservice(EmployeeManageFservice employeemanagefservice) {
		getEmployeemanagefservices().remove(employeemanagefservice);
		employeemanagefservice.setFieldservice(null);

		return employeemanagefservice;
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

	public List<FieldService> getFieldservices() {
		return this.fieldservices;
	}

	public void setFieldservices(List<FieldService> fieldservices) {
		this.fieldservices = fieldservices;
	}

	public FieldService addFieldservice(FieldService fieldservice) {
		getFieldservices().add(fieldservice);
		fieldservice.setFieldservice(this);

		return fieldservice;
	}

	public FieldService removeFieldservice(FieldService fieldservice) {
		getFieldservices().remove(fieldservice);
		fieldservice.setFieldservice(null);

		return fieldservice;
	}

	public List<ServicePost> getServiceposts() {
		return this.serviceposts;
	}

	public void setServiceposts(List<ServicePost> serviceposts) {
		this.serviceposts = serviceposts;
	}

	public ServicePost addServicepost(ServicePost servicepost) {
		getServiceposts().add(servicepost);
		servicepost.setFieldservice(this);

		return servicepost;
	}

	public ServicePost removeServicepost(ServicePost servicepost) {
		getServiceposts().remove(servicepost);
		servicepost.setFieldservice(null);

		return servicepost;
	}

}
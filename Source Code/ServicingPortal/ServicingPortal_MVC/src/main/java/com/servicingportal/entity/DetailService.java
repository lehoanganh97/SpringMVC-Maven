package com.servicingportal.entity;

import javax.persistence.*;

import org.springframework.context.annotation.Lazy;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the detailservice database table.
 * 
 */
@Entity
@Table(name = "detailservice")
@NamedQuery(name="DetailService.findAll", query="SELECT d FROM DetailService d")
public class DetailService  {
	@Id
	@GeneratedValue
	private int detailServiceID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String detailServiceDescription;

	private String detailServiceName;

	

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CreateBy")
	private EmployeeAccount employeeaccount;

	//bi-directional many-to-one association to FieldService
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FServiceID")
	private FieldService fieldservice;

	//bi-directional many-to-one association to TypeService
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TypeServiceID")
	private TypeService typeservice;

	//bi-directional many-to-one association to ServicePostDetail
	@OneToMany(mappedBy="detailservice", fetch=FetchType.LAZY)
	private List<ServicePostDetail> servicepostdetails;

	public DetailService() {
	}

	public int getDetailServiceID() {
		return this.detailServiceID;
	}

	public void setDetailServiceID(int detailServiceID) {
		this.detailServiceID = detailServiceID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDetailServiceDescription() {
		return this.detailServiceDescription;
	}

	public void setDetailServiceDescription(String detailServiceDescription) {
		this.detailServiceDescription = detailServiceDescription;
	}

	public String getDetailServiceName() {
		return this.detailServiceName;
	}

	public void setDetailServiceName(String detailServiceName) {
		this.detailServiceName = detailServiceName;
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

	public TypeService getTypeservice() {
		return this.typeservice;
	}

	public void setTypeservice(TypeService typeservice) {
		this.typeservice = typeservice;
	}

	public List<ServicePostDetail> getServicepostdetails() {
		return this.servicepostdetails;
	}

	public void setServicepostdetails(List<ServicePostDetail> servicepostdetails) {
		this.servicepostdetails = servicepostdetails;
	}

	public ServicePostDetail addServicepostdetail(ServicePostDetail servicepostdetail) {
		getServicepostdetails().add(servicepostdetail);
		servicepostdetail.setDetailservice(this);

		return servicepostdetail;
	}

	public ServicePostDetail removeServicepostdetail(ServicePostDetail servicepostdetail) {
		getServicepostdetails().remove(servicepostdetail);
		servicepostdetail.setDetailservice(null);

		return servicepostdetail;
	}

}
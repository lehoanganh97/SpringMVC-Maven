package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employeeaccount database table.
 * 
 */
@Entity
@Table(name = "employeeaccount")
@NamedQuery(name="EmployeeAccount.findAll", query="SELECT e FROM EmployeeAccount e")
public class EmployeeAccount  {
	@Id
	@GeneratedValue
	private int empID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String empAddress;

	@Temporal(TemporalType.DATE)
	private Date empDOB;

	private String empEmail;

	private String empFullName;

	private String empIdentityNumber;

	private String empImage;

	private String empPassword;

	private String empPhone;

	private byte isActive;

	//bi-directional many-to-one association to DetailService
	@OneToMany(mappedBy="employeeaccount", fetch=FetchType.LAZY)
	private List<DetailService> detailservices;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CreateBy")
	private EmployeeAccount employeeaccount1;

	//bi-directional many-to-one association to EmployeeAccount
	@OneToMany(mappedBy="employeeaccount1", fetch=FetchType.LAZY)
	private List<EmployeeAccount> employeeaccounts1;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="InActiveBy")
	private EmployeeAccount employeeaccount2;

	//bi-directional many-to-one association to EmployeeAccount
	@OneToMany(mappedBy="employeeaccount2", fetch=FetchType.LAZY)
	private List<EmployeeAccount> employeeaccounts2;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="RoleID")
	private Role role;

	//bi-directional many-to-one association to EmployeeManageFservice
	@OneToMany(mappedBy="employeeaccount1", fetch=FetchType.LAZY)
	private List<EmployeeManageFservice> employeemanagefservices1;

	//bi-directional many-to-one association to EmployeeManageFservice
	@OneToMany(mappedBy="employeeaccount2", fetch=FetchType.LAZY)
	private List<EmployeeManageFservice> employeemanagefservices2;

	//bi-directional many-to-one association to EmployeeManageFservice
	@OneToMany(mappedBy="employeeaccount3", fetch=FetchType.LAZY)
	private List<EmployeeManageFservice> employeemanagefservices3;

	//bi-directional many-to-one association to FieldService
	@OneToMany(mappedBy="employeeaccount", fetch=FetchType.LAZY)
	private List<FieldService> fieldservices;

	//bi-directional many-to-one association to PartnerAccount
	@OneToMany(mappedBy="employeeaccount", fetch=FetchType.LAZY)
	private List<PartnerAccount> partneraccounts;

	//bi-directional many-to-one association to QnA
	@OneToMany(mappedBy="employeeaccount", fetch=FetchType.LAZY)
	private List<QnA> qnas;

	//bi-directional many-to-one association to RoleFunction
	@OneToMany(mappedBy="employeeaccount1", fetch=FetchType.LAZY)
	private List<RoleFunction> rolefunctions1;

	//bi-directional many-to-one association to RoleFunction
	@OneToMany(mappedBy="employeeaccount2", fetch=FetchType.LAZY)
	private List<RoleFunction> rolefunctions2;

	//bi-directional many-to-one association to ServicePost
	@OneToMany(mappedBy="employeeaccount", fetch=FetchType.LAZY)
	private List<ServicePost> serviceposts;

	//bi-directional many-to-one association to ServicePostDetail
	@OneToMany(mappedBy="employeeaccount", fetch=FetchType.LAZY)
	private List<ServicePostDetail> servicepostdetails;

	//bi-directional many-to-one association to WebDataContent
	@OneToMany(mappedBy="employeeaccount", fetch=FetchType.LAZY)
	private List<WebDataContent> webdatacontents;

	//bi-directional many-to-one association to WorkingArea
	@OneToMany(mappedBy="employeeaccount1", fetch=FetchType.LAZY)
	private List<WorkingArea> workingareas1;

	//bi-directional many-to-one association to WorkingArea
	@OneToMany(mappedBy="employeeaccount2", fetch=FetchType.LAZY)
	private List<WorkingArea> workingareas2;

	public EmployeeAccount() {
	}

	public int getEmpID() {
		return this.empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmpAddress() {
		return this.empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Date getEmpDOB() {
		return this.empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpFullName() {
		return this.empFullName;
	}

	public void setEmpFullName(String empFullName) {
		this.empFullName = empFullName;
	}

	public String getEmpIdentityNumber() {
		return this.empIdentityNumber;
	}

	public void setEmpIdentityNumber(String empIdentityNumber) {
		this.empIdentityNumber = empIdentityNumber;
	}

	public String getEmpImage() {
		return this.empImage;
	}

	public void setEmpImage(String empImage) {
		this.empImage = empImage;
	}

	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpPhone() {
		return this.empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public List<DetailService> getDetailservices() {
		return this.detailservices;
	}

	public void setDetailservices(List<DetailService> detailservices) {
		this.detailservices = detailservices;
	}

	public DetailService addDetailservice(DetailService detailservice) {
		getDetailservices().add(detailservice);
		detailservice.setEmployeeaccount(this);

		return detailservice;
	}

	public DetailService removeDetailservice(DetailService detailservice) {
		getDetailservices().remove(detailservice);
		detailservice.setEmployeeaccount(null);

		return detailservice;
	}

	public EmployeeAccount getEmployeeaccount1() {
		return this.employeeaccount1;
	}

	public void setEmployeeaccount1(EmployeeAccount employeeaccount1) {
		this.employeeaccount1 = employeeaccount1;
	}

	public List<EmployeeAccount> getEmployeeaccounts1() {
		return this.employeeaccounts1;
	}

	public void setEmployeeaccounts1(List<EmployeeAccount> employeeaccounts1) {
		this.employeeaccounts1 = employeeaccounts1;
	}

	public EmployeeAccount addEmployeeaccounts1(EmployeeAccount employeeaccounts1) {
		getEmployeeaccounts1().add(employeeaccounts1);
		employeeaccounts1.setEmployeeaccount1(this);

		return employeeaccounts1;
	}

	public EmployeeAccount removeEmployeeaccounts1(EmployeeAccount employeeaccounts1) {
		getEmployeeaccounts1().remove(employeeaccounts1);
		employeeaccounts1.setEmployeeaccount1(null);

		return employeeaccounts1;
	}

	public EmployeeAccount getEmployeeaccount2() {
		return this.employeeaccount2;
	}

	public void setEmployeeaccount2(EmployeeAccount employeeaccount2) {
		this.employeeaccount2 = employeeaccount2;
	}

	public List<EmployeeAccount> getEmployeeaccounts2() {
		return this.employeeaccounts2;
	}

	public void setEmployeeaccounts2(List<EmployeeAccount> employeeaccounts2) {
		this.employeeaccounts2 = employeeaccounts2;
	}

	public EmployeeAccount addEmployeeaccounts2(EmployeeAccount employeeaccounts2) {
		getEmployeeaccounts2().add(employeeaccounts2);
		employeeaccounts2.setEmployeeaccount2(this);

		return employeeaccounts2;
	}

	public EmployeeAccount removeEmployeeaccounts2(EmployeeAccount employeeaccounts2) {
		getEmployeeaccounts2().remove(employeeaccounts2);
		employeeaccounts2.setEmployeeaccount2(null);

		return employeeaccounts2;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<EmployeeManageFservice> getEmployeemanagefservices1() {
		return this.employeemanagefservices1;
	}

	public void setEmployeemanagefservices1(List<EmployeeManageFservice> employeemanagefservices1) {
		this.employeemanagefservices1 = employeemanagefservices1;
	}

	public EmployeeManageFservice addEmployeemanagefservices1(EmployeeManageFservice employeemanagefservices1) {
		getEmployeemanagefservices1().add(employeemanagefservices1);
		employeemanagefservices1.setEmployeeaccount1(this);

		return employeemanagefservices1;
	}

	public EmployeeManageFservice removeEmployeemanagefservices1(EmployeeManageFservice employeemanagefservices1) {
		getEmployeemanagefservices1().remove(employeemanagefservices1);
		employeemanagefservices1.setEmployeeaccount1(null);

		return employeemanagefservices1;
	}

	public List<EmployeeManageFservice> getEmployeemanagefservices2() {
		return this.employeemanagefservices2;
	}

	public void setEmployeemanagefservices2(List<EmployeeManageFservice> employeemanagefservices2) {
		this.employeemanagefservices2 = employeemanagefservices2;
	}

	public EmployeeManageFservice addEmployeemanagefservices2(EmployeeManageFservice employeemanagefservices2) {
		getEmployeemanagefservices2().add(employeemanagefservices2);
		employeemanagefservices2.setEmployeeaccount2(this);

		return employeemanagefservices2;
	}

	public EmployeeManageFservice removeEmployeemanagefservices2(EmployeeManageFservice employeemanagefservices2) {
		getEmployeemanagefservices2().remove(employeemanagefservices2);
		employeemanagefservices2.setEmployeeaccount2(null);

		return employeemanagefservices2;
	}

	public List<EmployeeManageFservice> getEmployeemanagefservices3() {
		return this.employeemanagefservices3;
	}

	public void setEmployeemanagefservices3(List<EmployeeManageFservice> employeemanagefservices3) {
		this.employeemanagefservices3 = employeemanagefservices3;
	}

	public EmployeeManageFservice addEmployeemanagefservices3(EmployeeManageFservice employeemanagefservices3) {
		getEmployeemanagefservices3().add(employeemanagefservices3);
		employeemanagefservices3.setEmployeeaccount3(this);

		return employeemanagefservices3;
	}

	public EmployeeManageFservice removeEmployeemanagefservices3(EmployeeManageFservice employeemanagefservices3) {
		getEmployeemanagefservices3().remove(employeemanagefservices3);
		employeemanagefservices3.setEmployeeaccount3(null);

		return employeemanagefservices3;
	}

	public List<FieldService> getFieldservices() {
		return this.fieldservices;
	}

	public void setFieldservices(List<FieldService> fieldservices) {
		this.fieldservices = fieldservices;
	}

	public FieldService addFieldservice(FieldService fieldservice) {
		getFieldservices().add(fieldservice);
		fieldservice.setEmployeeaccount(this);

		return fieldservice;
	}

	public FieldService removeFieldservice(FieldService fieldservice) {
		getFieldservices().remove(fieldservice);
		fieldservice.setEmployeeaccount(null);

		return fieldservice;
	}

	public List<PartnerAccount> getPartneraccounts() {
		return this.partneraccounts;
	}

	public void setPartneraccounts(List<PartnerAccount> partneraccounts) {
		this.partneraccounts = partneraccounts;
	}

	public PartnerAccount addPartneraccount(PartnerAccount partneraccount) {
		getPartneraccounts().add(partneraccount);
		partneraccount.setEmployeeaccount(this);

		return partneraccount;
	}

	public PartnerAccount removePartneraccount(PartnerAccount partneraccount) {
		getPartneraccounts().remove(partneraccount);
		partneraccount.setEmployeeaccount(null);

		return partneraccount;
	}

	public List<QnA> getQnas() {
		return this.qnas;
	}

	public void setQnas(List<QnA> qnas) {
		this.qnas = qnas;
	}

	public QnA addQna(QnA qna) {
		getQnas().add(qna);
		qna.setEmployeeaccount(this);

		return qna;
	}

	public QnA removeQna(QnA qna) {
		getQnas().remove(qna);
		qna.setEmployeeaccount(null);

		return qna;
	}

	public List<RoleFunction> getRolefunctions1() {
		return this.rolefunctions1;
	}

	public void setRolefunctions1(List<RoleFunction> rolefunctions1) {
		this.rolefunctions1 = rolefunctions1;
	}

	public RoleFunction addRolefunctions1(RoleFunction rolefunctions1) {
		getRolefunctions1().add(rolefunctions1);
		rolefunctions1.setEmployeeaccount1(this);

		return rolefunctions1;
	}

	public RoleFunction removeRolefunctions1(RoleFunction rolefunctions1) {
		getRolefunctions1().remove(rolefunctions1);
		rolefunctions1.setEmployeeaccount1(null);

		return rolefunctions1;
	}

	public List<RoleFunction> getRolefunctions2() {
		return this.rolefunctions2;
	}

	public void setRolefunctions2(List<RoleFunction> rolefunctions2) {
		this.rolefunctions2 = rolefunctions2;
	}

	public RoleFunction addRolefunctions2(RoleFunction rolefunctions2) {
		getRolefunctions2().add(rolefunctions2);
		rolefunctions2.setEmployeeaccount2(this);

		return rolefunctions2;
	}

	public RoleFunction removeRolefunctions2(RoleFunction rolefunctions2) {
		getRolefunctions2().remove(rolefunctions2);
		rolefunctions2.setEmployeeaccount2(null);

		return rolefunctions2;
	}

	public List<ServicePost> getServiceposts() {
		return this.serviceposts;
	}

	public void setServiceposts(List<ServicePost> serviceposts) {
		this.serviceposts = serviceposts;
	}

	public ServicePost addServicepost(ServicePost servicepost) {
		getServiceposts().add(servicepost);
		servicepost.setEmployeeaccount(this);

		return servicepost;
	}

	public ServicePost removeServicepost(ServicePost servicepost) {
		getServiceposts().remove(servicepost);
		servicepost.setEmployeeaccount(null);

		return servicepost;
	}

	public List<ServicePostDetail> getServicepostdetails() {
		return this.servicepostdetails;
	}

	public void setServicepostdetails(List<ServicePostDetail> servicepostdetails) {
		this.servicepostdetails = servicepostdetails;
	}

	public ServicePostDetail addServicepostdetail(ServicePostDetail servicepostdetail) {
		getServicepostdetails().add(servicepostdetail);
		servicepostdetail.setEmployeeaccount(this);

		return servicepostdetail;
	}

	public ServicePostDetail removeServicepostdetail(ServicePostDetail servicepostdetail) {
		getServicepostdetails().remove(servicepostdetail);
		servicepostdetail.setEmployeeaccount(null);

		return servicepostdetail;
	}

	public List<WebDataContent> getWebdatacontents() {
		return this.webdatacontents;
	}

	public void setWebdatacontents(List<WebDataContent> webdatacontents) {
		this.webdatacontents = webdatacontents;
	}

	public WebDataContent addWebdatacontent(WebDataContent webdatacontent) {
		getWebdatacontents().add(webdatacontent);
		webdatacontent.setEmployeeaccount(this);

		return webdatacontent;
	}

	public WebDataContent removeWebdatacontent(WebDataContent webdatacontent) {
		getWebdatacontents().remove(webdatacontent);
		webdatacontent.setEmployeeaccount(null);

		return webdatacontent;
	}

	public List<WorkingArea> getWorkingareas1() {
		return this.workingareas1;
	}

	public void setWorkingareas1(List<WorkingArea> workingareas1) {
		this.workingareas1 = workingareas1;
	}

	public WorkingArea addWorkingareas1(WorkingArea workingareas1) {
		getWorkingareas1().add(workingareas1);
		workingareas1.setEmployeeaccount1(this);

		return workingareas1;
	}

	public WorkingArea removeWorkingareas1(WorkingArea workingareas1) {
		getWorkingareas1().remove(workingareas1);
		workingareas1.setEmployeeaccount1(null);

		return workingareas1;
	}

	public List<WorkingArea> getWorkingareas2() {
		return this.workingareas2;
	}

	public void setWorkingareas2(List<WorkingArea> workingareas2) {
		this.workingareas2 = workingareas2;
	}

	public WorkingArea addWorkingareas2(WorkingArea workingareas2) {
		getWorkingareas2().add(workingareas2);
		workingareas2.setEmployeeaccount2(this);

		return workingareas2;
	}

	public WorkingArea removeWorkingareas2(WorkingArea workingareas2) {
		getWorkingareas2().remove(workingareas2);
		workingareas2.setEmployeeaccount2(null);

		return workingareas2;
	}

}
package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the qna database table.
 * 
 */
@Entity
@Table(name = "qna")
@NamedQuery(name="QnA.findAll", query="SELECT q FROM QnA q")
public class QnA  {
	@Id
	@GeneratedValue
	private int qnAID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String qnAContent;

	private String qnACusEmail;

	private byte qnAISReply;

	private String qnAReplyContent;

	@Temporal(TemporalType.TIMESTAMP)
	private Date qnAReplyDate;

	//bi-directional many-to-one association to EmployeeAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ReplyBy")
	private EmployeeAccount employeeaccount;

	//bi-directional many-to-one association to QnACatelogy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="QnACatID")
	private QnACatelogy qnacatelogy;

	public QnA() {
	}

	public int getQnAID() {
		return this.qnAID;
	}

	public void setQnAID(int qnAID) {
		this.qnAID = qnAID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getQnAContent() {
		return this.qnAContent;
	}

	public void setQnAContent(String qnAContent) {
		this.qnAContent = qnAContent;
	}

	public String getQnACusEmail() {
		return this.qnACusEmail;
	}

	public void setQnACusEmail(String qnACusEmail) {
		this.qnACusEmail = qnACusEmail;
	}

	public byte getQnAISReply() {
		return this.qnAISReply;
	}

	public void setQnAISReply(byte qnAISReply) {
		this.qnAISReply = qnAISReply;
	}

	public String getQnAReplyContent() {
		return this.qnAReplyContent;
	}

	public void setQnAReplyContent(String qnAReplyContent) {
		this.qnAReplyContent = qnAReplyContent;
	}

	public Date getQnAReplyDate() {
		return this.qnAReplyDate;
	}

	public void setQnAReplyDate(Date qnAReplyDate) {
		this.qnAReplyDate = qnAReplyDate;
	}

	public EmployeeAccount getEmployeeaccount() {
		return this.employeeaccount;
	}

	public void setEmployeeaccount(EmployeeAccount employeeaccount) {
		this.employeeaccount = employeeaccount;
	}

	public QnACatelogy getQnacatelogy() {
		return this.qnacatelogy;
	}

	public void setQnacatelogy(QnACatelogy qnacatelogy) {
		this.qnacatelogy = qnacatelogy;
	}

}
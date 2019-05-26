package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the qnacatelogy database table.
 * 
 */
@Entity
@Table(name = "qnacatelogy")
@NamedQuery(name="QnACatelogy.findAll", query="SELECT q FROM QnACatelogy q")
public class QnACatelogy  {
	@Id
	@GeneratedValue
	private int qnACatID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	private String qnACatName;

	//bi-directional many-to-one association to QnA
	@OneToMany(mappedBy="qnacatelogy", fetch=FetchType.LAZY)
	private List<QnA> qnas;

	//bi-directional many-to-one association to QnACatelogy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PQnACatID")
	private QnACatelogy qnacatelogy;

	//bi-directional many-to-one association to QnACatelogy
	@OneToMany(mappedBy="qnacatelogy", fetch=FetchType.LAZY)
	private List<QnACatelogy> qnacatelogies;

	public QnACatelogy() {
	}

	public int getQnACatID() {
		return this.qnACatID;
	}

	public void setQnACatID(int qnACatID) {
		this.qnACatID = qnACatID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getQnACatName() {
		return this.qnACatName;
	}

	public void setQnACatName(String qnACatName) {
		this.qnACatName = qnACatName;
	}

	public List<QnA> getQnas() {
		return this.qnas;
	}

	public void setQnas(List<QnA> qnas) {
		this.qnas = qnas;
	}

	public QnA addQna(QnA qna) {
		getQnas().add(qna);
		qna.setQnacatelogy(this);

		return qna;
	}

	public QnA removeQna(QnA qna) {
		getQnas().remove(qna);
		qna.setQnacatelogy(null);

		return qna;
	}

	public QnACatelogy getQnacatelogy() {
		return this.qnacatelogy;
	}

	public void setQnacatelogy(QnACatelogy qnacatelogy) {
		this.qnacatelogy = qnacatelogy;
	}

	public List<QnACatelogy> getQnacatelogies() {
		return this.qnacatelogies;
	}

	public void setQnacatelogies(List<QnACatelogy> qnacatelogies) {
		this.qnacatelogies = qnacatelogies;
	}

	public QnACatelogy addQnacatelogy(QnACatelogy qnacatelogy) {
		getQnacatelogies().add(qnacatelogy);
		qnacatelogy.setQnacatelogy(this);

		return qnacatelogy;
	}

	public QnACatelogy removeQnacatelogy(QnACatelogy qnacatelogy) {
		getQnacatelogies().remove(qnacatelogy);
		qnacatelogy.setQnacatelogy(null);

		return qnacatelogy;
	}

}
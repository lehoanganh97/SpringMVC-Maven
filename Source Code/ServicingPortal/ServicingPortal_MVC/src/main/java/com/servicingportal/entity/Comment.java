package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@Table(name = "comment")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment  {
	@Id
	@GeneratedValue
	private int cmtID;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String cusEmail;

	private String cusName;

	private String cusPhone;

	private byte isNeedRate;

	private int ratePoint;

	//bi-directional many-to-one association to Comment
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PCmtID")
	private Comment comment;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="comment", fetch=FetchType.LAZY)
	private List<Comment> comments;

	//bi-directional many-to-one association to ServicePost
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ServicePostID")
	private ServicePost servicepost;

	public Comment() {
	}

	public int getCmtID() {
		return this.cmtID;
	}

	public void setCmtID(int cmtID) {
		this.cmtID = cmtID;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCusEmail() {
		return this.cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public byte getIsNeedRate() {
		return this.isNeedRate;
	}

	public void setIsNeedRate(byte isNeedRate) {
		this.isNeedRate = isNeedRate;
	}

	public int getRatePoint() {
		return this.ratePoint;
	}

	public void setRatePoint(int ratePoint) {
		this.ratePoint = ratePoint;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setComment(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setComment(null);

		return comment;
	}

	public ServicePost getServicepost() {
		return this.servicepost;
	}

	public void setServicepost(ServicePost servicepost) {
		this.servicepost = servicepost;
	}

}
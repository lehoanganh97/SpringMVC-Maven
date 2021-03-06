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
 * Schedulemanage generated by hbm2java
 */
@Entity
@Table(name = "schedulemanage", catalog = "servicingportaldb")
public class ScheduleManage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer scheduleManageId;
	private PartnerAccount partneraccount;
	private Date createDate;
	private Date modifyDate;
	private Set<ScheduleDate> scheduledates = new HashSet<ScheduleDate>(0);

	public ScheduleManage() {
	}

	public ScheduleManage(PartnerAccount partneraccount, Date createDate, Date modifyDate) {
		this.partneraccount = partneraccount;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public ScheduleManage(PartnerAccount partneraccount, Date createDate, Date modifyDate,
			Set<ScheduleDate> scheduledates) {
		this.partneraccount = partneraccount;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.scheduledates = scheduledates;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ScheduleManageID", unique = true, nullable = false)
	public Integer getScheduleManageId() {
		return this.scheduleManageId;
	}

	public void setScheduleManageId(Integer scheduleManageId) {
		this.scheduleManageId = scheduleManageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PartnerID", nullable = false)
	public PartnerAccount getPartneraccount() {
		return this.partneraccount;
	}

	public void setPartneraccount(PartnerAccount partneraccount) {
		this.partneraccount = partneraccount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ModifyDate", nullable = false, length = 19)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "schedulemanage")
	public Set<ScheduleDate> getScheduledates() {
		return this.scheduledates;
	}

	public void setScheduledates(Set<ScheduleDate> scheduledates) {
		this.scheduledates = scheduledates;
	}

}

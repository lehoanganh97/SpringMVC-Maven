package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the schedulemanage database table.
 * 
 */
@Entity
@Table(name = "schedulemanage")
@NamedQuery(name="ScheduleManage.findAll", query="SELECT s FROM ScheduleManage s")
public class ScheduleManage  {
	@Id
	@GeneratedValue
	private int scheduleManageID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	//bi-directional many-to-one association to ScheduleDate
	@OneToMany(mappedBy="schedulemanage", fetch=FetchType.LAZY)
	private List<ScheduleDate> scheduledates;

	//bi-directional many-to-one association to PartnerAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PartnerID")
	private PartnerAccount partneraccount;

	public ScheduleManage() {
	}

	public int getScheduleManageID() {
		return this.scheduleManageID;
	}

	public void setScheduleManageID(int scheduleManageID) {
		this.scheduleManageID = scheduleManageID;
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

	public List<ScheduleDate> getScheduledates() {
		return this.scheduledates;
	}

	public void setScheduledates(List<ScheduleDate> scheduledates) {
		this.scheduledates = scheduledates;
	}

	public ScheduleDate addScheduledate(ScheduleDate scheduledate) {
		getScheduledates().add(scheduledate);
		scheduledate.setSchedulemanage(this);

		return scheduledate;
	}

	public ScheduleDate removeScheduledate(ScheduleDate scheduledate) {
		getScheduledates().remove(scheduledate);
		scheduledate.setSchedulemanage(null);

		return scheduledate;
	}

	public PartnerAccount getPartneraccount() {
		return this.partneraccount;
	}

	public void setPartneraccount(PartnerAccount partneraccount) {
		this.partneraccount = partneraccount;
	}

}
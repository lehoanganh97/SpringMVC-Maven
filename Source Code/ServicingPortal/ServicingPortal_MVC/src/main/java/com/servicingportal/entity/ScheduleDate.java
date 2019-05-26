package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the scheduledate database table.
 * 
 */
@Entity
@Table(name = "scheduledate")
@NamedQuery(name="ScheduleDate.findAll", query="SELECT s FROM ScheduleDate s")
public class ScheduleDate  {
	@Id
	@GeneratedValue
	private int scheDateID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	@Lob
	private byte[] scheDateDate;

	private String scheDateName;

	//bi-directional many-to-one association to DetailScheduleDate
	@OneToMany(mappedBy="scheduledate", fetch=FetchType.LAZY)
	private List<DetailScheduleDate> detailscheduledates;

	//bi-directional many-to-one association to ScheduleManage
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ScheduleManageID")
	private ScheduleManage schedulemanage;

	public ScheduleDate() {
	}

	public int getScheDateID() {
		return this.scheDateID;
	}

	public void setScheDateID(int scheDateID) {
		this.scheDateID = scheDateID;
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

	public byte[] getScheDateDate() {
		return this.scheDateDate;
	}

	public void setScheDateDate(byte[] scheDateDate) {
		this.scheDateDate = scheDateDate;
	}

	public String getScheDateName() {
		return this.scheDateName;
	}

	public void setScheDateName(String scheDateName) {
		this.scheDateName = scheDateName;
	}

	public List<DetailScheduleDate> getDetailscheduledates() {
		return this.detailscheduledates;
	}

	public void setDetailscheduledates(List<DetailScheduleDate> detailscheduledates) {
		this.detailscheduledates = detailscheduledates;
	}

	public DetailScheduleDate addDetailscheduledate(DetailScheduleDate detailscheduledate) {
		getDetailscheduledates().add(detailscheduledate);
		detailscheduledate.setScheduledate(this);

		return detailscheduledate;
	}

	public DetailScheduleDate removeDetailscheduledate(DetailScheduleDate detailscheduledate) {
		getDetailscheduledates().remove(detailscheduledate);
		detailscheduledate.setScheduledate(null);

		return detailscheduledate;
	}

	public ScheduleManage getSchedulemanage() {
		return this.schedulemanage;
	}

	public void setSchedulemanage(ScheduleManage schedulemanage) {
		this.schedulemanage = schedulemanage;
	}

}
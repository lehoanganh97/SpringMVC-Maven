package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detailscheduledate database table.
 * 
 */
@Entity
@Table(name = "detailscheduledate")
@NamedQuery(name="DetailScheduleDate.findAll", query="SELECT d FROM DetailScheduleDate d")
public class DetailScheduleDate  {
	@Id
	@GeneratedValue
	private int detailScheDateID;

	private byte isAbsent;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	private String purpose;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeEnd;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStart;

	//bi-directional many-to-one association to ScheduleDate
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ScheDateID")
	private ScheduleDate scheduledate;

	public DetailScheduleDate() {
	}

	public int getDetailScheDateID() {
		return this.detailScheDateID;
	}

	public void setDetailScheDateID(int detailScheDateID) {
		this.detailScheDateID = detailScheDateID;
	}

	public byte getIsAbsent() {
		return this.isAbsent;
	}

	public void setIsAbsent(byte isAbsent) {
		this.isAbsent = isAbsent;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Date getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public ScheduleDate getScheduledate() {
		return this.scheduledate;
	}

	public void setScheduledate(ScheduleDate scheduledate) {
		this.scheduledate = scheduledate;
	}

}
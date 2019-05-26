package com.blackhole.entities;
// Generated Mar 1, 2019 9:23:01 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Detailscheduledate generated by hbm2java
 */
@Entity
@Table(name = "detailscheduledate", catalog = "servicingportaldb")
public class DetailScheduleDate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer detailScheDateId;
	private ScheduleDate scheduledate;
	private Date timeStart;
	private Date timeEnd;
	private String purpose;
	private boolean isAbsent;
	private Date modifyDate;

	public DetailScheduleDate() {
	}

	public DetailScheduleDate(ScheduleDate scheduledate, Date timeStart, Date timeEnd, boolean isAbsent,
			Date modifyDate) {
		this.scheduledate = scheduledate;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.isAbsent = isAbsent;
		this.modifyDate = modifyDate;
	}

	public DetailScheduleDate(ScheduleDate scheduledate, Date timeStart, Date timeEnd, String purpose, boolean isAbsent,
			Date modifyDate) {
		this.scheduledate = scheduledate;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.purpose = purpose;
		this.isAbsent = isAbsent;
		this.modifyDate = modifyDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "DetailScheDateID", unique = true, nullable = false)
	public Integer getDetailScheDateId() {
		return this.detailScheDateId;
	}

	public void setDetailScheDateId(Integer detailScheDateId) {
		this.detailScheDateId = detailScheDateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ScheDateID", nullable = false)
	public ScheduleDate getScheduledate() {
		return this.scheduledate;
	}

	public void setScheduledate(ScheduleDate scheduledate) {
		this.scheduledate = scheduledate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TimeStart", nullable = false, length = 19)
	public Date getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TimeEnd", nullable = false, length = 19)
	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Column(name = "Purpose", length = 500)
	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "IsAbsent", nullable = false)
	public boolean isIsAbsent() {
		return this.isAbsent;
	}

	public void setIsAbsent(boolean isAbsent) {
		this.isAbsent = isAbsent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ModifyDate", nullable = false, length = 19)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}

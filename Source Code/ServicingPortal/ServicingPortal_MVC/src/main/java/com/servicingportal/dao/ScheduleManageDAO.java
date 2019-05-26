package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.PartnerAccount;
import com.servicingportal.entity.ScheduleManage;

public interface ScheduleManageDAO {
	public boolean createScheduleManage(ScheduleManage scheduleManage);
	public List<ScheduleManage> listAllScheduleManage();
	public int getMaxScheduleManageID();
	public ScheduleManage getScheduleManageByID(int scheduleManageID);
	/// Lấy list Partner có Schedule phù hợp
	public List<PartnerAccount> getListPartnerAccountBySchedule(int ScheduleID);
}

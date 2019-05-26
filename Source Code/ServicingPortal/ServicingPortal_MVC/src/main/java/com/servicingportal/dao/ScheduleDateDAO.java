package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.*;

public interface ScheduleDateDAO {
	public boolean createScheduleDate(ScheduleDate scheduleDate);
	public List<ScheduleDate> listAllScheduleDate();
	public int getMaxScheduleDateID();
	public ScheduleDate getScheduleDateByID(int scheduleDateID);
}

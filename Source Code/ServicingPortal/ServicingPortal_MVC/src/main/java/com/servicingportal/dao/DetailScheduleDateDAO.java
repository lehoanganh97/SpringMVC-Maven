package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.*;

public interface DetailScheduleDateDAO {
	public boolean createDetailScheduleDate(DetailScheduleDate detailScheduleDate);
	public List<DetailScheduleDate> listAllDetailScheduleDate();
	public int getMaxDetailScheduleDateID();
	public DetailScheduleDate getDetailScheduleByID(int detailScheduleID);
	// lấy 
}

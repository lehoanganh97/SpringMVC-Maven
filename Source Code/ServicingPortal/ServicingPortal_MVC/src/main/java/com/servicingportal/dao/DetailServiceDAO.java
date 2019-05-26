package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.DetailService;

public interface DetailServiceDAO {
	public List<DetailService> listAllDetailService();
	public boolean createDetailService(DetailService dservice);
	public int getMaxDetailServiceID();
	public DetailService getDetailServiceByID(int id);
	//Lấy DetailServicePost từ FServiceID
	public List<DetailService> getDetailServiceByFServiceID(int fServiceID);
}

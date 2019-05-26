package com.servicingportal.admin.dao;

import java.util.List;

import com.servicingportal.entity.DetailOrder;

public interface AdminOrderServiceDetailDAO {
	public List<DetailOrder> getDetailOrderByOrderService(int orderServiceID);
}

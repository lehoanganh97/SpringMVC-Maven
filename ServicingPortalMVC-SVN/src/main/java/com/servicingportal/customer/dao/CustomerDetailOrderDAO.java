package com.servicingportal.customer.dao;

import java.util.List;

import com.servicingportal.entity.DetailOrder;

public interface CustomerDetailOrderDAO {
	public List<DetailOrder> getDetailOrder(Integer iorderId);
	public DetailOrder getDetailOrderbyId(Integer iorderId);
	
}

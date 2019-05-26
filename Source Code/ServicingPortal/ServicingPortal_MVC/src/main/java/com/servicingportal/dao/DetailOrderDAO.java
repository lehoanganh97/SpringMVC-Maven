package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.DetailOrder;

public interface DetailOrderDAO {

		public List<DetailOrder> listDetailOrder();
		public boolean createDetailOrder(DetailOrder detailOrder);
		public int getMaxDetailOrderID();
		public DetailOrder getDetailOrderbyID(int idetailOrderID);
		// Diễm
		public List<DetailOrder> getDetailOrderByOrderService(int orderServiceID);
}

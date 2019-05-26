package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.OrderService;

public interface OrderServiceDAO {
		public List<OrderService> listOrderService();
		public boolean createOrderServce(OrderService orderService);
		public int getMaxOrderServiceID();
		public OrderService getOrderServicebyID(int iorderID);
		
		//Hoang
		public List<OrderService> getOrderServicebyPartnerID(int partnerID);
		public List<OrderService> getOrderServiceInAcceptbyPartnerID(int partnerID);
		public int acceptOrderService(int orderServiceID);
		public int deleteOrderService(int orderServiceID, int partnerID, int customerID);
		
		//Loc
	
		public boolean checkOrderIsAccept(int iorderServiceID);
		public boolean checkOrderIsDelete(int iorderServiceID);
		public int checkOrderStatus(int iorderServiceID);
}

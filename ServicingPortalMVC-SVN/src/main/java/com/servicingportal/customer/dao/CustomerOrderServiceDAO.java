package com.servicingportal.customer.dao;

import java.util.List;

import com.servicingportal.entity.OrderService;

public interface CustomerOrderServiceDAO {
	public List<OrderService> getCustomerOrderSerivce(int icustomerID);
	public boolean deleteOrderServicebyCustomer(int iorderID);
	public OrderService getCustomerOrderbyID(int icustomerID);
}

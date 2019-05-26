package com.servicingportal.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicingportal.admin.dao.AdminOrderServiceDAO;
import com.servicingportal.admin.dao.AdminOrderServiceDetailDAO;
import com.servicingportal.entity.DetailOrder;
import com.servicingportal.entity.OrderService;

@Controller
@RequestMapping("/AdminOrderService")
public class AdminOrderServiceController {
	@Autowired
	private AdminOrderServiceDAO adminOrderServiceDAO;
	
	@Autowired
	private AdminOrderServiceDetailDAO adminOrderServiceDetailDAO;
	
	@RequestMapping(value = "/getAllOrder")
	public String getAllOrder(HttpServletRequest request, Model model){
		try{
			List<OrderService> orders  =  adminOrderServiceDAO.listOrderService();
			model.addAttribute("orders", orders);
			return "admin/viewOrder";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error get All Order : " + e.getMessage());
			return "false";
		}
		
	}
	
	@RequestMapping(value = "/detailOrder")
	public String detailOrder(HttpServletRequest request,Model model, int orderServiceID){
		try{
			List<DetailOrder> lDO = adminOrderServiceDetailDAO.getDetailOrderByOrderService(orderServiceID);
			model.addAttribute("ldOrder", lDO);
			return "admin/viewDetailOrder";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error get Detail Order : " + e.getMessage());
			return "false";
		}

	}
}

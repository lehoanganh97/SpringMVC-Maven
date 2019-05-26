package com.servicingportal.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.entity.OrderService;
import com.servicingportal.lib.Login;
import com.servicingportal.lib.ManagerSession;
import com.servicingportal.customer.dao.CustomerDetailOrderDAO;
import com.servicingportal.customer.dao.CustomerOrderServiceDAO;
import com.servicingportal.customer.model.CustomerProfile;

@Controller
@RequestMapping// Page Customer Order Management 
public class CustomerOrderServiceController {
	
	@Autowired
	private CustomerOrderServiceDAO customerOrderServiceDAO;
	@Autowired
	private CustomerDetailOrderDAO customerDetailOrderDAO;
	
	@RequestMapping(value="viewCustomerOrder", method = RequestMethod.GET)
	public String getCustomerOrder(HttpServletRequest request,Model model) {
		try {
			if(!Login.checkUserLogin(request)) {
				return "redirect:/login";
			}
			CustomerProfile cusProfile = (CustomerProfile) ManagerSession.userCustomer(request);
			model.addAttribute("cusProfile",cusProfile);
			List<OrderService> lsOrderServices = customerOrderServiceDAO.getCustomerOrderSerivce(cusProfile.getCustomerID());
			model.addAttribute("lsOrderServices", lsOrderServices);
			return "customer/viewCustomerOrder";
		} catch (Exception e) {
			System.out.println("Error :"+ e.getMessage());
			return "false";
		}
	}
	@RequestMapping(value="payment")
	public String paymentOrder(HttpServletRequest request,Model model) {
		try {
			if(!Login.checkUserLogin(request)){
				return "redirect:login";
			}
			CustomerProfile cusProfile = (CustomerProfile) ManagerSession.userCustomer(request);
			model.addAttribute("cusProfile",cusProfile);
			String strOrderID = request.getParameter("OrderID");
			String strOrderTotalPrice = request.getParameter("OrderTotalPrice");
			model.addAttribute("OrderID", strOrderID);
			model.addAttribute("OrderTotalPrice",strOrderTotalPrice);
			return "customer/PaymentPortal/index";
		} catch (Exception e) {
			// TODO: handle exception
			return "false";
		}
	}
	@RequestMapping(value="do") //gửi thông tin đơn hàng sang cổng thanh toán
	public String transferInfoOrder(HttpServletRequest request,Model model) {
		try {
			if(!Login.checkUserLogin(request)){
				return "redirect:login";
			}
			return "customer/do";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println();
			return "errorpage";
		}
	}
	@RequestMapping(value ="dr") //nhận thông tin giao dịch từ cổng thanh toán về client
	public String getInfoOrder(HttpServletRequest request,Model model) {
		try {
			if(!Login.checkUserLogin(request)){
				return "redirect:login";
			}
			return "customer/dr";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println();
			return "errorpage";
		}
	}
}

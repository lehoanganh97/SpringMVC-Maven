package com.servicingportal.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.entity.OrderService;
import com.servicingportal.lib.Login;
import com.servicingportal.lib.ManagerSession;
import com.servicingportal.customer.dao.CustomerOrderServiceDAO;
import com.servicingportal.customer.model.CustomerProfile;

@Controller
@RequestMapping(value="customer")
public class CustomerOrderServiceController {
	
	@Autowired
	private CustomerOrderServiceDAO customerOrderServiceDAO;
	
	@RequestMapping(value="viewCustomerOrder")
	public String getCustomerOrder(HttpServletRequest request,Model model) {
		try {
			/*CustomerAccount customerAccount = ManagerSession.userCustomer(request);
			if (customerAccount == null) {
				return "customer/login";
			}
			model.addAttribute("customer",customerAccount);
			List<OrderService> lsOrderServices = customerOrderServiceDAO.getCustomerOrderSerivce(customerAccount.getCustomerId());*/
			List<OrderService> lsOrderServices = customerOrderServiceDAO.getCustomerOrderSerivce(4);
			model.addAttribute("lsOrderServices", lsOrderServices);
			return "customer/viewCustomerOrder";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :"+e.getMessage());
			return "false";
		}
	}
	@RequestMapping(value="payment")
	public String paymentOrder(HttpServletRequest request,Model model) {
		try {
			if(Login.checkUserLogin(request)){
				return "redirect:login";
			}
			CustomerProfile profile = (CustomerProfile) ManagerSession.userCustomer(request);
			model.addAttribute("customer",profile);
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
			if(Login.checkUserLogin(request)){
				return "redirect:login";
			}
			CustomerProfile profile = (CustomerProfile) ManagerSession.userCustomer(request);
			model.addAttribute("customer",profile);			
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
			if(Login.checkUserLogin(request)){
				return "redirect:login";
			}
			CustomerProfile profile = (CustomerProfile) ManagerSession.userCustomer(request);
			model.addAttribute("customer",profile);
			return "customer/dr";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println();
			return "errorpage";
		}
	}
}

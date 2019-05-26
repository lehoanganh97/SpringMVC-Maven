package com.servicingportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servicingportal.dao.CustomerAccountDAO;
import com.servicingportal.dao.EmployeeAccountDAO;
import com.servicingportal.dao.PartnerAccountDAO;
import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.PartnerAccount;
import com.servicingportal.lib.MD5;
import com.servicingportal.lib.ManagerSession;
/*QuyDH Create Controller 20/10/2018*/
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	CustomerAccountDAO customerAccountDAO;
	@Autowired
	EmployeeAccountDAO employeeAccountDAO;
	@Autowired
	PartnerAccountDAO partnerAccountDAO;
	@RequestMapping(value = "/customer",method = RequestMethod.POST)	
	public String customer(String strEmail, String strPass,
									HttpServletRequest request, Model model){
		String referrer = request.getHeader("referer");
		if(ManagerSession.userCustomer(request)!=null){
			return "redirect:/customer/";
		}
		CustomerAccount customer = customerAccountDAO.checkCustomerAccount(strEmail, MD5.getMD5Hash(strPass));
		if(customer == null){
			model.addAttribute("errors","false");
		}
		else{
			ManagerSession.userCustomer(customer, request);
			model.addAttribute("errors","true");
		}
		return "redirect:" + referrer;
	}
	
	@RequestMapping(value = "/partner",method = RequestMethod.POST)
	public String partner(String strEmail,String strPass,
						HttpServletRequest request, Model model){
		PartnerAccount partner = partnerAccountDAO.checkPartnerAccount(strEmail,MD5.getMD5Hash(strPass));
		if(partner == null){
			model.addAttribute("errors","false");
			return "redirect:/partner/login";
		}
		ManagerSession.userPartner(partner, request);
		return "redirect:/partner/";
	}
	@RequestMapping(value = "/employee",method = RequestMethod.POST)
	public String login(String strEmail,String strPass,
										 HttpServletRequest request, Model model){
		if(strEmail.trim().equals("") || strPass.trim().equals("")){
			model.addAttribute("errors","false");
			return "redirect:/employee/login";
		}
		EmployeeAccount employee = employeeAccountDAO.checkEmployeeAccount(strEmail, MD5.getMD5Hash(strPass));
		if(employee == null){
			model.addAttribute("errors","false");
			return "redirect:/employee/login";
		}
		ManagerSession.userEmployee(employee,request);
		return "redirect:/employee/";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session,HttpServletRequest request){
		String referrer = request.getHeader("referer");
		session.invalidate();
		return "redirect:" + referrer;
	}
}

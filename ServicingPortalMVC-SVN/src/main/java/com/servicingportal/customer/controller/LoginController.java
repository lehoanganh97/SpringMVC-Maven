package com.servicingportal.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.servicingportal.customer.dao.CustomerAccountDAO;
import com.servicingportal.customer.model.CustomerProfile;
import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.lib.MD5;
import com.servicingportal.lib.ManagerSession;
import com.servicingportal.lib.Login;
@Controller
public class LoginController {
//comment
	@Autowired
	private CustomerAccountDAO customerAccountDAO;
	@RequestMapping(value="/login")
	public String loginform(HttpServletRequest request, Model model){
		if(Login.checkUserLogin(request)){
			return "redirect:home";		
		}
		return "customer/newHome";//temp index
	}
	
	@RequestMapping(value= "/logining",method = RequestMethod.POST)
	public String Login(HttpServletRequest request,Model model,String strEmail,String strPass) {
		if(Login.checkUserLogin(request)){
			return "redirect:home";
		}
		try {
			CustomerProfile customerProfile = customerAccountDAO.checkCustomerAccount(strEmail, MD5.getMD5Hash(strPass));
			model.addAttribute("cusProfile",customerProfile);
			if (customerProfile.getCustomerID() == 0) {
				model.addAttribute("errors","false");	
				return "redirect:login";
			}
			ManagerSession.userCustomer(customerProfile, request);
			return "redirect:home" ;	
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:login";
		}
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:home";
	}
}

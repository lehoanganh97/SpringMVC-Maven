package com.servicingportal.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@Autowired
	private CustomerAccountDAO customerAccountDAO;
	@RequestMapping(value="/login")
	public String loginform(HttpServletRequest request, Model model){
		if(Login.checkUserLogin(request)){
			return "redirect:home";
		}
		return "customer/login";
	}
	
	@RequestMapping(value= "/logining",method = RequestMethod.POST)
	public String Login(HttpServletRequest request,Model model,String strEmail,String strPass) {
		String referrer = request.getHeader("referer");
		if(Login.checkUserLogin(request)){
			return "redirect:home";
		}
		try {
			CustomerProfile customerAccount = customerAccountDAO.checkCustomerAccount(strEmail, MD5.getMD5Hash(strPass));
			if (customerAccount == null) {
				model.addAttribute("errors","false");
			}
			ManagerSession.userCustomer(customerAccount, request);
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

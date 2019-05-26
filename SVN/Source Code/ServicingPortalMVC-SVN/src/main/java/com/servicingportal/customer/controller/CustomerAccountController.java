package com.servicingportal.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.log.Log;
import com.servicingportal.customer.dao.CustomerAccountDAO;
import com.servicingportal.customer.model.CustomerProfile;
import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.lib.ManagerSession;

@Controller
public class CustomerAccountController {
	
	@Autowired
	private CustomerAccountDAO customerAccountDAO;
	
	@RequestMapping("/create")
	public String createform(HttpServletRequest request, Model model){
		if(!this.checkLogin(request)){
			return "redirect:home";
		}
		model.addAttribute("errors","");
		return "/customer/create-account";
	}
	
	@PostMapping(value="/creating")
	@ResponseBody
	public String create(@RequestBody CustomerAccount customerDetail, HttpServletRequest request, Model model){
		if(!this.checkLogin(request)){
			return "redirect:home";
		}
		try{
			boolean check = customerAccountDAO.createCustomerAccount(customerDetail);
			if(check){
				model.addAttribute("notify","Create Account Successfull");
				return "redirect:home";
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errors Create User: "+ e.getMessage());
		}
		model.addAttribute("errors","Fail");
		return "redirect:create";
	}
	public boolean checkLogin(HttpServletRequest request){
		if(ManagerSession.userCustomer(request) == "Errors Session"){
			return false;
		}
		return true;
	}
}

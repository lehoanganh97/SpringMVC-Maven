package com.servicingportal.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servicingportal.customer.dao.CustomerAccountDAO;
import com.servicingportal.customer.dao.CustomerFieldServiceDAO;
import com.servicingportal.customer.model.CustomerProfile;

import com.servicingportal.entity.OrderService;
import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.entity.FieldService;
import com.servicingportal.lib.Login;
import com.servicingportal.lib.ManagerSession;

@Controller
public class CustomerController {
	@Autowired
	private CustomerAccountDAO customerAccountDAO;
	
	@Autowired
	private CustomerFieldServiceDAO customerFieldServiceDAOl;
	
	
	@RequestMapping(value={"","/","home"},method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		if(Login.checkUserLogin(request)){
			CustomerProfile customerProfile = (CustomerProfile) ManagerSession.userCustomer(request);
			model.addAttribute("cusProfile",customerProfile);
			return "customer/home";
		}
		/*return "customer/login";*/
		return "customer/newHome"; // temp index
	}
		@RequestMapping(value={"/indexx"},method = RequestMethod.GET)
	public String indexx(HttpServletRequest request, Model model){
		String pageContent = "Content.jsp";
		String title = "Portal Service | Home";
		// content 
		
		List<FieldService> listFieldServiceDAO = customerFieldServiceDAOl.getAllFieldServices();
		
		
		
		model.addAttribute("fields", listFieldServiceDAO);
		model.addAttribute("title",title);
		model.addAttribute("pageContent", pageContent);
		
		return "customer/index";
	}
	
	@RequestMapping(value={"/singlex"},method = RequestMethod.GET)
	public String singlex(HttpServletRequest request, Model model){
		
		return "customer/single";
	}
	
	@RequestMapping(value={"/404x"},method = RequestMethod.GET)
	public String errorx(HttpServletRequest request, Model model){
		
		return "customer/404";
	} 
}

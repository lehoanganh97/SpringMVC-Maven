package com.blackhole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackhole.entities.EmployeeAccount;
import com.blackhole.entities.Order;
import com.blackhole.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	  
	@Autowired
	private AdminActionService adminActionService;
	
	//get list staffs under role of admin
	@GetMapping("/list")
	public String list(Model model){
		// get staffs from dao
		System.out.println("ok");	
		List<EmployeeAccount> staffs = adminActionService.getStaffs();
		// add the staffs to the model
		model.addAttribute("staffs", staffs);
		System.out.println(staffs.get(0).getEmpFullName());
		return "list-staffs";
  }
	  
	  //create a new account under admin
//	  @GetMapping("/newOrder")
//	  public String newOrder(Model model){ 
//		  model.addAttribute("order", new Order());
//		  return "order-form";
//	  }
}

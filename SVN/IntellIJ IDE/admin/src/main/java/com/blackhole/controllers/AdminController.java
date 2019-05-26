package com.blackhole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blackhole.entities.EmployeeAccount;
import com.blackhole.entities.FieldService;
import com.blackhole.service.*;
import com.blackhole.entities.Role;

@Controller
@RequestMapping("/admin")
public class AdminController {
	  
	@Autowired
	private AdminActionService adminActionService;
	
	//get list staffs under role of admin
	@GetMapping("/list")
	public String list(Model model){
		// get staffs from dao
		List<EmployeeAccount> staffs = adminActionService.getStaffs();
		
		// add the staffs to the model
		model.addAttribute("staffs", staffs);
		
		
		return "list-staffs";
  }
	
	//create new account employee
	@GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        EmployeeAccount theStaff = new EmployeeAccount();
        
        //get all role to choose one
        List<Role> roles = adminActionService.getAllRolesToCreateAccount();
        
        //get all field services
        List<FieldService> fields = adminActionService.getAllFieldsToCreateAccount();
        
        
        
        theModel.addAttribute("roles", roles);
        theModel.addAttribute("fields", fields);
        theModel.addAttribute("staff", theStaff);
        
        /*System.out.println(fields.get(0).getFserviceName());*/
        return "staff-form";
    }
	
	//save staff 
    @PostMapping("/saveStaff")
	public String saveStaff(@ModelAttribute("staff") EmployeeAccount theStaff) {
		System.out.println(theStaff.getEmpFullName());
//    	System.out.println(theStaff);
		return "redirect:/admin/list";
	}

	//edit employee's profile
    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("staffId") int theId, Model theModel) {
        EmployeeAccount theStaff = adminActionService.getStaff(theId);

        //get all role to choose one
        List<Role> roles = adminActionService.getAllRolesToCreateAccount();
        EmployeeAccount emplCreate = adminActionService.getStaff(theStaff.getEmployeeaccountByCreateBy().getEmpId());
        theStaff.setEmployeeaccountByCreateBy(emplCreate);
        
//        System.out.println(roles.get(0).getRoleId());
        
        theModel.addAttribute("staff", theStaff);
        theModel.addAttribute("roles", roles);
        
        return "staff-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("staffId") int theId) {
        adminActionService.deleteStaff(theId);
        return "redirect:/admin/list";
    }
}

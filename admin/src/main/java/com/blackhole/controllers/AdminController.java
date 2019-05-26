package com.blackhole.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//INDEX PAGE
	@RequestMapping(value= {""}, method = RequestMethod.GET)
	public String partnerIndexNULL(Model model) {
		return "Admin";
	}
	//get list staffs under role of admin
	@GetMapping("/list")
	public String list(Model model){
		// get staffs from dao
		List<EmployeeAccount> staffs = adminActionService.getStaffs();
		for (int i = 0; i<staffs.size(); i++) {
//			System.out.println(staffs.get(i).getRole().getRoleId().toString());
			Role role = adminActionService.getRole(staffs.get(i).getRole().getRoleId());
			Role roleToView = new Role();
			roleToView.setRoleId(role.getRoleId());
			roleToView.setRoleName(role.getRoleName());
//			System.out.println(role.getRoleDescription());
			
			staffs.get(i).setRole(roleToView);
		}
		
		
		// add the staffs to the model
		model.addAttribute("staffs", staffs);
		
		
		return "list-staffs";
  }
	
	//create new account employee
	@GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        EmployeeAccount theStaff = new EmployeeAccount(); //Nếu người dùng từ chối tiếp tục, exit khỏi trang, memory theStaff này có tự destroy ?
        
        //Demo Data : 
        theStaff.setEmployeeaccountByCreateBy(adminActionService.getStaff(2));
        theStaff.setRole(adminActionService.getRole(2));
        
        //Demo Data
        
        //get all role to choose one
        List<Role> roles = adminActionService.getAllRolesToCreateAccount();
        
        //get all field services
        List<FieldService> fields = adminActionService.getAllFieldsToCreateAccount();
             
       
        theModel.addAttribute("roles", roles);
        theModel.addAttribute("fields", fields);
        theModel.addAttribute("staff", theStaff);
        return "form";
    }
	
	//SAVE THE STAFF  -> Focus in edit firstly 
    @PostMapping("/saveStaff")
//    @RequestMapping(value="/saveStaff", method = RequestMethod.POST)
	public String saveStaff(@Validated EmployeeAccount theStaffUpdate, 

							BindingResult result 
							) { //have to have BindingResult result
    	System.out.println(" Save Loading !!!!");
    	EmployeeAccount theStaff = new EmployeeAccount();
		try {
			
	    	// Create a new Staff
			if (theStaffUpdate.getCreateDate() == null) {
				System.out.println("Create new Staff : ");
				// Auto add info from system
				Date date = new Date();
				theStaff.setCreateDate(date);
				System.out.println(theStaffUpdate.getRole().getRoleId());
				theStaff.setRole(adminActionService.getRole(theStaffUpdate.getRole().getRoleId()));
				theStaff.setIsActive(true);
				System.out.println(theStaffUpdate.getEmployeeaccountByCreateBy().getEmpId());
				theStaff.setEmployeeaccountByCreateBy(adminActionService.getStaff(theStaffUpdate.getEmployeeaccountByCreateBy().getEmpId()));
			} else {
				//get the employee in database by id
				System.out.println("Edit the Staff : ");
				theStaff = adminActionService.getStaff(theStaffUpdate.getEmpId());
			}
			System.out.println("Create By : " );
			System.out.println(theStaffUpdate.getEmployeeaccountByCreateBy().getEmpId());
			System.out.println("=========================");
			System.out.println(theStaffUpdate.toString());
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exeption : " + e.toString());
			return "redirect:/admin/updateForm?staffId="+theStaffUpdate.getEmpId().toString();
		}
		
		// Update each attribute from form to theStaff
//		theStaff.setCreateDate(theStaffUpdate.getCreateDate());
		theStaff.setEmpAddress(theStaffUpdate.getEmpAddress());
		theStaff.setEmpDob(theStaffUpdate.getEmpDob());
		theStaff.setEmpEmail(theStaffUpdate.getEmpEmail());
		theStaff.setEmpFullName(theStaffUpdate.getEmpFullName());
		theStaff.setEmpImage(theStaffUpdate.getEmpImage());
		theStaff.setEmpPassword(theStaffUpdate.getEmpPassword());
		theStaff.setEmpPhone(theStaffUpdate.getEmpPhone());
		theStaff.setEmpIdentityNumber(theStaffUpdate.getEmpIdentityNumber());
		adminActionService.saveStaff(theStaff);
		
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
        
        System.out.println("Role Id : " + theStaff.getRole().getRoleId());
        
        theModel.addAttribute("staff", theStaff);
        theModel.addAttribute("roles", roles);
        
        return "form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("staffId") int theId) {
//        adminActionService.deleteStaff(theId);
    	EmployeeAccount st = adminActionService.getStaff(theId);
    	System.out.println(st.getEmpFullName());
//    	System.out.println(st.toString());
    	st.setEmployeeaccountByCreateBy(null);
    	st.setEmpFullName("ABC");
    	adminActionService.saveStaff(st);
        return "redirect:/admin/list";
    }
    
    @PostMapping("/test")
//  @RequestMapping(value="/test", method = RequestMethod.POST)
	public String test(
			@Validated @ModelAttribute("staff")  EmployeeAccount theStaffUpdate, 
//							HttpServletRequest request,
//							@RequestParam(value = "roleId", required = false) int roleId,
//							@RequestParam(value = "createBy", required = false) int creareBy,
							BindingResult result 
							) { //have to have BindingResult result
    
    	
    	try {
    		
    		System.out.println(theStaffUpdate.getEmpFullName());
    		System.out.println(theStaffUpdate.getEmpAddress());
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		return "redirect:/admin/updateForm?staffId="+theStaffUpdate.getEmpId().toString();
		}
    	
//    	return "redirect:/admin/list";
    	return "test";
    	
    }
    
    @PostMapping("/test1")
    public String test1(@RequestParam("tt") String tt) {
    	
    	
    	System.out.println(tt);
    	
    	return "redirect:/admin/list";
    }

}

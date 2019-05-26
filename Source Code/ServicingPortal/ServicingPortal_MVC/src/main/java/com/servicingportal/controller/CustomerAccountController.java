package com.servicingportal.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servicingportal.dao.CustomerAccountDAO;
import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.lib.MD5;
import com.servicingportal.lib.ManagerSession;

/*QuyDH Create CustomerAccountController 20/10/2018*/

@Controller
@RequestMapping(value = "/customer")
public class CustomerAccountController {
	@Autowired
	CustomerAccountDAO customerAccountDAO;
	@RequestMapping(value="/create")
	public String create(Model model,HttpServletRequest request){
		CustomerAccount customer = ManagerSession.userCustomer(request);
		if(customer!=null){
			return "redirect:/customer";
		}
		return "customer/formsignup";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(String customerFullName, String customerEmail, String customerPassword,
						 String customerPassCheck, String customerPhone,String customerAddress, 
						 String customerDOB, String customerBankAccount,String customerImage,
						 String customerIdentityNumber, Model model){
		if(customerFullName == "" || customerAddress == "" || customerEmail =="" ||
		   customerPassCheck =="" || customerPassword == "" || customerPhone ==""){
			model.addAttribute("errors","Không được để trống");
			return "customer/formsignup";
		}
		if(!customerPassCheck.equals(customerPassword)){
			model.addAttribute("errors","Mật khẩu kiểm tra không trùng khớp");
			return "customer/formsignup";
		}
		if(customerAccountDAO.getListCustomerAccountByEmail(customerEmail)!=null){
			model.addAttribute("errors", "Email đã tồn tại");
		}
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = df.parse(customerDOB);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		CustomerAccount customer = new CustomerAccount();
		customer.setCustomerFullName(customerFullName);
		//customer.setCustomerID(1);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerIdentityNumber(customerIdentityNumber);
		customer.setCustomerImage(customerImage);
		customer.setCustomerPhone(customerPhone);
		customer.setCustomerDOB(date);
		customer.setCustomerPassword(MD5.getMD5Hash(customerPassword));
		customer.setCreateDate(new Date());
		boolean check = customerAccountDAO.createCustomerAccount(customer);
		if(check == true){
			return "redirect:/home";
		}
		model.addAttribute("errors","Không thể tạo mới");
		return "redirect:/customer/create";
	}
}

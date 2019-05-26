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

import com.servicingportal.dao.PartnerAccountDAO;
import com.servicingportal.entity.PartnerAccount;
import com.servicingportal.lib.MD5;
import com.servicingportal.lib.ManagerSession;
/*QuyDH Create PartnerAccountController 21/10/2018*/
@Controller
@RequestMapping(value = "/partner")
public class PartnerAccountController {
	@Autowired
	PartnerAccountDAO partnerAccountDAO;
	
	@RequestMapping(value = "/login")
	public String login(Model model,HttpServletRequest request){
		PartnerAccount par = ManagerSession.userPartner(request);
		if(par != null){
			return "redirect:/partner/home";
		}
		return "partner/login";
	}
	
	@RequestMapping(value = {"","/home","/"})
	public String home(Model model, HttpServletRequest request){
		PartnerAccount partner = ManagerSession.userPartner(request);
		if(partner == null){
			return "redirect:/partner/login";
		}
		model.addAttribute("partner",partner);
		if(partner.getIsAccept()==0){
			return "partner/waitforcheck";
		}
		return "partner/home";
	}
	@RequestMapping(value = "/create")
	public String create(Model model, HttpServletRequest request){
		PartnerAccount partner = ManagerSession.userPartner(request);
		if(partner !=null){
			return "redirect:/partner/";
		}
		return "partner/create";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(String partnerEmail, String partnerFullName,String password, 
					   String passwordcheck, String partnerIdentityNumber, 
					   String partnerImage, String partnerPhone, String partnerDOB,
			 		   String partnerAddress,String partnerBankAccount,String partnerType,
			 		   Model model, HttpServletRequest request){
		PartnerAccount partner = ManagerSession.userPartner(request);
		if(partner !=null){
			model.addAttribute("errors","null");
			return "redirect:/partner/";
		}
		if(partnerEmail.trim().equals("") || partnerFullName.trim().equals("") 
		   || password.trim().equals("") || passwordcheck.trim().equals("") || partnerIdentityNumber.trim().equals("")
		   || partnerPhone.trim().equals("") || partnerDOB.trim().equals("") || partnerAddress.trim().equals("")
		   || partnerBankAccount.trim().equals("")){
			model.addAttribute("errors","false1");
			return "redirect:/partner/create";
		}
		if(!password.trim().equals(passwordcheck)){
			model.addAttribute("errors","falsepassword");
			return "redirect:/partner/create";
		}
		if(partnerAccountDAO.searchPartnerAccountByEmail(partnerEmail) != null){
			model.addAttribute("errors", "emailfalse");
			return "redirect:/partner/create";
		}
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = df.parse(partnerDOB);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		PartnerAccount par = new PartnerAccount();
		par.setIsAccept((byte) 0);
		par.setPartnerFullName(partnerFullName);
		par.setPartnerDOB(date);
		par.setIsModify((byte)0);
		par.setPartnerEmail(partnerEmail);
		par.setPartnerIdentityNumber(partnerIdentityNumber);
		par.setPartnerImage(partnerImage);
		par.setPartnerEmail(partnerEmail);
		par.setPartnerPassword(MD5.getMD5Hash(password));
		par.setPartnerPhone(partnerPhone);
		par.setPartnerBankAccount(partnerBankAccount);
		par.setPartnerAddress(partnerAddress);
		par.setCreateDate(new Date());
		par.setPartnerType(Integer.parseInt(partnerType));
		par.setModifyDate(new Date());
		boolean check = partnerAccountDAO.createPartnerAccount(par);
		if(check){
			model.addAttribute("save","true");
			return "partner/waitforcheck";
		}
		model.addAttribute("save","false");
		return "redirect:/partner/create";
	}
	
	@RequestMapping(value ="/waitingtocheck")
	public String wait(Model model, HttpServletRequest request){
		PartnerAccount partner = ManagerSession.userPartner(request);
		if(partner ==null){
			return "redirect:/partner/login";
		}
		if(partner.getIsAccept() == 1){
			return "redirect:/partner/";
		}
		return "partner/waitforcheck";
	}
}

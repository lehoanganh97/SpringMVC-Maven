package com.servicingportal.partner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servicingportal.customer.model.CustomerProfile;
import com.servicingportal.lib.Login;
import com.servicingportal.lib.MD5;
import com.servicingportal.lib.ManagerSession;
import com.servicingportal.partner.dao.PartnerLoginDAO;
import com.servicingportal.partner.model.PartnerProfile;

@Controller
@RequestMapping("/partner")
public class PartnerLoginController {
	
	@Autowired
	private PartnerLoginDAO partnerLoginDAO;
	
	@RequestMapping(value={"/login","/landing"})
	public String Login(HttpServletRequest request){
		if(Login.checkPartnerLogin(request)){
			return "redirect:partner/home";
		}
		return "partner/login";
	}
	
	@RequestMapping(value= "/logining",method = RequestMethod.POST)
	public String Login(HttpServletRequest request,Model model,String strEmail,String strPass) {
		String referrer = request.getHeader("referer");
		if(Login.checkUserLogin(request)){
			return "redirect:home";
		}
		PartnerProfile partner = partnerLoginDAO.login(strEmail, MD5.getMD5Hash(strPass));
		if (partner.getPartnerId() == 0) {
			model.addAttribute("errors","false");
			return "redirect:login";
		}
		ManagerSession.userPartner(partner, request);
		return "redirect:home";	
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:partner/login";
	}
}

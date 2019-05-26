package com.servicingportal.partner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Partner")
public class PartnerMainController {
	@RequestMapping(value= {"/login"}, method = RequestMethod.GET)
	public String login(Model model) {
		//check session, if have already login, return "redirect:Partner/lockscreen";
		/*
		 * if(CheckHaveAlreadyLogin() == true)
		 * 		return "redirect:Partner/lockscreen";
		 * else
		 */
		return "partner/login";
	}
	
	@RequestMapping(value= {"/lockscreen"}, method = RequestMethod.GET)
	public String lockscreen(Model model) {
		return "partner/lockscreen";
	}
	
	@RequestMapping(value= {"/loginProcess"}, method = RequestMethod.POST)
	public String loginProcess(Model model) {
		System.out.println("Logined");
		return "partner/index";
	}
	
	@RequestMapping(value= {""}, method = RequestMethod.GET)
	public String partnerIndexNULL(Model model) {
		return "redirect:Partner/login";
	}
	
	@RequestMapping(value= {"/index","/"}, method = RequestMethod.GET)
	public String partnerIndex(Model model) {
		return "redirect:login";
	}
	
	@RequestMapping(value= {"/MyServicePost"}, method = RequestMethod.GET)
	public String MyServicePost(Model model) {
		return "partner/MyServicePost";
	}
	
	@RequestMapping(value= {"/AddServicePost"}, method = RequestMethod.GET)
	public String AddServicePost(Model model) {
		return "partner/AddServicePost";
	}
	
	@RequestMapping(value= {"/OrderWaiting"}, method = RequestMethod.GET)
	public String OrderWaiting(Model model) {
		return "partner/OrderWaiting";
	}
	
	@RequestMapping(value= {"/OrderInProcess"}, method = RequestMethod.GET)
	public String OrderInProcess(Model model) {
		return "partner/OrderInProcess";
	}
	
	@RequestMapping(value= {"/OrderComplete"}, method = RequestMethod.GET)
	public String OrderComplete(Model model) {
		return "partner/OrderComplete";
	}
	
	@RequestMapping(value= {"/OrderCancel"}, method = RequestMethod.GET)
	public String OrderCancel(Model model) {
		return "partner/OrderCancel";
	}
	
	@RequestMapping(value= {"/Mailbox"}, method = RequestMethod.GET)
	public String Mailbox(Model model) {
		return "partner/Mailbox";
	}
	
	@RequestMapping(value= {"/MailCompose"}, method = RequestMethod.GET)
	public String MailCompose(Model model) {
		return "partner/MailCompose";
	}
	
	@RequestMapping(value= {"/ReadMail"}, method = RequestMethod.GET)
	public String ReadMail(Model model) {
		return "partner/ReadMail";
	}
	
	@RequestMapping(value= {"/Chat"}, method = RequestMethod.GET)
	public String Chat(Model model) {
		return "partner/Chat";
	}
	
	@RequestMapping(value= {"/Invoice"}, method = RequestMethod.GET)
	public String Invoice(Model model) {
		return "partner/Invoice";
	}
	
	@RequestMapping(value= {"/InvoicePrint"}, method = RequestMethod.GET)
	public String InvoicePrint(Model model) {
		return "partner/InvoicePrint";
	}
}

package com.servicingportal.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicingportal.entity.OrderService;
import com.servicingportal.entity.PartnerAccount;
import com.servicingportal.lib.Login;
import com.servicingportal.lib.ManagerSession;
import com.servicingportal.partner.dao.PartnerOrderServiceDAO;

@Controller
@RequestMapping(value="/partner")
public class PartnerOrderServiceController {
	
	@Autowired
	private PartnerOrderServiceDAO partnerOrderServiceDAO;
	
	@RequestMapping(value="/viewPartnerOrder")
	public String getPartnerOrder(HttpServletRequest request,Model model) {
		try {
			if(Login.checkUserLogin(request)){
				//System.out.println("========");
				return "redirect:home";
			}
			PartnerAccount partnerAccount = (PartnerAccount) ManagerSession.userPartner(request);
			
			model.addAttribute("partner",partnerAccount);
			
			List<OrderService> lsOrderServices = partnerOrderServiceDAO.getPartnerOrderService(partnerAccount.getPartnerId());
			model.addAttribute("lsOrderService",lsOrderServices);
			return "partner/viewPartnerOrder";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error of getPartnerOrder " + e.getMessage());
			return "errorpage";
		}
	}
}

package com.servicingportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicingportal.dao.QnACatelogyDAO;
import com.servicingportal.entity.QnACatelogy;
/*QuyDH Create New HomeController*/
//Để test Question
@Controller
@RequestMapping(value="/quydh")
public class QuyDHHomeController {
	@Autowired
	QnACatelogyDAO qnaCatelogyDAO;
	
	@RequestMapping(value={"/","","/home"})
	public String index(Model model){
		List<QnACatelogy> listQnACate = qnaCatelogyDAO.listQnACatelogy();
		model.addAttribute("listQnACatelogy",listQnACate);
		return "indexQuyDH";
	}	
}

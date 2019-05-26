package com.servicingportal.controller;

import com.servicingportal.dao.*;
import com.servicingportal.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@Autowired
	private CityDAO cityDAO;
	//
	@Autowired
	private CmtDAO commentDAO;

	@Autowired
	private ServicePostDAO servicePostDAO;
	
	@Autowired
	private OrderServiceDAO orderDAO;
	
	@Autowired
	private ServicePostDetailDAO SPDDAO;
	
	@Autowired
	private CustomerAccountDAO CusDAO;
	
	@SuppressWarnings("unused")
	@Autowired
	private PartnerAccountDAO PartDAO;

	@Autowired
	private WebDataContentDAO webDataContentDAO;
	
	@Autowired
	private FieldServiceDAO fserviceDAO;
	
	@RequestMapping({ "/", "/home", "/index" })
	public String home(Model model) {
		 List<WebDataContent> listd = webDataContentDAO.listAllWebDataContent();
		 List<FieldService> listf = fserviceDAO.getField();
		 
		 System.out.println("\n\nDataContent: " + listd.size());
		 System.out.println("\n\nFieldService: " + listf.size());
		 
		 //Add data to web
		 model.addAttribute("datawebs", listd);
		 model.addAttribute("fields", listf);
		 
	     return "index";
	}
	
	@RequestMapping(value ={ "/city"}, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String cityList(Model model) {	
		List<City> citys = cityDAO.listAllCity();
		for(City item : citys) {
			System.out.println("CityID " + item.getCityID());
		}
		model.addAttribute("citys", citys);
		return "cityList";
	}
	@RequestMapping(value={"/CheckMethodOfComment"})
	public String comment(Model m)
	{
		List<Comment> liComment= commentDAO.getListCommentByServicePostID(1);
		for(Comment c : liComment)
		{
			System.out.println(c.getCmtID());
		}
		return "cityList";
	}
	@RequestMapping(value={"/servicepost"})
	public String getServicePostByPartnerID(Model model)
	{
		List<ServicePost> list = servicePostDAO.getListServicePostByPartnerID(1);
		for(ServicePost s : list)
		{
			System.out.println(s.getServicePostID());
		}
		return "cityList";
	}
	
	@RequestMapping(value={"/getOrderToAccept"})
	public String getOrderToAccept(Model model)
	{
		List<OrderService> list = orderDAO.getOrderServicebyPartnerID(1);
		for(OrderService os : list)
		{
			System.out.println(os.getOrderID());
		}
		System.out.println(orderDAO.deleteOrderService(1,1,0));
		/*System.out.println(orderDAO.checkOrderStatus(1));
		System.out.println(orderDAO.checkOrderIsAccept(1));*/
		return "cityList";
	}
}

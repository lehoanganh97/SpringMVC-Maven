package com.servicingportal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicingportal.dao.*;
import com.servicingportal.entity.*;
import com.servicingportal.lib.ManagerSession;

@Controller
public class OrderController {
	@Autowired
	private ServicePostDAO servicePostDAO;
	
	@Autowired 
	private DetailServiceDAO detailServiceDAO;
	
	@Autowired
	private ServicePostDetailDAO servicePostDetailDAO;
	
	@Autowired
	private OrderServiceDAO orderServiceDAO;
	
	@Autowired
	private DetailOrderDAO detailOrderDAO;
	
	@Autowired
	private CustomerAccountDAO customerAccountDAO;
	
	@SuppressWarnings("unused")
	private static HttpSession session ;
	
	@SuppressWarnings("unused")
	private static List<ServicePost> liServicePost= new ArrayList<ServicePost>();
	
	// Phước 26/10/2018
	@SuppressWarnings("unused")
	@RequestMapping({"/suachuadien"})
	public String Order(Model m ){
		/*
		 * có list<detailservice> lấy list<servicepost> trong bảng servicepostdetail
		 * sau đó tạo view chứa list<servicepost> nhấp chọn servicepost nhảy sang trang list<servicepostdetail> của servicepost đó
		 * chọn hết detail và tính tiền 
		 * kiểm tra đăng nhập tài khoản và lưu db 
		 * */
		List<DetailService> liServiceDetail =  detailServiceDAO.getDetailServiceByFServiceID(3);
		List<ServicePost> liServicePost = servicePostDAO.getListServicePostByFserviceID(3);
		
	
		m.addAttribute("listdetailservice", liServiceDetail);
		/*List<ServicePostDetail> liServicePostDetail = servicePostDetailDAO.getDetailServicePostByServicePostAndDetailService(liServicePost, liServiceDetail);
		for(ServicePostDetail s :  liServicePostDetail)
		{
			System.out.println(s.getSpdID());
		}*/
		return "suachuadien";
	}
	@RequestMapping(value={"/sldetail"},method = RequestMethod.POST)
	public String SelectDetailService(Model m,HttpServletRequest httpRequest,@RequestParam(value = "serviceselected", required = false) String[] checkboxValue)
	{
		/*String[] liDetailService = httpRequest.getParameterValues("serviceselected");
		String test = httpRequest.getParameter("test");
		if(liDetailService ==null)
		{
			String error="Please choose your service you want to use!!!!!!!";
			m.addAttribute("error", error);
		}
		else{
			System.out.println(liDetailService.toString());
			System.out.println(test);
		}*/
		List<DetailService> liDetailServices= detailServiceDAO.getDetailServiceByFServiceID(3);
		m.addAttribute("listdetailservice", liDetailServices);
		if(checkboxValue != null)
		  {
		    System.out.println("checkbox is checked");
		    List<String> liIDDetailServiceSelected = new ArrayList<String>();
		    for(int i=0;i<checkboxValue.length;i++)
		    {
		    	liIDDetailServiceSelected.add(checkboxValue[i]);
		    }
		    //test value of checkbook
		    for(String id : liIDDetailServiceSelected)
		    {
		    	System.out.println("ID : "+id);
		    }
		    List<ServicePost> liHintServicePOst = servicePostDAO.getListServicePostByListDetailService(liIDDetailServiceSelected);
		    m.addAttribute("liHintServicePost", liHintServicePOst);
		    for(ServicePost sp :liHintServicePOst)
		    {
		    	System.out.println(sp.getServicePostID());
		    }
		  }
		  else
		  {
		    System.out.println("checkbox is not checked");
		    String error="Please choose your service you want to use!!!!!!!";
			m.addAttribute("error", error);
		  }
		return "suachuadien";
	}
	@RequestMapping(value = "/detailsp", method = RequestMethod.GET)
    public String see(Model m,HttpServletRequest request,
            HttpServletResponse response) throws Exception {
			String idsvp = request.getParameter("spID");
			//ServicePost servicepost= servicePostDAO.getServicePostByID(Integer.parseInt(idsvp));
			System.out.println("********");
			System.out.println("So la: "+idsvp);
			List<ServicePostDetail> li = servicePostDetailDAO.getDetailServicePostByServicePostID(Integer.parseInt(idsvp));

			//m.addAttribute("servicepostselected",servicepost);
			System.out.println("1111111111111");
			m.addAttribute("liservicepostdetail", li);
			m.addAttribute("idsvp",idsvp);
			
			return "detailsp";
    }
	@RequestMapping(value="toLoginforBooking",method=RequestMethod.POST)
	public String getInfo(Model m, HttpServletRequest httpRequest,@RequestParam(value = "detailservicepostselected", required = false) String[] checkboxDetailServicePost )
	{
		String path="";
		HttpSession session = httpRequest.getSession();
		session.setAttribute("listIDDSP", checkboxDetailServicePost);
		CustomerAccount cus= ManagerSession.userCustomer(httpRequest);
		//
		String idsvp=httpRequest.getParameter("idSP");
		if(cus!=null)
		{
			path+="fillInfo";
		}
		else{
			path+="loginpage";
		}
		m.addAttribute("idsvp",idsvp);
		return path;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String checkLogin(Model m,HttpServletRequest request)
	{
		String path="";
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String idsvp = request.getParameter("idSP");
		CustomerAccount cus = customerAccountDAO.checkCustomerAccount(username, password);
		if(cus!=null)
		{
			ManagerSession.userCustomer(cus, request);
			path+="fillInfo";
		}
		else{
			m.addAttribute("errorofLogin","Login Failed!!!");
			path+="loginpage";
		}
		m.addAttribute("idsvp",idsvp);
		return path;
	}
	@SuppressWarnings("unused")
	@RequestMapping(value="fillInfo")
	public String bookingService(Model m,HttpServletRequest request) throws ParseException
	{
		String idsvp=request.getParameter("idSP");
		ServicePost svp = servicePostDAO.getServicePostByID(Integer.parseInt(idsvp));
		HttpSession session = request.getSession();
		String[] idspd = (String[])session.getAttribute("listIDDSP");
		List<ServicePostDetail> liServicePostDetail = new ArrayList<ServicePostDetail>();
		
		//String note and dayUsing
		String note= request.getParameter("note");
		String dateUsing=request.getParameter("dateUsing");
		SimpleDateFormat sdf=  new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(dateUsing);
		List<DetailOrder> liDetailOrder = new ArrayList<>();
		int totalPrice=0;
		for(int i =0;i<idspd.length;i++)
		{
			ServicePostDetail spd = servicePostDetailDAO.getServicePostDetailByID(Integer.parseInt(idspd[i]));
			DetailService ds= spd.getDetailservice();
			DetailOrder detailOrder = new DetailOrder();
			int idOrder = detailOrderDAO.getMaxDetailOrderID();
			detailOrder.setDetailOrderID(idOrder);
			detailOrder.setServicepostdetail(spd);
			detailOrder.setPrice(spd.getSPDPrice());
			//total price
			totalPrice=totalPrice+spd.getSPDPrice();
			detailOrder.setQuantity(1);
			detailOrder.setUsingDate(date);
			detailOrder.setNote(note);
			liDetailOrder.add(detailOrder);
			try{
			boolean create = detailOrderDAO.createDetailOrder(detailOrder);
			if(create)
			{
				System.out.println("Add new Detail Order");
			}
			}catch(Exception e)
			{
				System.out.println("can't create new DetailOrder in bookingService: "+e.getMessage());
			}
		}
		
		OrderService order = new OrderService();
		int idOrder = orderServiceDAO.getMaxOrderServiceID()+1;
		order.setOrderID(idOrder);
		Date dateCreate = new Date();
		order.setCreateDate(dateCreate);
		CustomerAccount cusUsing = ManagerSession.userCustomer(request);
		order.setCustomeraccount(cusUsing);
		order.setDetailorders(liDetailOrder);
		order.setOrderStatus(-1);
		order.setOrderTotalPrice(totalPrice);
		try{
			boolean checkAddOrder = orderServiceDAO.createOrderServce(order);
			if(checkAddOrder == false)
			{
				System.out.println("Error of add Order Service");
			}
		}catch(Exception e)
		{
			System.out.println("Exception about add order service: "+e.getMessage());
		}
		session.removeAttribute("listIDDSP");
		
		
		
		
		return "fillInfo";
	}
	@RequestMapping(value = "getAllOrder")
	public String getAllOrder(HttpServletRequest request, Model model){
		try{
			List<OrderService> orders  =  orderServiceDAO.listOrderService();
			model.addAttribute("orders", orders);
			return "OrderService/viewOrder";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error get All Order : " + e.getMessage());
			return "false";
		}
		
	}
	@RequestMapping(value = "detailOrder")
	public String detailOrder(HttpServletRequest request,Model model,int orderServiceID){
		try{
			List<DetailOrder> lDO = detailOrderDAO.getDetailOrderByOrderService(orderServiceID);
			model.addAttribute("ldOrder", lDO);
			return "OrderService/viewDetailOrder";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error get Detail Order : " + e.getMessage());
			return "false";
		}

	}
	@RequestMapping(value = "t")
	public String testDSL(Model m)
	{
		List<ServicePostDetail> li = servicePostDetailDAO.getDetailServicePostByServicePostID(1);
		for(ServicePostDetail sp : li)
		{
			System.out.println(sp.getSpdID());
		}
		return "suachuadien";
	}

}

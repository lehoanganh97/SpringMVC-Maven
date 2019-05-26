package com.servicingportal.partner.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servicingportal.entity.DetailService;
import com.servicingportal.entity.FieldService;
import com.servicingportal.entity.ServicePost;
import com.servicingportal.entity.ServicePostDetail;
import com.servicingportal.partner.dao.PartnerDetailServiceDAO;
import com.servicingportal.partner.dao.PartnerDetailServicePostDAO;
import com.servicingportal.partner.dao.PartnerFieldServiceDAO;
import com.servicingportal.partner.dao.PartnerPartnerAccountDAO;
import com.servicingportal.partner.dao.PartnerServicePostDAO;
import com.servicingportal.partner.model.ShortDetailServiceInfo;
import com.servicingportal.partner.model.ShortFieldServiceInfo;

@Controller
@RequestMapping("/Partner/ServicePost")
public class PartnerServicePostController {
	@Autowired
	private PartnerFieldServiceDAO fieldServiceDAO;
	@Autowired
	private PartnerDetailServiceDAO detailServiceDAO;
	@Autowired
	private PartnerPartnerAccountDAO partnerAccountDAO;
	@Autowired
	private PartnerServicePostDAO servicePostDAO;
	@Autowired
	private PartnerDetailServicePostDAO detailServicePostDAO;
	
	/*Call to show view*/
	@RequestMapping(value = "/Create", method = RequestMethod.GET)
	public String addServicePost(Model model) {
		 List<ShortFieldServiceInfo> fields = fieldServiceDAO.getShortFieldInfo(); 
		 
		 List<ShortFieldServiceInfo> services = fieldServiceDAO.getShortFieldServiceInfoByParentID(fields.get(0).getFServiceID());
		 List<ShortDetailServiceInfo> dServices = detailServiceDAO.getShortDetailServiceInfoByServiceID(services.get(0).getFServiceID());
		 
		 model.addAttribute("fields", fields);
		 model.addAttribute("services", services);
		 model.addAttribute("dservices", dServices);

	     return "partner/CreateServicePost";
	}
	
	@RequestMapping(value = "/getService", method = RequestMethod.GET)
	public @ResponseBody String getService(HttpServletRequest request) {
		String fieldID = request.getParameter("fieldID");

		List<ShortFieldServiceInfo> services = fieldServiceDAO.getShortFieldServiceInfoByParentID(Integer.parseInt(fieldID));
		
		ObjectMapper mapper = new ObjectMapper();
		String ajaxResponse = "";
		try {
			ajaxResponse = mapper.writeValueAsString(services);
			//System.out.println("-----------------------------" + ajaxResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return ajaxResponse;
	}
	
	@RequestMapping(value = "/getDetailService", method = RequestMethod.GET)
	public @ResponseBody String getDetailService(HttpServletRequest request) {
		String serviceid = request.getParameter("serviceid");

		List<ShortDetailServiceInfo> dServices = detailServiceDAO.getShortDetailServiceInfoByServiceID(Integer.parseInt(serviceid));
		
		ObjectMapper mapper = new ObjectMapper();
		String ajaxResponse = "";
		try {
			
			ajaxResponse = mapper.writeValueAsString(dServices);
			//System.out.println("-----------------------------" + ajaxResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return ajaxResponse;
	}
	
	/*
	@RequestMapping(value = "/deleteServicePost", method = RequestMethod.POST)
	public String deleteServicePost(HttpServletRequest request)
	{
		System.out.println(request.getParameter("ServicePostID"));
		
		int servicepostid = Integer.parseInt(request.getParameter("ServicePostID"));
		
		ServicePost sPost = servicepostDAO.getServicePostByID(servicepostid);
		
		sPost.setIsDelete((byte)1);
		
		servicepostDAO.updateServicePost(sPost);
		
		return "";
	}
	
	@RequestMapping(value = "/updateServicePost", method = RequestMethod.POST)
	public String updateServicePost(HttpServletRequest request)
	{
		int servicepostid = Integer.parseInt(request.getParameter("ServicePostID"));
		ServicePost sPost = servicepostDAO.getServicePostByID(servicepostid);
		
		List<ServicePostDetail> servicePostDetails = new ArrayList<>();
		
		Enumeration<String> params = request.getParameterNames(); 
		while(params.hasMoreElements()){
			String paramName = params.nextElement();
			System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
		 
			if (paramName.contains("ckb") && paramName.contains("txt") == false) {
				ServicePostDetail sPostDetail = new ServicePostDetail();
				sPostDetail.setCreateDate(new Date());
				sPostDetail.setIsAccept((byte) 0);
				sPostDetail.setIsModify((byte) 0);
				sPostDetail.setSPDPrice(0);
				sPostDetail.setModifyDate(new Date());	
				sPostDetail.setServicepost(sPost);
			
				int id = Integer.parseInt((request.getParameter(paramName)));
				DetailService dService = dServiceDAO.getDetailServiceByID(id);
				sPostDetail.setDetailservice(dService);
			
				int price = Integer.parseInt(request.getParameter("txtckb"+id));
				sPostDetail.setSPDPriceNew(price);
				
				servicePostDetails.add(sPostDetail);
			}
			else if (paramName.equals("SPContent")) {
				sPost.setServicePostContentModify(request.getParameter(paramName));
			}
		}
		
		List<ServicePostDetail> tmPostDetails = sPost.getServicepostdetails();
		int i = 0;
		while (i < servicePostDetails.size()) {
			Boolean isFind = false;
			
			int j = 0;
			while (j < tmPostDetails.size()) {
				if(servicePostDetails.get(i).getDetailservice().getDetailServiceID() == tmPostDetails.get(j).getDetailservice().getDetailServiceID())
				{
					isFind = true;
					
					ServicePostDetail spdtmp = tmPostDetails.get(j);
					spdtmp.setSPDPriceNew(servicePostDetails.get(i).getSPDPriceNew());
					spdtmp.setIsModify((byte)1);
					spdtmp.setIsAccept((byte)0);
					servicePostDetailDAO.updateServicePostDetail(spdtmp);
					tmPostDetails.set(j, spdtmp);
					break;
				}
				
				j++;
			}
			if(isFind == false)
			{
				tmPostDetails.add(servicePostDetails.get(i));
				servicePostDetailDAO.createServicePostDetail(servicePostDetails.get(i));
			}
				
			i++;
		}
		
		for (ServicePostDetail servicePostDetail : tmPostDetails) {
			if(servicePostDetail.getSPDPriceNew() == 0)
			{
				tmPostDetails.remove(servicePostDetail);
				//delete
			}
				
		}
		
		sPost.setIsModify((byte)1);
		sPost.setServicepostdetails(tmPostDetails);
		
		servicepostDAO.updateServicePost(sPost);
		
		return "";
	}*/
	
	@RequestMapping(value = "/addSP", method = RequestMethod.POST)
	public String addServicePostToDatabase(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		ServicePost sPost = new ServicePost();
		//sPost.setServicepostdetails(new ArrayList<ServicePostDetail>());
		sPost.setCreateDate(new Date());
		sPost.setIsModify(false);
		sPost.setModifyDate(new Date());
		sPost.setServicePostContent("");
		//sPost.setEmployeeaccount(empDAO.getEmployeeAccountByID(1));
		sPost.setPartneraccount(partnerAccountDAO.getPartnerAccountByID(1));
		sPost.setServicePostRate(0);
		
		System.out.println("---------------------------------------1");
		
		Enumeration<String> params = request.getParameterNames(); 
		while(params.hasMoreElements()){
		 String paramName = params.nextElement();
		 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
		 
		 if(paramName.equals("cbField"))
			{
			
			}
			else if(paramName.equals("cbService")){
				FieldService fieldService = fieldServiceDAO.getFieldServiceByID(Integer.parseInt(request.getParameter(paramName)));
				sPost.setFieldservice(fieldService);
			}
			else if (paramName.contains("ckb") && paramName.contains("txt") == false) {
				ServicePostDetail sPostDetail = new ServicePostDetail();
				sPostDetail.setCreateDate(new Date());
				sPostDetail.setIsAccept(false);
				sPostDetail.setIsModify(false);
				sPostDetail.setSpdprice(0);
				sPostDetail.setModifyDate(new Date());			
			
				int id = Integer.parseInt((request.getParameter(paramName)));
				DetailService dService = detailServiceDAO.getDetailServiceByID(id);
				sPostDetail.setDetailservice(dService);
			
				int price = Integer.parseInt(request.getParameter("txtckb"+id));
				sPostDetail.setSpdpriceNew(price);
				
				sPost.getServicepostdetails().add(sPostDetail);
				//sPost.addServicepostdetail(sPostDetail);
			}
			else if (paramName.equals("txtTitle")) {
				sPost.setServicePostTitle(request.getParameter(paramName));
			}
			else if (paramName.equals("SPContent")) {
				sPost.setServicePostContentModify(request.getParameter(paramName));
			}
		}
		
		/*System.out.println("Title: " + sPost.getServicePostTitle() + "\nContent: " + sPost.getServicePostContentModify()
		+ "\nService: " + sPost.getFieldservice().getFServiceName() + "\nNumber DService:" + sPost.getServicepostdetails().size());*/
		servicePostDAO.createServicePost(sPost);
		System.out.println("KETQUAB: " + sPost.getServicePostId());
		
		for (ServicePostDetail dser : sPost.getServicepostdetails()) {
			dser.setServicepost(sPost);
			detailServicePostDAO.createDetailServicePost((dser));
			System.out.println("KETQUAS: " + dser.getSpdid());
		}
		
		
		model.addAttribute("sposts", sPost);
		return "ViewServicePost";		
	}

}
	

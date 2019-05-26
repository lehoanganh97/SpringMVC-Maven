package com.servicingportal.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servicingportal.dao.DetailServiceDAO;
import com.servicingportal.dao.EmployeeAccountDAO;
import com.servicingportal.dao.FieldServiceDAO;
import com.servicingportal.dao.PartnerAccountDAO;
import com.servicingportal.dao.ServicePostDAO;
import com.servicingportal.dao.ServicePostDetailDAO;
import com.servicingportal.entity.DetailService;
import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.FieldService;
import com.servicingportal.entity.ServicePost;
import com.servicingportal.entity.ServicePostDetail;
import com.servicingportal.lib.ManagerSession;
import com.servicingportal.model.DetailService_Model;
import com.servicingportal.model.FieldService_Model;

@Controller
@RequestMapping("/SPost")
public class ServicePostController {
	@Autowired
	private ServicePostDAO servicepostDAO;
	
	@Autowired
	private ServicePostDetailDAO servicePostDetailDAO;
	
	@Autowired
	private FieldServiceDAO fserviceDAO;
	
	@Autowired
	private DetailServiceDAO dServiceDAO;
	
	@Autowired
	private EmployeeAccountDAO empDAO;
	
	@Autowired
	private PartnerAccountDAO parDAO;
	
	/*Call to show view*/
	@RequestMapping(value = "/CreateServicePost", method = RequestMethod.GET)
	public String addServicePost(Model model) {
		 List<FieldService> fields = fserviceDAO.getField(); 
		 List<FieldService> services = fserviceDAO.getAllServiceByField(fields.get(0).getFServiceID());
		 List<DetailService> dServices = dServiceDAO.getDetailServiceByFServiceID(services.get(0).getFServiceID());
		 
		 model.addAttribute("fields", fields);
		 model.addAttribute("services", services);
		 model.addAttribute("dservices", dServices);

	     return "ServicePost";
	}
	
	@RequestMapping(value = "/getService", method = RequestMethod.GET)
	public @ResponseBody String getService(HttpServletRequest request) {
		String fieldID = request.getParameter("fieldID");

		List<FieldService> services = fserviceDAO.getAllServiceByField(Integer.parseInt(fieldID));
		List<FieldService_Model> sers = new ArrayList<>();

		for (FieldService fieldService : services) {
			FieldService_Model fieldService_Model = new FieldService_Model();
			fieldService_Model.setFServiceID(fieldService.getFServiceID());
			fieldService_Model.setCreateDate(fieldService.getCreateDate());
			fieldService_Model.setFServiceDescription(fieldService.getFServiceDescription());
			fieldService_Model.setFServiceHref(fieldService.getFServiceHref());
			fieldService_Model.setFServiceImage(fieldService.getFServiceImage());
			fieldService_Model.setFServiceName(fieldService.getFServiceName());
			sers.add(fieldService_Model);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String ajaxResponse = "";
		try {
			ajaxResponse = mapper.writeValueAsString(sers);
			//System.out.println("-----------------------------" + ajaxResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return ajaxResponse;
	}
	
	@RequestMapping(value = "/getDetailService", method = RequestMethod.GET)
	public @ResponseBody String getDetailService(HttpServletRequest request) {
		String serviceid = request.getParameter("serviceid");

		List<DetailService> dservices = dServiceDAO.getDetailServiceByFServiceID(Integer.parseInt(serviceid));
		List<DetailService_Model> dsers = new ArrayList<>();
		
		for (DetailService detailService : dservices) {
			DetailService_Model detailService_Model = new DetailService_Model();
			detailService_Model.setDetailServiceID(detailService.getDetailServiceID());
			detailService_Model.setFServiceID(Integer.parseInt((serviceid)));
			
			//detailService_Model.setTypeServiceID(detailService.getTypeservice().getTypeServiceID());System.out.println("here");
			detailService_Model.setDetailServiceName(detailService.getDetailServiceName());
			//detailService_Model.setDetailServiceDescription(detailService.getDetailServiceDescription());System.out.println("here1");
			//detailService_Model.setCreateBy(detailService.getEmployeeaccount().getEmpID());
			//detailService_Model.setCreateDate(detailService.getCreateDate());
			
			dsers.add(detailService_Model);
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		String ajaxResponse = "";
		try {
			
			ajaxResponse = mapper.writeValueAsString(dsers);
			//System.out.println("-----------------------------" + ajaxResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return ajaxResponse;
	}
	
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
	}
	
	
	@RequestMapping(value = "/addSP", method = RequestMethod.POST)
	public String addServicePostToDatabase(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		ServicePost sPost = new ServicePost();
		sPost.setServicepostdetails(new ArrayList<ServicePostDetail>());
		sPost.setCreateDate(new Date());
		sPost.setIsModify((byte) 0);
		sPost.setModifyDate(new Date());
		sPost.setServicePostContent("");
		//sPost.setEmployeeaccount(empDAO.getEmployeeAccountByID(1));
		sPost.setPartneraccount(parDAO.getPartnerByID(1));
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
				FieldService fieldService = fserviceDAO.getFieldServiceByID(Integer.parseInt(request.getParameter(paramName)));
				sPost.setFieldservice(fieldService);
			}
			else if (paramName.contains("ckb") && paramName.contains("txt") == false) {
				ServicePostDetail sPostDetail = new ServicePostDetail();
				sPostDetail.setCreateDate(new Date());
				sPostDetail.setIsAccept((byte) 0);
				sPostDetail.setIsModify((byte) 0);
				sPostDetail.setSPDPrice(0);
				sPostDetail.setModifyDate(new Date());			
			
				int id = Integer.parseInt((request.getParameter(paramName)));
				DetailService dService = dServiceDAO.getDetailServiceByID(id);
				sPostDetail.setDetailservice(dService);
			
				int price = Integer.parseInt(request.getParameter("txtckb"+id));
				sPostDetail.setSPDPriceNew(price);
				
				sPost.addServicepostdetail(sPostDetail);
			}
			else if (paramName.equals("txtTitle")) {
				sPost.setServicePostTitle(request.getParameter(paramName));
			}
			else if (paramName.equals("SPContent")) {
				sPost.setServicePostContentModify(request.getParameter(paramName));
			}
		}
		
		System.out.println("Title: " + sPost.getServicePostTitle() + "\nContent: " + sPost.getServicePostContentModify()
		+ "\nService: " + sPost.getFieldservice().getFServiceName() + "\nNumber DService:" + sPost.getServicepostdetails().size());
		servicepostDAO.createServicePost(sPost);
		System.out.println("KETQUA: " + sPost.getServicePostID());
		
		for (ServicePostDetail dser : sPost.getServicepostdetails()) {
			dser.setServicepost(sPost);
			servicePostDetailDAO.createServicePostDetail(dser);
			System.out.println("KETQUA: " + dser.getSpdID());
		}
		
		
		model.addAttribute("sposts", sPost);
		return "ViewServicePost";		
	}
	
	@RequestMapping(value = "getAllSPNeedConfirm")
	public String getAllSPNeedConfirm(HttpServletRequest request,Model model){
		try{
			// Lấy tất cả bài đăng mới chưa được duyệt
			List<ServicePost> lSP = servicepostDAO.getListServicePostByIsAccept((byte)0);
			// Lấy tất cả bài đăng chỉnh sửa cần duyệt
			List<ServicePost> lSP_1 = servicepostDAO.getListServicePostByIsModify((byte)1);
			lSP.addAll(lSP_1);
			model.addAttribute("sps", lSP);
			return "ServicePost/servicePostNeedConfirm";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error getAllSPNeedConfirm : " + e.getMessage());
			return "false";
		}
	}
	
	@RequestMapping(value = "getSPDNeedConfirm")
	public String getDetailServicePost(HttpServletRequest request, Model model,int servicePostID){
		try{
			// Lấy danh sách các chi tiết bài đăng sửa
			List<ServicePostDetail> lSPD = servicePostDetailDAO.getServicePostDetailByServicePostIDAndIsModify(servicePostID,(byte)1);
			// Lấy danh sách các chi tiết bài đăng thêm mới
			List<ServicePostDetail> lSPD_1 = servicePostDetailDAO.getServicePostDetailByServicePostIDAndIsAccept(servicePostID, (byte)0);
			lSPD.addAll(lSPD_1);
			model.addAttribute("spds", lSPD);
			return "ServicePost/servicePostDetailNeedConfirm";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error getAllSPNeedConfirm : " + e.getMessage());
			return "false";
		}
	}
	
	@RequestMapping(value = "confirmSP")
	public String confirmSP(HttpServletRequest request,Model model,int servicePostID){
		try{
			ServicePost sp = servicepostDAO.getServicePostByID(servicePostID);
			EmployeeAccount em = ManagerSession.userEmployee(request);
			//EmployeeAccount em = empDAO.getEmployeeAccountByID(1);
			// Nếu là bài đăng mới
			if(sp.getIsAccept() == 0){
				sp.setCreateDate(new Date());
				sp.setIsAccept((byte)1);
				sp.setIsModify((byte)0);
				sp.setServicePostContent(sp.getServicePostContentModify());
				sp.setServicePostContentModify("");
//				List<ServicePostDetail> lspd = servicePostDetailDAO.getDetailServicePostByServicePostID(servicePostID);
//				for (ServicePostDetail spd : lspd) {
//					spd.setIsAccept((byte)1);
//					spd.setIsModify((byte)0);
//					spd.setCreateDate(new Date());
//					spd.setModifyDate(new Date());
//					spd.setEmployeeaccount(em);
//					boolean result = servicePostDetailDAO.updateServicePostDetail(spd);
//				}
				servicepostDAO.updateServicePost(sp);
			}
			// nếu là bài đăng cũ sửa lại
			if(sp.getIsModify() == 1){
				sp.setIsModify((byte)0);
				sp.setModifyDate(new Date());
				sp.setServicePostContentOld(sp.getServicePostContent());
				sp.setServicePostContent(sp.getServicePostContentModify());
				sp.setServicePostContentModify("");
//				// chi tiết bài đăng sửa
//				List<ServicePostDetail> lspd = servicePostDetailDAO.getServicePostDetailByServicePostIDAndIsModify(servicePostID, (byte)1);
//				for (ServicePostDetail spd : lspd) {
//					spd.setIsModify((byte)0);
//					spd.setCreateDate(new Date());
//					spd.setSPDPrice(spd.getSPDPriceNew());
//					spd.setSPDPriceNew(0);
//					spd.setEmployeeaccount(em);
//					boolean result = servicePostDetailDAO.updateServicePostDetail(spd);
//				}
//				// chi tiết bài đăng mới
//				List<ServicePostDetail> lspd_1 = servicePostDetailDAO.getServicePostDetailByServicePostIDAndIsAccept(servicePostID, (byte)0);
//				for (ServicePostDetail spd : lspd_1) {
//					spd.setIsAccept((byte)1);
//					spd.setIsModify((byte)0);
//					spd.setCreateDate(new Date());
//					spd.setModifyDate(new Date());
//					spd.setEmployeeaccount(em);
//					boolean result = servicePostDetailDAO.updateServicePostDetail(spd);
//				}
				servicepostDAO.updateServicePost(sp);
			}
			return "redirect:/getSPDNeedConfirm";
		}
		catch (Exception e) {
			// TODO: handle exception
			return "false";
		}
	}
	
	@RequestMapping(value = "confirmSPD")
	public String confirmSPD(HttpServletRequest request,Model model,int servicePostDetailID){
		try{
			ServicePostDetail spd = servicePostDetailDAO.getServicePostDetailByID(servicePostDetailID);
			ServicePost sp = spd.getServicepost();
			if(spd.getIsAccept() == 0){ 
				EmployeeAccount em = ManagerSession.userEmployee(request);
				//EmployeeAccount em = employeeAccountDAO.getEmployeeAccountByID(1);
				spd.setIsAccept((byte)1);
				spd.setIsModify((byte)0);
				spd.setCreateDate(new Date());
				spd.setModifyDate(new Date());
				spd.setEmployeeaccount(em);
				spd.setSPDPrice(spd.getSPDPriceNew());
				spd.setSPDPriceNew(0);
				boolean result = servicePostDetailDAO.updateServicePostDetail(spd);
				System.out.println(result);
			}
			if(sp.getIsModify() == 1){
				EmployeeAccount em = ManagerSession.userEmployee(request);
				//EmployeeAccount em = employeeAccountDAO.getEmployeeAccountByID(1);
				spd.setIsModify((byte)0);
				spd.setCreateDate(new Date());
				spd.setSPDPrice(spd.getSPDPriceNew());
				spd.setSPDPriceNew(0);
				spd.setEmployeeaccount(em);
				boolean result = servicePostDetailDAO.updateServicePostDetail(spd);
				System.out.println(result);
			}
			return "ServicePost/servicePostNeedConfirm";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error confirm SPD : " + e.getMessage());
			return "false";
		}
	}
}

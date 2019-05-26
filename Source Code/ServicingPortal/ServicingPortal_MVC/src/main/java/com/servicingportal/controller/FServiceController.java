package com.servicingportal.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servicingportal.dao.EmployeeAccountDAO;
import com.servicingportal.dao.FieldServiceDAO;
import com.servicingportal.dao.ServicePostDAO;
import com.servicingportal.dao.ServicePostDetailDAO;
import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.FieldService;
import com.servicingportal.lib.ManagerSession;

@Controller
public class FServiceController {
	
	@Autowired
	private FieldServiceDAO fieldServiceDAO;
	@SuppressWarnings("unused")
	@Autowired
	private EmployeeAccountDAO employeeAccountDAO;
	@SuppressWarnings("unused")
	@Autowired
	private ServicePostDAO servicePostDAO;
	@SuppressWarnings("unused")
	@Autowired 
	private ServicePostDetailDAO servicePostDetailDAO;
	
	@RequestMapping(value="/getFormAddFieldService")
	public String getFormAddFieldService(HttpServletRequest request,String error){
		return "FService/formAddFieldService";
	}
	
	@RequestMapping(value="/addFieldService", method= RequestMethod.POST)
	public String addFieldService(String strFServiceDescription,String strFServiceHref,String strFServiceImage,String strFServiceName,int iPFServiceID,HttpServletRequest request,Model model){
		try{
			int FServiceID = fieldServiceDAO.getMaxFieldServiceID() + 1;
			if(ManagerSession.userEmployee(request)==null){
				return "Login/login";
			}
			else{	
				if(strFServiceHref.isEmpty() || strFServiceImage.isEmpty() || strFServiceName.isEmpty()){
					String error = "Tên dịch vụ, hình anh và đường dẫn không được rỗng";
					model.addAttribute("error", error);
					System.out.println(error);
					return "FService/formAddFieldService";
				}
				else{
					FieldService PFService = fieldServiceDAO.getFieldServiceByID(iPFServiceID);
					EmployeeAccount em = ManagerSession.userEmployee(request);
					FieldService fieldService = new FieldService();
					fieldService.setFServiceID(FServiceID);
					fieldService.setFServiceName(strFServiceName);
					fieldService.setFServiceDescription(strFServiceDescription);
					fieldService.setFServiceImage(strFServiceImage);
					fieldService.setFServiceHref(strFServiceHref);
					fieldService.setEmployeeaccount(em);
					fieldService.setCreateDate(new Date());
					if(iPFServiceID == 0)
						fieldService.setFieldservice(null);
					else
						fieldService.setFieldservice(PFService);
					boolean result = fieldServiceDAO.createFieldService(fieldService);
					if(result == false){
						String error = "Lỗi khi thêm dịch vụ, vui lòng thử lại";
						model.addAttribute("error", error);
						return "FService/formAddFieldService";
					}
					return "FService/fieldService";
				}		
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return "FService/formAddFieldService";
		}		
	}
	
}

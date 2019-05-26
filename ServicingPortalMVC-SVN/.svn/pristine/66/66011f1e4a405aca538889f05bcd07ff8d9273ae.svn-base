package com.servicingportal.admin.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.UploadContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mchange.io.FileEnumeration;
import com.servicingportal.admin.dao.AdminAccountDAO;
import com.servicingportal.admin.dao.AdminFServiceDAO;
import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.FieldService;
import com.servicingportal.lib.ManagerSession;

@Controller
@RequestMapping("/AdminFService")
public class AdminFServiceController {
	@Autowired
	private AdminFServiceDAO adminFServiceDAO;
	
	@Autowired
	private AdminAccountDAO adminAccountDAO;
	
	@Autowired
	private AdminFServiceDAO adminfserviceDAO;
	
	@RequestMapping(value="/getFormAddFieldParentService")
	public String getFormAddFieldParentService(HttpServletRequest request,String error, int PFServiceID){
		return "admin/formAddParentFieldService";
	}
	
	@RequestMapping(value="/getFormAddFieldService")
	public String getFormAddFieldService(HttpServletRequest request, int PFServiceID, String message, Model model) {
		model.addAttribute("PFServiceID", PFServiceID);
		return "admin/FormAddFieldService";
	}
	
	@RequestMapping(value="/addPFieldService", method= RequestMethod.POST)
	public String addFieldService(HttpServletRequest request,Model model
			, @RequestParam("file")MultipartFile file, String fserviceName
			, String fserviceDescription){
		try{
			if(ManagerSession.userAdmin(request)==null){
				return "Login/login";
			}
			else{
				String path = request.getServletContext().getRealPath
						("resources/images/FieldService/" + file.getOriginalFilename());
				String fileNameNoExtension = file.getOriginalFilename().replaceFirst("[.][^.]+$", "");
				String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				File upload = new File(path);
				int temp = 1;
				String fileName = "";
				while(upload.exists()) {
					path = request.getServletContext().getRealPath
							("resources/images/FieldService/" + 
							fileNameNoExtension
							+ "Copy(" + temp +")" 
							+ extension);
					fileName = fileNameNoExtension+ "Copy(" + temp +")" 
							+ extension;
					upload = new File(path);
					temp ++;
				}
				file.transferTo(upload);
				String fserviceImage = "src\\main\\webapp\\resources\\images\\FieldService\\" + fileName;
				//int fserviceId = adminFServiceDAO.getMaxFieldServiceID() + 1;
				Date createDate = new Date();
				EmployeeAccount em = adminAccountDAO.getEmployeeAccountByEmployeeId(1);
				FieldService fservice = new FieldService(em, null, fserviceName, fserviceDescription, fserviceImage, "", createDate, null, null, null, null);
				Boolean result = adminfserviceDAO.createFieldService(fservice);
				if(result == true)
					model.addAttribute("message", "Thêm thành công");
				else model.addAttribute("message", "Thêm không thành công");
				return "FService/FormAddFieldService";
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "FService/formAddFieldService";
		}		
	}
	
	@RequestMapping(value="/addFieldService", method= RequestMethod.POST)
	public String addFieldService(HttpServletRequest request,Model model
			, @RequestParam("file")MultipartFile file, String fserviceName
			, String fserviceDescription, int PFServiceID){
		try{
			if(ManagerSession.userAdmin(request)==null){
				return "Login/login";
			}
			else{
				String path = request.getServletContext().getRealPath
						("resources/images/FieldService/" + file.getOriginalFilename());
				String fileNameNoExtension = file.getOriginalFilename().replaceFirst("[.][^.]+$", "");
				String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				File upload = new File(path);
				int temp = 1;
				String fileName = "";
				while(upload.exists()) {
					path = request.getServletContext().getRealPath
							("resources/images/FieldService/" + 
							fileNameNoExtension
							+ "Copy(" + temp +")" 
							+ extension);
					fileName = fileNameNoExtension+ "Copy(" + temp +")" 
							+ extension;
					upload = new File(path);
					temp ++;
				}
				file.transferTo(upload);
				String fserviceImage = "src\\main\\webapp\\resources\\images\\FieldService\\" + fileName;
				Date createDate = new Date();
				EmployeeAccount em = adminAccountDAO.getEmployeeAccountByEmployeeId(1);
				FieldService pFieldService = adminfserviceDAO.getFieldServiceByID(PFServiceID);
				System.out.println("PFSERVICE " + pFieldService.getFserviceName());
				FieldService fservice = new FieldService(em, pFieldService, fserviceName, fserviceDescription, fserviceImage, "", createDate, null, null, null, null);
				Boolean result = adminfserviceDAO.createFieldService(fservice);
				if(result == true)
					model.addAttribute("message", "Thêm thành công");
				else model.addAttribute("message", "Thêm không thành công");
				System.out.println(PFServiceID);
				model.addAttribute("PFServiceID", PFServiceID);
				return "redirect:/AdminFService/getFormAddFieldService";
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "false";
		}		
	}	

}

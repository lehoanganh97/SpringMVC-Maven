package com.servicingportal.admin.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicingportal.admin.dao.AdminAccountDAO;
import com.servicingportal.admin.dao.AdminOrderServiceDAO;
import com.servicingportal.admin.dao.AdminOrderServiceDetailDAO;
import com.servicingportal.admin.dao.AdminServicePostDAO;
import com.servicingportal.admin.dao.AdminServicePostDetailDAO;
import com.servicingportal.entity.DetailOrder;
import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.OrderService;
import com.servicingportal.entity.ServicePost;
import com.servicingportal.entity.ServicePostDetail;
import com.servicingportal.lib.ManagerSession;

@Controller
@RequestMapping("/AdminServicePost")
public class AdminServicePostController {
	@Autowired
	private AdminServicePostDAO adminServicepostDAO;
	
	@Autowired
	private AdminServicePostDetailDAO adminServicepostDetailDAO;
	
	@Autowired
	private AdminAccountDAO adminAccountDAOImpl;
	
	@RequestMapping(value = "/getAllSPNeedConfirm")
	public String getAllSPNeedConfirm(HttpServletRequest request,Model model){
		try{
			// Lấy tất cả bài đăng mới chưa được duyệt
			List<ServicePost> lSP = adminServicepostDAO.getListServicePostByIsAccept(false);
			// Lấy tất cả bài đăng chỉnh sửa cần duyệt
			List<ServicePost> lSP_1 = adminServicepostDAO.getListServicePostByIsModify(true);
			lSP.addAll(lSP_1);
			
			model.addAttribute("sps", lSP);
			return "admin/ServicePostNeedConfirm";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error getAllSPNeedConfirm : " + e.getMessage());
			return "false";
		}
	}
	@RequestMapping(value = "/getSPDNeedConfirm")
	public String getDetailServicePost(HttpServletRequest request, Model model,int servicePostId){
		try{
			// Lấy danh sách các chi tiết bài đăng sửa -- lấy theo isModify = true
			List<ServicePostDetail> lSPD = adminServicepostDetailDAO.getServicePostDetailByServicePostIDAndIsModify(servicePostId,true);
			// Lấy danh sách các chi tiết bài đăng thêm mới isAccept = false
			List<ServicePostDetail> lSPD_1 = adminServicepostDetailDAO.getServicePostDetailByServicePostIDAndIsAccept(servicePostId, false);
			lSPD.addAll(lSPD_1);
			model.addAttribute("spds", lSPD);
			return "admin/ServicePostDetailNeedConfirm";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error getAllSPNeedConfirm : " + e.getMessage());
			return "false";
		}
	}
	@RequestMapping(value = "/confirmSP")
	public String confirmSP(HttpServletRequest request,Model model,int servicePostId){
		try{
			ServicePost sp = adminServicepostDAO.getServicePostByID(servicePostId);
			//EmployeeAccount em = (EmployeeAccount) ManagerSession.userAdmin(request);
			EmployeeAccount em = adminAccountDAOImpl.getEmployeeAccountByEmployeeId(1);
			// Nếu là bài đăng mới
			if(!sp.isIsAccept()){
				sp.setCreateDate(new Date());
				sp.setIsAccept(true);
				sp.setIsModify(false);
				sp.setServicePostContent(sp.getServicePostContentModify());
				sp.setServicePostContentModify("");
				boolean result = adminServicepostDAO.updateServicePost(sp);
				System.out.println(result);
			}
			// nếu là bài đăng cũ sửa lại
			if(sp.isIsModify()){
				sp.setIsModify(false);
				sp.setModifyDate(new Date());
				sp.setServicePostContentOld(sp.getServicePostContent());
				sp.setServicePostContent(sp.getServicePostContentModify());
				sp.setServicePostContentModify("");

				boolean result = adminServicepostDAO.updateServicePost(sp);
			}
			return "redirect:/AdminServicePost/getSPDNeedConfirm?servicePostId=" + servicePostId;
		}
		catch (Exception e) {
			// TODO: handle exception
			return "false";
		}
	}
	
	@RequestMapping(value = "/confirmSPD")
	public String confirmSPD(HttpServletRequest request,Model model,int servicePostDetailID){
		try{
			ServicePostDetail spd = adminServicepostDetailDAO.getServicePostDetailByID(servicePostDetailID);
			int spID = spd.getServicepost().getServicePostId();
			ServicePost sp = adminServicepostDAO.getServicePostByID(spID);
			System.out.println(spID);
			System.out.println(sp.getServicePostTitle());
			if(!spd.isIsAccept()){ 
				//EmployeeAccount em = (EmployeeAccount) ManagerSession.userAdmin(request);
				EmployeeAccount em = adminAccountDAOImpl.getEmployeeAccountByEmployeeId(1);
				System.out.println(em.getEmpFullName());
				spd.setIsAccept(true);
				spd.setIsModify(false);
				spd.setCreateDate(new Date());
				spd.setModifyDate(new Date());
				spd.setEmployeeaccount(em);
				spd.setSpdprice(spd.getSpdpriceNew());
				spd.setSpdpriceNew(0);
				boolean result = adminServicepostDetailDAO.updateServicePostDetail(spd);
				System.out.println(result);
			}
			if(spd.isIsModify()){ 
				//EmployeeAccount em = (EmployeeAccount) ManagerSession.userAdmin(request);
				EmployeeAccount em = adminAccountDAOImpl.getEmployeeAccountByEmployeeId(1);
				spd.setIsModify(false);
				spd.setCreateDate(new Date());
				spd.setSpdprice(spd.getSpdpriceNew());
				spd.setSpdpriceNew(0);
				spd.setEmployeeaccount(em);
				boolean result = adminServicepostDetailDAO.updateServicePostDetail(spd);
				System.out.println(result);
			}
			return "redirect:/AdminServicePost/getSPDNeedConfirm?servicePostId=" + spID;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error confirm SPD : " + e.getMessage());
			return "false";
		}
	}
}

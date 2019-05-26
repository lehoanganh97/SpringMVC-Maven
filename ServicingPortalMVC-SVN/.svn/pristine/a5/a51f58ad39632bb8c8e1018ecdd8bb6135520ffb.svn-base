package com.servicingportal.lib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.servicingportal.utility.CommonConstrants;
import com.servicingportal.customer.model.CustomerProfile;
import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.PartnerAccount;
import com.servicingportal.partner.model.PartnerProfile;

//set get Session để kiểm tra Account
public class ManagerSession {
	public static void userCustomer(CustomerProfile user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstrants.USER_SESSION, user);
	}
	public static Object userCustomer(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute(CommonConstrants.USER_SESSION) == null){
			return "Errors Session";
		}
		// TODO: handle exception
		return session.getAttribute(CommonConstrants.USER_SESSION);
	}
	public static void userAdmin(EmployeeAccount employee, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstrants.ADMIN_SESSION, employee);
	}
	public static Object userAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute(CommonConstrants.ADMIN_SESSION) == null){
			return "Errors Session";
		}
		// TODO: handle exception
		return session.getAttribute(CommonConstrants.ADMIN_SESSION);
	}
	public static void userPartner(PartnerProfile partner, HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstrants.PARTNER_SESSION,partner);
	}
	public static Object userPartner(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute(CommonConstrants.PARTNER_SESSION) == null){
			return "Errors Session";
		}
		// TODO: handle exception
		return session.getAttribute(CommonConstrants.PARTNER_SESSION);
	}
}

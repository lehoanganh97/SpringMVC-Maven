package com.servicingportal.lib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.servicingportal.utility.CommonConstrants;
import com.servicingportal.customer.model.CustomerProfile;
import com.servicingportal.entity.CustomerAccount;
import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.PartnerAccount;

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
	public static void userEmployee(EmployeeAccount employee, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstrants.ADMIN_SESSION, employee);
	}
	public static EmployeeAccount userEmployee(HttpServletRequest request) {
		EmployeeAccount res = null;
		HttpSession session = request.getSession();
		res = (EmployeeAccount) session.getAttribute(CommonConstrants.ADMIN_SESSION);
		return res;
	}
	public static void userPartner(PartnerAccount partner, HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstrants.PARTNER_SESSION,partner);
	}
	public static PartnerAccount userPartner(HttpServletRequest request){
		PartnerAccount res = null;
		HttpSession session = request.getSession();
		res = (PartnerAccount) session.getAttribute(CommonConstrants.PARTNER_SESSION);
		return res;
	}
}

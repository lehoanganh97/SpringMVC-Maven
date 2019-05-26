package com.servicingportal.lib;

import javax.servlet.http.HttpServletRequest;

public class Login {
	public static boolean checkUserLogin(HttpServletRequest request){
		if(ManagerSession.userCustomer(request) == "Errors Session"){
			return false;
		}
		return true;
	}
	public static boolean checkPartnerLogin(HttpServletRequest request){
		if(ManagerSession.userPartner(request) == "Errors Session"){
			return false;
		}
		return true;
	}
	public static boolean checkAdminLogin(HttpServletRequest request){
		if(ManagerSession.userAdmin(request) == "Errors Session"){
			return false;
		}
		return true;
	}
}

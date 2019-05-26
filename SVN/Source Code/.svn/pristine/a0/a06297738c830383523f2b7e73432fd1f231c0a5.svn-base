package com.servicingportal.lib;

import javax.servlet.http.HttpServletRequest;

public class Login {
	public static boolean checkUserLogin(HttpServletRequest request){
		if(ManagerSession.userCustomer(request) == "Errors Session"){
			return false;
		}
		return true;
	}
}

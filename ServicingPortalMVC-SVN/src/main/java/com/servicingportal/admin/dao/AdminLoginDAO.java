package com.servicingportal.admin.dao;

import com.servicingportal.admin.model.AdminProfile;

public interface AdminLoginDAO {
	public AdminProfile login(String adminEmail, String adminPass);
}

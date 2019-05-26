package com.servicingportal.admin.dao;

import java.util.List;

import com.servicingportal.entity.ServicePost;

public interface AdminServicePostDAO {
	// Lấy ServicePost theo isAccept
		public List<ServicePost> getListServicePostByIsAccept(boolean isAccept);
		// Lấy ServicePost theo isModify
		public List<ServicePost> getListServicePostByIsModify(boolean isModify);
		public ServicePost getServicePostByID(int id);
		boolean updateServicePost(ServicePost servicePost);
}

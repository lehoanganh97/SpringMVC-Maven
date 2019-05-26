package com.servicingportal.admin.dao;

import java.util.List;

import com.servicingportal.entity.ServicePostDetail;

public interface AdminServicePostDetailDAO {
	// Diễm
		// Lấy ServicePost Detail cần xác nhận sửa của servicePost isModify = 1
		public List<ServicePostDetail> getServicePostDetailByServicePostIDAndIsModify(int iServicePostID,boolean isModify);
		// Lấy ServicePostDetail cần xác nhận thêm mới của servicePost isAccpet = 0
		public List<ServicePostDetail> getServicePostDetailByServicePostIDAndIsAccept(int iServicePostID, boolean isAccept);
		public ServicePostDetail getServicePostDetailByID(int id);
		public boolean updateServicePostDetail(ServicePostDetail servicePostDetail);
}

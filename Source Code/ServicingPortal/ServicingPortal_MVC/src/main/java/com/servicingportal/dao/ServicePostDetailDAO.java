package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.DetailService;
import com.servicingportal.entity.ServicePost;
import com.servicingportal.entity.ServicePostDetail;

public interface ServicePostDetailDAO {
	public List<ServicePostDetail> listAllServicePostDetail();
	public int createServicePostDetail(ServicePostDetail servicepostdetail);
	public int getMaxServicePostDetailID();
	public ServicePostDetail getServicePostDetailByID(int id);
	//Lấy ServicePostDetail từ servicePost
	public List<ServicePostDetail> getDetailServicePostByServicePostID(int inServicePostID);
	//Laay51 ServicePostDetail dựa vào 2 list fservice và servicepost;
	public List<ServicePostDetail> getDetailServicePostByServicePostAndDetailService(
			List<ServicePost> liServicePost,List<DetailService> liDetailService);
	// Diễm
	// Lấy ServicePost Detail cần xác nhận sửa của servicePost isModify = 1
	public List<ServicePostDetail> getServicePostDetailByServicePostIDAndIsModify(int iServicePostID,byte isModify);
	// Lấy ServicePostDetail cần xác nhận thêm mới của servicePost isAccpet = 0
	public List<ServicePostDetail> getServicePostDetailByServicePostIDAndIsAccept(int iServicePostID, byte isAccept);
	// Cập nhật ServicePost Detail
	public boolean updateServicePostDetail(ServicePostDetail servicePostDetail);
}

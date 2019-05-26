package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.ServicePost;

public interface ServicePostDAO {
	public List<ServicePost> listAllServicePost();
	public int createServicePost(ServicePost servicepost);
	public int getMaxServicePostID();
	public ServicePost getServicePostByID(int id);
	
	//Lấy ServicePost theo partnerID
	public List<ServicePost> getListServicePostByPartnerID(int partnerID);
	//Lấy servicePOst  theo FServiceID
	public List<ServicePost> getListServicePostByFserviceID(int fserviceID);
	//Lấy servicepost khi có list detailservicepost
	public List<ServicePost> getListServicePostByListDetailService(List<String> liID);
	
	// Diễm
	// Lấy ServicePost theo isAccept
	public List<ServicePost> getListServicePostByIsAccept(byte isAccept);
	// Lấy ServicePost theo isModify
	public List<ServicePost> getListServicePostByIsModify(byte isModify);
	boolean updateServicePost(ServicePost servicePost);
}

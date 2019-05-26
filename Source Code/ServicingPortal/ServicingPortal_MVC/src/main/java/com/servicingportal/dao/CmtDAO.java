package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.Comment;

public interface CmtDAO {
	public List<Comment> listAllComment();
	public boolean createCmt(Comment cmt);
	public int getMaxCommentID();
	public Comment getCommentByID(int cmtID);
	//lấy danh sách comment của servicePost
	public List<Comment> getListCommentByServicePostID(int idServicePost);
	
	public boolean reviewsOrder(Comment cmt, int iorderServiceID, int iServicePostID);
}

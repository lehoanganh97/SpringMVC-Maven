package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.WebDataContent;

public interface WebDataContentDAO {
	public boolean createWebDataContent(WebDataContent webDataContent);
	public List<WebDataContent> listAllWebDataContent();
	public int getMaxWebDataContentID();
	public WebDataContent getWebDataContentByID(int webDataContentID);
}

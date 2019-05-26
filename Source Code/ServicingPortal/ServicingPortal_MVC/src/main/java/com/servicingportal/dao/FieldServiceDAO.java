package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.FieldService;

public interface FieldServiceDAO {
	public List<FieldService> listAllFieldService();
	public boolean createFieldService(FieldService fservice);
	public int getMaxFieldServiceID();
	public FieldService getFieldServiceByID(int id);
	public List<FieldService> getField();
	public List<FieldService> getAllServiceByField(int id);
}

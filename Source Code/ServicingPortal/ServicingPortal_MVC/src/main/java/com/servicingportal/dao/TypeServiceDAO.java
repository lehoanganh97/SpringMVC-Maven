package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.TypeService;

public interface TypeServiceDAO {
	// Phước 1/10/2019
	public boolean createTypeService(TypeService typeService);
	public List<TypeService> getListTypeService();
	public TypeService getTypeServiceByID( int idTypeService);
	public int getMaxTypeServiceID();
}

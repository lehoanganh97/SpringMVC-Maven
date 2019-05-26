package com.servicingportal.partner.dao;

import java.util.List;

import com.servicingportal.entity.FieldService;
import com.servicingportal.partner.model.ShortFieldServiceInfo;

public interface PartnerFieldServiceDAO {
	public List<ShortFieldServiceInfo> getShortFieldInfo();
	public List<ShortFieldServiceInfo> getShortFieldServiceInfoByID(int FServiceID);
	public List<ShortFieldServiceInfo> getShortFieldServiceInfoByParentID(int FServiceID);
	public FieldService getFieldServiceByID(int FServiceID);
}

package com.servicingportal.partner.dao;

import java.util.List;

import com.servicingportal.entity.DetailService;
import com.servicingportal.partner.model.ShortDetailServiceInfo;

public interface PartnerDetailServiceDAO {
	public List<ShortDetailServiceInfo> getShortDetailServiceInfoByServiceID(int ServiceID);

	public DetailService getDetailServiceByID(int DetailServiceID);
}

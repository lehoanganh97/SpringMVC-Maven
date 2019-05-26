package com.servicingportal.partner.dao;

import com.servicingportal.partner.model.PartnerProfile;

public interface PartnerLoginDAO {
	public PartnerProfile login(String strEmail, String strPass);
}

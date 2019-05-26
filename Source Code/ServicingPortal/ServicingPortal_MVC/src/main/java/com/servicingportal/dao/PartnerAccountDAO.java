package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.PartnerAccount;

public interface PartnerAccountDAO {
	public boolean createPartnerAccount(PartnerAccount partner);
	public boolean deletePartnerAccount(int iPartnerID);
	public boolean editPartnerAccount(PartnerAccount partner);
	public PartnerAccount checkPartnerAccount(String strUserName, String strPass);
	public PartnerAccount getPartnerByID(int iPartnerID);
	public List<PartnerAccount> listAllPartnerAccount();
	public List<PartnerAccount> listPartnerAccountUncheck();
	public PartnerAccount searchPartnerAccountByEmail(String strEmail);
	public int getMaxPartnerAccountID();
}

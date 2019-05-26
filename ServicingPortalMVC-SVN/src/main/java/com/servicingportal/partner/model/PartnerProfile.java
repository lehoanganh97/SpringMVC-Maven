package com.servicingportal.partner.model;

public class PartnerProfile {
	private int partnerId;
	private String partnerFullName;
	private boolean isAccept;
	public PartnerProfile(){
		
	}
	public PartnerProfile(int partnerId, String partnerFullName, boolean isAccept) {
		this.partnerId = partnerId;
		this.partnerFullName = partnerFullName;
		this.isAccept = isAccept;
	}
	public int getPartnerId() {
		return partnerId;
	}
	public String getPartnerFullName() {
		return partnerFullName;
	}
	public boolean isAccept() {
		return isAccept;
	}
}

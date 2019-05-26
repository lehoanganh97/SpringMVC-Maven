package com.servicingportal.entity;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeservice database table.
 * 
 */
@Entity
@Table(name = "typeservice")
@NamedQuery(name="TypeService.findAll", query="SELECT t FROM TypeService t")
public class TypeService  {
	@Id
	@GeneratedValue
	private int typeServiceID;

	private String typeServiceName;

	private String typeServiceSign;

	private String typeServiceUnit;

	//bi-directional many-to-one association to DetailService
	@OneToMany(mappedBy="typeservice", fetch=FetchType.LAZY)
	private List<DetailService> detailservices;

	public TypeService() {
	}

	public int getTypeServiceID() {
		return this.typeServiceID;
	}

	public void setTypeServiceID(int typeServiceID) {
		this.typeServiceID = typeServiceID;
	}

	public String getTypeServiceName() {
		return this.typeServiceName;
	}

	public void setTypeServiceName(String typeServiceName) {
		this.typeServiceName = typeServiceName;
	}

	public String getTypeServiceSign() {
		return this.typeServiceSign;
	}

	public void setTypeServiceSign(String typeServiceSign) {
		this.typeServiceSign = typeServiceSign;
	}

	public String getTypeServiceUnit() {
		return this.typeServiceUnit;
	}

	public void setTypeServiceUnit(String typeServiceUnit) {
		this.typeServiceUnit = typeServiceUnit;
	}

	public List<DetailService> getDetailservices() {
		return this.detailservices;
	}

	public void setDetailservices(List<DetailService> detailservices) {
		this.detailservices = detailservices;
	}

	public DetailService addDetailservice(DetailService detailservice) {
		getDetailservices().add(detailservice);
		detailservice.setTypeservice(this);

		return detailservice;
	}

	public DetailService removeDetailservice(DetailService detailservice) {
		getDetailservices().remove(detailservice);
		detailservice.setTypeservice(null);

		return detailservice;
	}

}
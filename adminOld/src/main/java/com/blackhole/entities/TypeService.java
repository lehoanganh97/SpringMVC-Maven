package com.blackhole.entities;
// Generated Mar 1, 2019 9:23:01 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Typeservice generated by hbm2java
 */
@Entity
@Table(name = "typeservice", catalog = "servicingportaldb")
public class TypeService implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer typeServiceId;
	private String typeServiceName;
	private String typeServiceUnit;
	private String typeServiceSign;
	private Set<DetailService> detailservices = new HashSet<DetailService>(0);

	public TypeService() {
	}

	public TypeService(String typeServiceName, String typeServiceUnit, String typeServiceSign) {
		this.typeServiceName = typeServiceName;
		this.typeServiceUnit = typeServiceUnit;
		this.typeServiceSign = typeServiceSign;
	}

	public TypeService(String typeServiceName, String typeServiceUnit, String typeServiceSign,
			Set<DetailService> detailservices) {
		this.typeServiceName = typeServiceName;
		this.typeServiceUnit = typeServiceUnit;
		this.typeServiceSign = typeServiceSign;
		this.detailservices = detailservices;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TypeServiceID", unique = true, nullable = false)
	public Integer getTypeServiceId() {
		return this.typeServiceId;
	}

	public void setTypeServiceId(Integer typeServiceId) {
		this.typeServiceId = typeServiceId;
	}

	@Column(name = "TypeServiceName", nullable = false, length = 100)
	public String getTypeServiceName() {
		return this.typeServiceName;
	}

	public void setTypeServiceName(String typeServiceName) {
		this.typeServiceName = typeServiceName;
	}

	@Column(name = "TypeServiceUnit", nullable = false, length = 100)
	public String getTypeServiceUnit() {
		return this.typeServiceUnit;
	}

	public void setTypeServiceUnit(String typeServiceUnit) {
		this.typeServiceUnit = typeServiceUnit;
	}

	@Column(name = "TypeServiceSign", nullable = false, length = 100)
	public String getTypeServiceSign() {
		return this.typeServiceSign;
	}

	public void setTypeServiceSign(String typeServiceSign) {
		this.typeServiceSign = typeServiceSign;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeservice")
	public Set<DetailService> getDetailservices() {
		return this.detailservices;
	}

	public void setDetailservices(Set<DetailService> detailservices) {
		this.detailservices = detailservices;
	}

}

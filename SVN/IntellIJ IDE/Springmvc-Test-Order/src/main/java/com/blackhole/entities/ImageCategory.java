package com.blackhole.entities;
// Generated Mar 1, 2019 9:23:01 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Imagecategory generated by hbm2java
 */
@Entity
@Table(name = "imagecategory", catalog = "servicingportaldb")
public class ImageCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer imgCatId;
	private PartnerAccount partneraccount;
	private ServicePost servicepost;
	private String imgCatName;
	private Date createDate;
	private Date modifyDate;
	private Set<Image> images = new HashSet<Image>(0);

	public ImageCategory() {
	}

	public ImageCategory(PartnerAccount partneraccount, ServicePost servicepost, String imgCatName, Date createDate,
			Date modifyDate) {
		this.partneraccount = partneraccount;
		this.servicepost = servicepost;
		this.imgCatName = imgCatName;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public ImageCategory(PartnerAccount partneraccount, ServicePost servicepost, String imgCatName, Date createDate,
			Date modifyDate, Set<Image> images) {
		this.partneraccount = partneraccount;
		this.servicepost = servicepost;
		this.imgCatName = imgCatName;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.images = images;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ImgCatID", unique = true, nullable = false)
	public Integer getImgCatId() {
		return this.imgCatId;
	}

	public void setImgCatId(Integer imgCatId) {
		this.imgCatId = imgCatId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CreateBy", nullable = false)
	public PartnerAccount getPartneraccount() {
		return this.partneraccount;
	}

	public void setPartneraccount(PartnerAccount partneraccount) {
		this.partneraccount = partneraccount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ServicePostID", nullable = false)
	public ServicePost getServicepost() {
		return this.servicepost;
	}

	public void setServicepost(ServicePost servicepost) {
		this.servicepost = servicepost;
	}

	@Column(name = "ImgCatName", nullable = false, length = 100)
	public String getImgCatName() {
		return this.imgCatName;
	}

	public void setImgCatName(String imgCatName) {
		this.imgCatName = imgCatName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ModifyDate", nullable = false, length = 19)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "imagecategory")
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

}

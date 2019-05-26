package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the imagecategory database table.
 * 
 */
@Entity
@Table(name = "imagecategory")
@NamedQuery(name="ImageCategory.findAll", query="SELECT i FROM ImageCategory i")
public class ImageCategory  {
	@Id
	@GeneratedValue
	private int imgCatID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String imgCatName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="imagecategory", fetch=FetchType.LAZY)
	private List<Image> images;

	//bi-directional many-to-one association to PartnerAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CreateBy")
	private PartnerAccount partneraccount;

	//bi-directional many-to-one association to ServicePost
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ServicePostID")
	private ServicePost servicepost;

	public ImageCategory() {
	}

	public int getImgCatID() {
		return this.imgCatID;
	}

	public void setImgCatID(int imgCatID) {
		this.imgCatID = imgCatID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getImgCatName() {
		return this.imgCatName;
	}

	public void setImgCatName(String imgCatName) {
		this.imgCatName = imgCatName;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setImagecategory(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setImagecategory(null);

		return image;
	}

	public PartnerAccount getPartneraccount() {
		return this.partneraccount;
	}

	public void setPartneraccount(PartnerAccount partneraccount) {
		this.partneraccount = partneraccount;
	}

	public ServicePost getServicepost() {
		return this.servicepost;
	}

	public void setServicepost(ServicePost servicepost) {
		this.servicepost = servicepost;
	}

}
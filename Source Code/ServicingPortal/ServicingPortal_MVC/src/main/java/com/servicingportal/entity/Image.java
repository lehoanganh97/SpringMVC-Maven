package com.servicingportal.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@Table(name = "image")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image  {
	@Id
	@GeneratedValue
	private int imageID;

	private String imageHref;

	private String imageName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date imageUploadDate;

	//bi-directional many-to-one association to ImageCategory
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ImgCatID")
	private ImageCategory imagecategory;

	//bi-directional many-to-one association to PartnerAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="UploadBy")
	private PartnerAccount partneraccount;

	public Image() {
	}

	public int getImageID() {
		return this.imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public String getImageHref() {
		return this.imageHref;
	}

	public void setImageHref(String imageHref) {
		this.imageHref = imageHref;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getImageUploadDate() {
		return this.imageUploadDate;
	}

	public void setImageUploadDate(Date imageUploadDate) {
		this.imageUploadDate = imageUploadDate;
	}

	public ImageCategory getImagecategory() {
		return this.imagecategory;
	}

	public void setImagecategory(ImageCategory imagecategory) {
		this.imagecategory = imagecategory;
	}

	public PartnerAccount getPartneraccount() {
		return this.partneraccount;
	}

	public void setPartneraccount(PartnerAccount partneraccount) {
		this.partneraccount = partneraccount;
	}

}
package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.Image;

public interface ImageDAO {
	public List<Image> listImage();
	public boolean createImage(Image image);
	public int getMaxImageID();
	public Image getImagebyID(int iimageID);
}

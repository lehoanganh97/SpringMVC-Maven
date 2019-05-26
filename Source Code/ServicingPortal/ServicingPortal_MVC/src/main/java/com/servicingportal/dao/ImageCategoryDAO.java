package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.ImageCategory;

public interface ImageCategoryDAO {
	public List<ImageCategory> listImageCategory();
	public boolean createImageCategory(ImageCategory imageCategory);
	public int getMaxImageCategoryID();
	public ImageCategory getImageCategorybyID(int iimgCatID);// ImageCategory == imgCat
}

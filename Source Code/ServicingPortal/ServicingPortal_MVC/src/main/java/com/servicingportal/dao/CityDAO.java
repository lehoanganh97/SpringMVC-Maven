package com.servicingportal.dao;

import java.util.List;

import com.servicingportal.entity.City;

public interface CityDAO {
	public List<City> listAllCity();
	public boolean createCity(City city);
	public int getMaxCityID();
	public City getCityByID(int cityID);
}

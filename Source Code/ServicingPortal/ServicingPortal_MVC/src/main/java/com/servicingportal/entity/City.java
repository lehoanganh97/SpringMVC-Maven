package com.servicingportal.entity;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@Table(name = "city")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City  {

	@Id
	@GeneratedValue
	private int cityID;

	private String cityName;

	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="city", fetch=FetchType.LAZY)
	private List<Area> areas;

	//bi-directional many-to-one association to WorkingArea
	@OneToMany(mappedBy="city", fetch=FetchType.LAZY)
	private List<WorkingArea> workingareas;

	public City() {
	}

	public int getCityID() {
		return this.cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Area addArea(Area area) {
		getAreas().add(area);
		area.setCity(this);

		return area;
	}

	public Area removeArea(Area area) {
		getAreas().remove(area);
		area.setCity(null);

		return area;
	}

	public List<WorkingArea> getWorkingareas() {
		return this.workingareas;
	}

	public void setWorkingareas(List<WorkingArea> workingareas) {
		this.workingareas = workingareas;
	}

	public WorkingArea addWorkingarea(WorkingArea workingarea) {
		getWorkingareas().add(workingarea);
		workingarea.setCity(this);

		return workingarea;
	}

	public WorkingArea removeWorkingarea(WorkingArea workingarea) {
		getWorkingareas().remove(workingarea);
		workingarea.setCity(null);

		return workingarea;
	}

}
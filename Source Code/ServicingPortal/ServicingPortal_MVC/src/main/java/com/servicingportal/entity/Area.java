package com.servicingportal.entity;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@Table(name = "area")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area  {
	@Id
	@GeneratedValue
	private int areaID;

	private String areaName;

	//bi-directional many-to-one association to City
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="CityID")
	private City city;

	//bi-directional many-to-one association to WorkingArea
	@OneToMany(mappedBy="area", fetch=FetchType.LAZY)
	private List<WorkingArea> workingareas;

	public Area() {
	}

	public int getAreaID() {
		return this.areaID;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<WorkingArea> getWorkingareas() {
		return this.workingareas;
	}

	public void setWorkingareas(List<WorkingArea> workingareas) {
		this.workingareas = workingareas;
	}

	public WorkingArea addWorkingarea(WorkingArea workingarea) {
		getWorkingareas().add(workingarea);
		workingarea.setArea(this);

		return workingarea;
	}

	public WorkingArea removeWorkingarea(WorkingArea workingarea) {
		getWorkingareas().remove(workingarea);
		workingarea.setArea(null);

		return workingarea;
	}

}
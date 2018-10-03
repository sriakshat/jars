package com.model;

import javax.persistence.Entity;

@Entity
public class TechnicalInstructor extends Instructor{
	
	private String technologyName;

	public TechnicalInstructor(String technologyName) {
		super();
		this.technologyName = technologyName;
	}

	public TechnicalInstructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TechnicalInstructor(String name, String email) {
		super(name, email);
		// TODO Auto-generated constructor stub
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	
}

package com.model;

import javax.persistence.Entity;

@Entity
public class HatchBack extends Car {
	
	String space;

	
	public HatchBack(String brand, String space) {
		super(brand);
		this.space = space;
	}

	public HatchBack(String brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}
	
	

}

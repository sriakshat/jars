package com.model;

import javax.persistence.Entity;

@Entity
public class SportsCar extends Car{

	String speed;

	
	
	public SportsCar(String brand, String speed) {
		super(brand);
		this.speed = speed;
	}

	public SportsCar(String brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	
}

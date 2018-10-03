package com.p1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int id;
	
	@Column(name="Employee_City",nullable=false)
	String cityName;
	
	String state;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String cityName, String state) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.state = state;
	}

	public Address(String cityName, String state) {
		super();
		this.cityName = cityName;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	
}

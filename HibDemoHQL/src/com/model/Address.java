package com.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Address {
	@Column(name="house_Number")
	private String houseNumber;	
	
	@Column(name="City_Name")
	private String city;
	
	@Column(name="State_Name")
	private String state;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String houseNumber, String city, String state) {
		super();
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", city=" + city + ", state=" + state + "]";
	}
	
}

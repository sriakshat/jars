package com.model;

import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name="getInstructor_byID",query="from Instructor where id=?")
@Table(name="Instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Id")
	private int id;
	
	@Column(name="Instructor_Name")
	private String name;
	
	@Column(name="Instructor_email")
	private String email;
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="houseNumber",column=@Column(name="Present_HouseNo")),
		@AttributeOverride(name="city",column=@Column(name="Present_city")),
		@AttributeOverride(name="state",column=@Column(name="Present_state")),
	})
	private Address presentAddress;
	
	@Embedded
	private Address permanentAddress;
	
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Address getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(Address presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", email=" + email + ", presentAddress=" + presentAddress
				+ ", permanentAddress=" + permanentAddress + "]";
	}

		
	
}

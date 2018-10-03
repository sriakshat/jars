package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Instructor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Id")
	private int id;
	
	@Column(name="Instructor_Name")
	private String name;
	
	@Column(name="Instructor_email")
	private String email;
	
	@ElementCollection
	@CollectionTable(name="Laptop",joinColumns=@JoinColumn(name="ID"))
	@Column(name="Laptop_name")
	private List<Laptop> laptopList = new ArrayList<Laptop>();
	
	public List<Laptop> getLaptopList() {
		return laptopList;
	}

	public void setLaptopList(List<Laptop> laptopList) {
		this.laptopList = laptopList;
	}

	/*@ElementCollection
	private List<String> subjects = new ArrayList<String>();
	
	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
*/
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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

		
	
}

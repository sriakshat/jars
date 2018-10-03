package com.p1;

public class Employee {

	private int id;
	private String name;
	private String domain;
	private String location;
	private int salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String domain, String location, int salary) {
		super();
		this.name = name;
		this.domain = domain;
		this.location = location;
		this.salary = salary;
	}

	
	public Employee(int id, String name, String domain, String location, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.domain = domain;
		this.location = location;
		this.salary = salary;
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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", domain=" + domain + ", location=" + location + ", salary="
				+ salary + "]";
	}
	
	
}//end class

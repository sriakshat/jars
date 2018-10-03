package com.p1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Project {

	@Column
	private String projectName;
	private String clientName;
	private int headCount;
	
	@Id
	private int projectid;
	
	public Project(String projectName, String clientName, int headCount) {
		super();
		this.projectName = projectName;
		this.clientName = clientName;
		this.headCount = headCount;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String projectName, String clientName, int headCount, int projectid) {
		super();
		this.projectName = projectName;
		this.clientName = clientName;
		this.headCount = headCount;
		this.projectid = projectid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", clientName=" + clientName + ", headCount=" + headCount
				+ ", projectid=" + projectid + "]";
	}
	
	
}//end class

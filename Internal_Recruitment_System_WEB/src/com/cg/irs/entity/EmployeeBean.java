package com.cg.irs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="employee")
public class EmployeeBean implements Serializable{
	
	@Id
	@Column(name="employee_id")
	private String employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	
	// Many to One Project  project_id VARCHAR2(10) references project(project_id),
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBean projectBean;
	
	@Column(name="skill")
	private String skill;
	
	@Column(name="domain")
	private String domain;
	
	@Column(name="experience_yrs")
	private int years;

	//One to Many AssingedRequestion
	@OneToMany(mappedBy="employeeBean")
	Set<AssignedRequisitionBean> assignedRequisitionBean = new HashSet<>();

	
	
	
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public ProjectBean getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public Set<AssignedRequisitionBean> getAssignedRequisitionBean() {
		return assignedRequisitionBean;
	}

	public void setAssignedRequisitionBean(
			Set<AssignedRequisitionBean> assignedRequisitionBean) {
		this.assignedRequisitionBean = assignedRequisitionBean;
	}
	
	
	
	
}

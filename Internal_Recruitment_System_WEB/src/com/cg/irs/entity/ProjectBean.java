package com.cg.irs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="project")
@NamedQueries(
		value={@NamedQuery(name="getAllProjects",query="from ProjectBean projectBean")})
public class ProjectBean implements Serializable
{

	@Id
	@Column(name="project_id")
	private String projectId;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	// Many to One User    RM_id  VARCHAR2(15) references users(users_id)
	@ManyToOne
	@JoinColumn(name="user_Id")
	private UserBean userBean;
	
	
	
	// one to Many EmployeeBean 
	@OneToMany(mappedBy="projectBean",cascade=CascadeType.ALL)
	Set<EmployeeBean> employeeBean = new HashSet<>();
	
	//One To Many Requisition Bean
	@OneToMany(mappedBy="projectBean",cascade=CascadeType.ALL)
	Set<RequisitionBean> requisitionBean = new HashSet<>();

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public Set<EmployeeBean> getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(Set<EmployeeBean> employeeBean) {
		this.employeeBean = employeeBean;
	}

	public Set<RequisitionBean> getRequisitionBean() {
		return requisitionBean;
	}

	public void setRequisitionBean(Set<RequisitionBean> requisitionBean) {
		this.requisitionBean = requisitionBean;
	}

	
	
	
}

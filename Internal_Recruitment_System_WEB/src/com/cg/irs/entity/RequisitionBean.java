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
@Table(name="Requisition")
@NamedQueries(
		value={@NamedQuery(name="getAllRequisitions",query="from RequisitionBean requisitionBean"),
				@NamedQuery(name="getSpecificRequisition",query="from RequisitionBean requisitionBean where requisitionBean.userBean.userId=:userId")})
public class RequisitionBean implements Serializable{

	
	@Id
	@Column(name="requisition_id")
	private String requisitionId;
	
	//Many to One User RM_id VARCHAR2(10) references users(users_id),
	@ManyToOne
	@JoinColumn(name="rm_Id")
	UserBean userBean;
	
 	//Many to One  ProjectBeans  project_id VARCHAR2(10) references project(project_id),
	@ManyToOne(cascade={CascadeType.DETACH})
	@JoinColumn(name="project_Id")
	ProjectBean projectBean;
	
	
	@Column(name="date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name="date_closed")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateClosed;
	
	
	@Column(name="current_status")
	private String currentStatus;
	
	@Column(name="vacancy_name")
	private String vacancyName;
	
	@Column(name="skill")
	private String skill;
	
	@Column(name="domain")
	private String domain;
	
	@Column(name="number_required")
	private int numberRequired;

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public ProjectBean getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getVacancyName() {
		return vacancyName;
	}

	public void setVacancyName(String vacancyName) {
		this.vacancyName = vacancyName;
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

	

	public int getNumberRequired() {
		return numberRequired;
	}

	public void setNumberRequired(int numberRequired) {
		this.numberRequired = numberRequired;
	}

/*	public Set<AssignedRequisitionBean> getAssignedRequisitionBean() {
		return assignedRequisitionBean;
	}

	public void setAssignedRequisitionBean(
			Set<AssignedRequisitionBean> assignedRequisitionBean) {
		this.assignedRequisitionBean = assignedRequisitionBean;
	}*/

	
}

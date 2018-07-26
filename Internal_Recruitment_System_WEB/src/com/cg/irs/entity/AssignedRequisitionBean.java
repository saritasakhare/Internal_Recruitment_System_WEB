package com.cg.irs.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity(name="assigned_Requisition")
@Table
public class AssignedRequisitionBean implements Serializable{

	@ManyToOne
	@JoinColumn(name="user_Id")
	UserBean userBean;
	
	@EmbeddedId
	@ManyToOne
	@JoinColumn(name="employee_Id")
	EmployeeBean employeeBean;

    @ManyToOne
    @JoinColumn(name="requisition_Id")
    RequisitionBean requisitionBean;

    
    
    
	public UserBean getUserBean() {
		return userBean;
	}
	
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public RequisitionBean getRequisitionBean() {
		return requisitionBean;
	}

	public void setRequisitionBean(RequisitionBean requisitionBean) {
		this.requisitionBean = requisitionBean;
	}
    
}

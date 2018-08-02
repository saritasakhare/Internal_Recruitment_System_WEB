package com.cg.irs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="assigned_Requisition")
/*@NamedQueries(
		value={@NamedQuery(name="getSpecificAssignedRequisition",query="from AssignedRequisitionBean assignedRequisitionBean where assignedRequisitionBean.userBean.userId=:rmId")})
*/public class AssignedRequisitionBean implements Serializable{

	
	@Id
	@Column(name="assigned_req_Id")
	int assignedReqId;
	
	@Column(name="rmge_Id")
	String userId;
	
	@Column(name="employee_id")
	String employeeId;

    @Column(name="requisition_Id")
    String requisitionId;





	public int getAssignedReqId() {
		return assignedReqId;
	}

	public void setAssignedReqId(int assignedReqId) {
		this.assignedReqId = assignedReqId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	


    
}

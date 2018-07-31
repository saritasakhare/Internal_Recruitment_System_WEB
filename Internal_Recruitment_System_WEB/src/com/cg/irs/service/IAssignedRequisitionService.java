package com.cg.irs.service;

import java.util.List;

import com.cg.irs.entity.AssignedRequisitionBean;
import com.cg.irs.exception.IRSException;

public interface IAssignedRequisitionService 
{
	//inserts data in assigned requisition and returns generated id
	public String insertAssignedRequisition(AssignedRequisitionBean assignedRequisitionBean) throws IRSException;
	
	//return list of all assigned requisitions of given RM
	public List<AssignedRequisitionBean> getAssignedRequisitions(String rmId) throws IRSException;

	//returns list of employee id's which are assigned to particular requisition 
	public List<String> getEmployeeIdsByRequisitionId(String requisitionId) throws IRSException;

	//deletes assigned requisition of given employee and requisition id
	public int deleteAssignedRequitision(String requisitionId, String employeeId) throws IRSException;
}

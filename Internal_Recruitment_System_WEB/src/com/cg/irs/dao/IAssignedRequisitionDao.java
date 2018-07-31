package com.cg.irs.dao;

import java.util.List;

import com.cg.irs.entity.AssignedRequisitionBean;
import com.cg.irs.exception.IRSException;

public interface IAssignedRequisitionDao 
{
	public String insertAssignedRequisition(AssignedRequisitionBean assignedRequisitionBean) throws IRSException;
	
	public List<AssignedRequisitionBean> getAssignedRequisitions(String rmId) throws IRSException;

	public List<String> getEmployeeIdsByRequisitionId(String requisitionId) throws IRSException; 

	public int deleteAssignedRequitision(String requisitionId, String employeeId) throws IRSException;
}

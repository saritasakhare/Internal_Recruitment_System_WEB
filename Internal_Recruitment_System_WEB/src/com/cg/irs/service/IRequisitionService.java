package com.cg.irs.service;

import java.util.List;

import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.exception.IRSException;

public interface IRequisitionService
{
	//Inserts Requisition Record in Database and returns Requisition bean
	public RequisitionBean insertRequisition(RequisitionBean requisitionBean) throws IRSException;
	
	//Returns list of requisitions
	public List<RequisitionBean> getAllRequisitions() throws IRSException;
	
	//Returns list of requisitions of specific RM
	public List<RequisitionBean> getSpecificRequisition(String rmId) throws IRSException;
	
	//Updates current status of given requisition id 
	public void updateStatus(String requisitionId,String currentStatus) throws IRSException;
	
	public RequisitionBean getRequisitionById(String requisitionId) throws IRSException;
	
	public List<RequisitionBean> getAssignedRequisitionsById(String id) throws IRSException;
	
	public List<RequisitionBean> getReportById(String rmId) throws IRSException ;
}

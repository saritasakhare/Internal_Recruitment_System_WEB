package com.cg.irs.dao;

import java.util.List;

import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.exception.IRSException;

public interface IRequisitionDao 
{
	public RequisitionBean insertRequisition(RequisitionBean requisitionBean) throws IRSException;

	public List<RequisitionBean> getAllRequisition() throws IRSException;
	
	public List<RequisitionBean> getSpecificRequisition(String rmId) throws IRSException;

	public void updateStatus(String requisitionId,String currentStatus) throws IRSException;
}

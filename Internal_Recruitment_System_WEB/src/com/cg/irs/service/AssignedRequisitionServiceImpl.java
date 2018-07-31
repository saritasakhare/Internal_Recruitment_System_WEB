package com.cg.irs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IAssignedRequisitionDao;
import com.cg.irs.entity.AssignedRequisitionBean;
import com.cg.irs.exception.IRSException;


@Service("assignedRequisitionService")
@Transactional
public class AssignedRequisitionServiceImpl implements IAssignedRequisitionService {
	
	@Autowired
	private IAssignedRequisitionDao assignedRequisitionDao;

	public IAssignedRequisitionDao getAssignedRequisitionDao() {
		return assignedRequisitionDao;
	}

	public void setAssignedRequisitionDao(
			IAssignedRequisitionDao assignedRequisitionDao) {
		this.assignedRequisitionDao = assignedRequisitionDao;
	}

	@Override
	public List<AssignedRequisitionBean> getAssignedRequisitions(String rmId) throws IRSException
	{
		return assignedRequisitionDao.getAssignedRequisitions(rmId);
	}

	@Override
	public String insertAssignedRequisition(AssignedRequisitionBean assignedRequisitionBean) throws IRSException
	{
		return assignedRequisitionDao.insertAssignedRequisition(assignedRequisitionBean);
	}

	@Override
	public List<String> getEmployeeIdsByRequisitionId(String requisitionId) throws IRSException 
	{	
		return assignedRequisitionDao.getEmployeeIdsByRequisitionId(requisitionId);
	}

	@Override
	public int deleteAssignedRequitision(String requisitionId, String employeeId) throws IRSException 
	{
		return assignedRequisitionDao.deleteAssignedRequitision(requisitionId, employeeId);
	}
	
}

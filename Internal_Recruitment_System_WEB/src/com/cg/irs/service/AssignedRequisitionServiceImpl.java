package com.cg.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IAssignedRequisitionDao;


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
	
}

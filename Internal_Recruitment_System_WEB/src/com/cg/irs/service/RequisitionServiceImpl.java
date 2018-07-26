package com.cg.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IRequisitionDao;

@Service("requisitionService")
@Transactional
public class RequisitionServiceImpl implements IRequisitionService {
	
	@Autowired
	private IRequisitionDao requisitionDao;

	public IRequisitionDao getRequisitionDao() {
		return requisitionDao;
	}

	public void setRequisitionDao(IRequisitionDao requisitionDao) {
		this.requisitionDao = requisitionDao;
	}
	
	
}

package com.cg.irs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IRequisitionDao;
import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.exception.IRSException;

@Service("requisitionService")
@Transactional
public class RequisitionServiceImpl implements IRequisitionService
{
	
	@Autowired
	private IRequisitionDao requisitionDao;

	public IRequisitionDao getRequisitionDao() {
		return requisitionDao;
	}

	public void setRequisitionDao(IRequisitionDao requisitionDao) {
		this.requisitionDao = requisitionDao;
	}

	@Override
	public RequisitionBean insertRequisition(RequisitionBean requisitionBean)throws IRSException 
	{
			return requisitionDao.insertRequisition(requisitionBean);
	}

	@Override
	public List<RequisitionBean> getAllRequisitions() throws IRSException
	{
		return requisitionDao.getAllRequisition();
	}

	@Override
	public List<RequisitionBean> getSpecificRequisition(String rmId) throws IRSException
	{
		return requisitionDao.getSpecificRequisition(rmId);
	}

	@Override
	public void updateStatus(String requisitionId, String currentStatus) throws IRSException
	{
		requisitionDao.updateStatus(requisitionId, currentStatus);
	}

	@Override
	public RequisitionBean getRequisitionById(String requisitionId) throws IRSException {
		
		return requisitionDao.getRequisitionById(requisitionId);
	}
	
	
}

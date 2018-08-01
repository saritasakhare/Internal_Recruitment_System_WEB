package com.cg.irs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IEmployeeDao;
import com.cg.irs.entity.EmployeeBean;
import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.exception.IRSException;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao employeeDao;

	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<EmployeeBean> getMatchingEmployeeList(RequisitionBean requisitionBean) throws IRSException 
	{
		return employeeDao.getMatchingEmployeeList(requisitionBean);
	}

	@Override
	public int updateProjectId(String empId, String projectId) throws IRSException 
	{
		return employeeDao.updateProjectId(empId, projectId);
	}

	@Override
	public List<EmployeeBean> getEmployeeListByIdList(List<String> idList) throws IRSException 
	{
		return employeeDao.getEmployeeListByIdList(idList);
	}

	@Override
	public EmployeeBean getEmployeeById(String empId) throws IRSException
	{
		return employeeDao.getEmployeeById(empId);
	}
	
	
}

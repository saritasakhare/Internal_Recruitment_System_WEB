package com.cg.irs.dao;

import java.util.List;

import com.cg.irs.entity.EmployeeBean;
import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.exception.IRSException;

public interface IEmployeeDao 
{
	public List<EmployeeBean> getMatchingEmployeeList(RequisitionBean requisitionBean) throws IRSException;

	public int updateProjectId(String empId, String projectId) throws IRSException;

	public List<EmployeeBean> getEmployeeListByIdList(List<String> idList) throws IRSException;

	public EmployeeBean getEmployeeById(String empId) throws IRSException;
}

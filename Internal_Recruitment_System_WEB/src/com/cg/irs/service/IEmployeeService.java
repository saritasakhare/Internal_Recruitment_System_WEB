package com.cg.irs.service;

import java.util.List;

import com.cg.irs.entity.EmployeeBean;
import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.exception.IRSException;

public interface IEmployeeService 
{
	//Returns list of employees who have matching skills and domain as per requisition
	public List<EmployeeBean> getMatchingEmployeeList(RequisitionBean requisitionBean) throws IRSException;

	//updates project id for respective employee
	public int updateProjectId(String empId, String projectId) throws IRSException;

	//returns list of details of employees whose id is present in ID list
	public List<EmployeeBean> getEmployeeListByIdList(List<String> idList) throws IRSException;

	//returns details of employee of given id
	public EmployeeBean getEmployeeById(String empId) throws IRSException;
}

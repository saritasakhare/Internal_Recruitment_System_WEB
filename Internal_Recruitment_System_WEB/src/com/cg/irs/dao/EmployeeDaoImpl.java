package com.cg.irs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.irs.entity.EmployeeBean;
import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.exception.IRSException;

@Repository("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao
{
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBean> getMatchingEmployeeList(RequisitionBean requisitionBean) throws IRSException
	{
		List<EmployeeBean> employees =null;
		try 
		{
			//Query query = entityManager.createNativeQuery("select * from employee where skill like '"+requisitionBean.getSkill()+"' and domain like '"+requisitionBean.getDomain()+"' and project_id='RMG' and project_id NOT LIKE 'ASSIGNED'");
			
			Query query = entityManager.createNativeQuery("select * from employee where skill like ? and domain like ? and project_id='RMG' and project_id NOT LIKE 'ASSIGNED'",EmployeeBean.class);
			query.setParameter(1, requisitionBean.getSkill());
			query.setParameter(2, requisitionBean.getDomain());
			
			employees=query.getResultList();
			
			if(employees.size()==0 || employees==null)
			{
				throw new Exception("Employees with matching skill or domain of requisition : "+requisitionBean.getRequisitionId()+" does not exists.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new IRSException("Unable fetch employees which matches skills of requisition : "+requisitionBean.getRequisitionId());
		}
		return employees;
	}

	@Override
	public int updateProjectId(String empId, String projectId) throws IRSException
	{
		int result=0;
		try 
		{
			Query query = entityManager.createNativeQuery("update employee set project_id=? where employee_id=?");
			query.setParameter(1, projectId);
			query.setParameter(2, empId);
			result=query.executeUpdate();
			if(result==0)
			{
				throw new Exception("Updation of project id failed");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new IRSException(e.getMessage()+"\nUnable update project ID of employee : "+empId);
		}
		return result;
	}

	@Override
	public List<EmployeeBean> getEmployeeListByIdList(List<String> idList) throws IRSException 
	{
		List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
		try 
		{
			for(String id : idList)
			{
				if(id!=null)
				{
					EmployeeBean emp = getEmployeeById(id);
					employees.add(emp);
				}
			}
			if(employees==null || employees.size()==0)
			{
				throw new Exception("Employees record not found");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new IRSException(e.getMessage()+"\nUnable fetch employee records");
		}
		
		return employees;
	}

	@Override
	public EmployeeBean getEmployeeById(String empId) throws IRSException
	{
		EmployeeBean employee =null;
		try 
		{
			employee=entityManager.find(EmployeeBean.class, empId);
			if(employee==null)
			{
				throw new Exception("Employee records not found");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new IRSException(e.getMessage()+"\nUnable fetch employee records with employee ID : "+empId);
		}
		return employee;
	}
}

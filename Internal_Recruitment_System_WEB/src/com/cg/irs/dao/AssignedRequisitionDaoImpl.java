package com.cg.irs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.irs.entity.AssignedRequisitionBean;
import com.cg.irs.entity.EmployeeBean;
import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;

@Repository("assignedRequisitionDao")
public class AssignedRequisitionDaoImpl implements IAssignedRequisitionDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<AssignedRequisitionBean> getAssignedRequisitions(String rmId) throws IRSException
	{
		List<AssignedRequisitionBean> assignedRequisitions =null;
		Query query=entityManager.createNamedQuery("getSpecificAssignedRequisition", AssignedRequisitionBean.class);
		query.setParameter("rmId",rmId);
		try 
		{
			assignedRequisitions=query.getResultList();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new IRSException("Unable to fetch Assigned Requisitions of RM : "+rmId);
		}
		return assignedRequisitions;
	}

	@Override
	public String insertAssignedRequisition(AssignedRequisitionBean assignedRequisitionBean) throws IRSException 
	{
		int id=0;
		try 
		{	
			entityManager.persist(assignedRequisitionBean);
			id=assignedRequisitionBean.getAssignedReqId();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new IRSException("Unable to add Assigned Requisition");
		}
		return ""+id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getEmployeeIdsByRequisitionId(String requisitionId) throws IRSException
	{
		List<String> empIds=null;
		try 
		{
			Query query = entityManager.createNativeQuery("select employee_id from assigned_requisition where requisition_id=:requisitionId");
			query.setParameter("requisitionId",requisitionId);
			
			empIds=query.getResultList();
			if(empIds==null || empIds.size()==0)
			{
				throw new Exception("Employees does not exist for requisition : "+requisitionId);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new IRSException(e.getMessage()+"\nUnable fetch employee ID's for requisition Id : "+requisitionId);
		}
		System.out.println("idList : "+empIds.size());
		return empIds;
	}

	@Override
	public int deleteAssignedRequitision(String requisitionId, String employeeId) throws IRSException 
	{
		int result=0;
		try 
		{
			Query query=entityManager.createNativeQuery("delete from assigned_requisition where requisition_id='"+requisitionId+"' and employee_id='"+employeeId+"'");
			result=query.executeUpdate();
			if(result==0)
			{
				throw new Exception("delete operation failed");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new IRSException(e.getMessage()+"\nUnable delete assigned requisition for requisition Id : "+requisitionId);
		}
		return result;
	}
	
}

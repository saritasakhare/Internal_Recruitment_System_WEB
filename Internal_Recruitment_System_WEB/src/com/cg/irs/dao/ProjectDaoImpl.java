package com.cg.irs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.irs.entity.ProjectBean;
import com.cg.irs.exception.IRSException;

@Repository("projectDao")
public class ProjectDaoImpl implements IProjectDao{
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectBean> getAllProjects() throws IRSException 
	{
		List<ProjectBean> projects =null;
		Query query=entityManager.createNamedQuery("getAllProjects", ProjectBean.class);
	
		try 
		{
			projects=query.getResultList();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new IRSException("Unable to fetch Projects No projects found ");
		}
		return projects;
	}
}

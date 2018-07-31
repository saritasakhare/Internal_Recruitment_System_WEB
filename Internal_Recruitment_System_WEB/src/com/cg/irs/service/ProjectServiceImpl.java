package com.cg.irs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IProjectDao;
import com.cg.irs.entity.ProjectBean;
import com.cg.irs.exception.IRSException;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private IProjectDao projectDao;

	@Override
	public List<ProjectBean> getAllProjects() throws IRSException 
	{
		return projectDao.getAllProjects();
	}
}

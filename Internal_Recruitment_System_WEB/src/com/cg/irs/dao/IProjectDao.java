package com.cg.irs.dao;

import java.util.List;

import com.cg.irs.entity.ProjectBean;
import com.cg.irs.exception.IRSException;

public interface IProjectDao
{
	public List<ProjectBean> getAllProjects() throws IRSException; 	
}

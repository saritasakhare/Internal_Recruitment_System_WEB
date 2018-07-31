package com.cg.irs.service;

import java.util.List;

import com.cg.irs.entity.ProjectBean;
import com.cg.irs.exception.IRSException;

public interface IProjectService 
{
	//Returns list containing details of all projects 
	public List<ProjectBean> getAllProjects() throws IRSException; 
}

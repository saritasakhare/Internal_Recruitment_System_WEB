package com.cg.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IProjectDao;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private IProjectDao projectDao;

	
	
}

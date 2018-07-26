package com.cg.irs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository("projectDao")
public class ProjectDaoImpl implements IProjectDao{
	@PersistenceContext
	EntityManager entityManager;
}

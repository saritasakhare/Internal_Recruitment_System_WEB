package com.cg.irs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("assignedRequisitionDao")
public class AssignedRequisitionDaoImpl implements IAssignedRequisitionDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
}

package com.cg.irs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository("requisitionDao")
public class RequisitionDaoImpl implements IRequisitionDao {
	@PersistenceContext
	EntityManager entityManager;
}

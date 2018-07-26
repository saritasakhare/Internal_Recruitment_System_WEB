package com.cg.irs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	@PersistenceContext
	EntityManager entityManager;
}

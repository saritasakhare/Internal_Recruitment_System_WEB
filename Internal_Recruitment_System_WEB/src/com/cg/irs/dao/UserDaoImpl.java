package com.cg.irs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public UserBean login(UserBean userBean) throws IRSException {
		
		try{
			
			
		}catch(Exception e)
		{
			
		}
		
		return null;
	}

	@Override
	public UserBean getUserDetail(UserBean userBean) throws IRSException {
		try{
			
			entityManager.find(UserBean.class,userBean);
		}
		catch(Exception e)
		{
			throw new IRSException("User Doesn't Exist");
		}
	}
}

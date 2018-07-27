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
	public UserBean getUserDetail(UserBean userBean) throws IRSException {
		UserBean user=null;
		try{
			System.out.println(userBean.getUserId());
			user=entityManager.find(UserBean.class,userBean.getUserId());
			if(user==null)
			{
				throw new IRSException("User Doesn't Exist");
			}
		}
		catch(Exception e)
		{
			throw new IRSException("Unable to find User "+e.getMessage());
		}
		return user;
	}
}

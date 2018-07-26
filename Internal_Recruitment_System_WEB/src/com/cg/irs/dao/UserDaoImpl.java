package com.cg.irs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
			
			//getUserDetail(userBean);
			userBean.setPassword("1234");
			System.out.println(userBean.getPassword()+userBean.getUserId());
			Query query = entityManager.createNamedQuery("login");
			query.setParameter("userId", userBean.getUserId());
			query.setParameter("password", userBean.getPassword());
			userBean=(UserBean) query.getSingleResult();
			if(userBean==null)
			{
				throw new IRSException("Wrong Password Access Denied!");
			}
		}catch(Exception e)
		{
			throw new IRSException("Unable to validate Password "+e.getMessage());
		}
		
		return userBean;
	}

	
	//Not Working
	@Override
	public UserBean getUserDetail(UserBean userBean) throws IRSException {
		UserBean user=null;
		try{
			
			user=entityManager.find(UserBean.class,userBean);
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

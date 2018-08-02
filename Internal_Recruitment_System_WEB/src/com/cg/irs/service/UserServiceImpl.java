package com.cg.irs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IUserDao;
import com.cg.irs.dao.UserDaoImpl;
import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	
	public UserServiceImpl() {
	}
	
	@Autowired
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserBean login(UserBean userBean) throws IRSException {
		
		System.out.print("\nservice getting user");
		
		
		UserBean user = userDao.getUserDetail(userBean);
		
		System.out.print("\nservice got user");
		
		if(user.getPassword().equals(userBean.getPassword()))
		{
			/**Removing Password**/
			userBean.setPassword("");	
			
		}
		else
		{
			throw new IRSException("Password Wrong");
		}
		return user;
	}

	@Override
	public UserBean getUserDetail(UserBean userBean) throws IRSException {
		
		System.out.print("\nservice getting user");
		
		userBean = userDao.getUserDetail(userBean);
		
		System.out.print("\nservice got user");
		
		/**Removing Password**/
		userBean.setPassword("");
		
		System.out.print("\nservice reset user");
		
		return userBean;
	}

	@Override
	public List<UserBean> getAllUsers(String userId) throws IRSException 
	{
		return userDao.getAllUsers(userId);
	}

	@Override
	public void deleteUser(String userId) throws IRSException 
	{
		 userDao.deleteUser(userId);
	}

	@Override
	public void updateUserRole(UserBean userBean) throws IRSException 
	{
		userDao.updateUserRole(userBean);		
	}

	@Override
	public UserBean addUser(UserBean userBean) throws IRSException {
		
		userBean=userDao.addUser(userBean);
		//Removing password from the bean
/*		userBean.setPassword("");	*/
		return userBean;
	}

	@Override
	public UserBean getUserById(String userId) throws IRSException {
		return userDao.getUserById(userId);
	}
	
	
}

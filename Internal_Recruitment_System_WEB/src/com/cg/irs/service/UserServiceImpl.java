package com.cg.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.irs.dao.IUserDao;
import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	
	public UserServiceImpl() {
		System.out.println("Created User");
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
		return userDao.login(userBean);
	}

	@Override
	public UserBean getUserDetail(UserBean userBean) throws IRSException {
		return userDao.getUserDetail(userBean);
	}
	
	
}

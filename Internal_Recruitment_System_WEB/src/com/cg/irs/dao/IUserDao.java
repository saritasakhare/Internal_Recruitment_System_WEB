package com.cg.irs.dao;

import java.util.List;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;

public interface IUserDao {
	
	//Should Return null if user enter Wrong Password
		public UserBean getUserDetail(UserBean userBean) throws IRSException;
		
		public List<UserBean> getAllUsers(String userId) throws IRSException;
		
		public void deleteUser(String userId) throws IRSException;
		
		public void updateUserRole(UserBean userBean) throws IRSException;
		
		public UserBean addUser(UserBean userBean) throws IRSException;
		
		public UserBean getUserById(String userId) throws IRSException;
}

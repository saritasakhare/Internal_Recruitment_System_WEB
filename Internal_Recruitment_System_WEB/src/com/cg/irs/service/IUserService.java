package com.cg.irs.service;

import java.util.List;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;

public interface IUserService {
	
	//Should Return null if user enter Wrong Password and Password Will be Null
	public UserBean login(UserBean userBean) throws IRSException;
	
	//Should Return null if user Doesn't and Password Will be Null
	
	public UserBean getUserDetail(UserBean userBean) throws IRSException;
	
	//Should return null if users does not exist
	public List<UserBean> getAllUsers(String userId) throws IRSException;
	
	//Deletes user details for given user id
	public void deleteUser(String userId) throws IRSException;
	
	//Update user role for given user 
	public void updateUserRole(UserBean userBean) throws IRSException;
	
	//Adding user and returning userBean without password
	public UserBean addUser(UserBean userBean) throws IRSException;
	
		
	
}

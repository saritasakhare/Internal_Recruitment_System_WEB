package com.cg.irs.service;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;

public interface IUserService {
	
	//Should Return null if user enter Wrong Password and Password Will be Null
	public UserBean login(UserBean userBean) throws IRSException;
	
	//Should Return null if user Doesn't and Password Will be Null
	public UserBean getUserDetail(UserBean userBean) throws IRSException;
}

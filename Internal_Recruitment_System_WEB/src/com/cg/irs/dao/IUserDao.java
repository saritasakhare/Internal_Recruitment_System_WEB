package com.cg.irs.dao;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;

public interface IUserDao {
	
	//Should Return null if user enter Wrong Password
		public UserBean getUserDetail(UserBean userBean) throws IRSException;
}

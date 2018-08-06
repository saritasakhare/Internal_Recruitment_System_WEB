package com.cg.irs.dao;

import java.util.List;

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
	public UserBean getUserDetail(UserBean userBean) throws IRSException {
		
		UserBean user=null;
		try{
			
			user=entityManager.find(UserBean.class,userBean.getUserId());
			
			if(user==null)
			{
				throw new IRSException("User Doesn't Exist");
			}
		}
		catch(Exception e)
		{
			throw new IRSException(e.getMessage());
		}
		
		return user;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserBean> getAllUsers(String userId) throws IRSException {
		
		List<UserBean> users =null;
		Query query=entityManager.createNamedQuery("getAllUsers", UserBean.class);
		query.setParameter("userId",userId);
		try 
		{
			users=query.getResultList();
		}
		catch (Exception e) 
		{
			throw new IRSException("Unable to fetch users No user found ");
		}
		return users;
	}


	@Override
	public void deleteUser(String userId) throws IRSException {
		
		UserBean userBean=this.getUserDetail(new UserBean(userId));
			try 
			{
				entityManager.remove(userBean);
			}
			catch (Exception e) 
			{
				throw new IRSException("Unable to delete user");
			}
	}


	@Override
	public void updateUserRole(UserBean userBean) throws IRSException {
		
		UserBean user=this.getUserDetail(userBean);
	
		//Setting new role
		user.setRole(userBean.getRole());
		try 
		{
			entityManager.merge(user);
		} 
		catch (Exception e) 
		{
			throw new IRSException("Unable to update user role as :"+user.getRole());
		}

	}


	@Override
	public UserBean addUser(UserBean userBean) throws IRSException {
		
		try
		{
			//System.out.println(" userId : "+userBean.getUserId()+" pswd : "+userBean.getPassword()+" role : "+userBean.getRole());
			
			userBean.setUserId(generateUserIdUsingSeq());
			entityManager.persist(userBean);
			entityManager.flush();
			
		} 
		catch (Exception e) 
		{
			throw new IRSException("Unable to add user");
		}
		return userBean;
	}
	
	/*
     * Generate Question Id using Static var.
     */
    static int id=0;
    public int generateUserId()
    {
        id++;
        return id;
    }
    
    /*
     * Generate Question Id using Sequence.
     */
    public String generateUserIdUsingSeq()
    {
        Query query = entityManager.createNativeQuery("select User_Id_Seq.nextval from dual");
        String id = ""+query.getSingleResult();
        return id;
    }


	@Override
	public UserBean getUserById(String userId) throws IRSException {
		
		UserBean user = entityManager.find(UserBean.class,userId);
		return user;
	}
	
	
}

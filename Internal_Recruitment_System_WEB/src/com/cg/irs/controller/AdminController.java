package com.cg.irs.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;
import com.cg.irs.service.IUserService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/addUser")
	public String getCreateUserPage(Model m)
	{
		m.addAttribute("addUser",new UserBean());
		return "admin/addUser";
	}
	
	@RequestMapping(value="processAddUser")
	public String processAddUser(@Valid @ModelAttribute("addUser") UserBean user,BindingResult rs, Model m)
	{
		
		try {
			
			UserBean userBean = userService.addUser(user);
			m.addAttribute("msg","User Created Successfully with Id : "+userBean.getUserId());
		} catch (IRSException e) {
			m.addAttribute("errMsg","Cant create User "+e.getMessage());
		}
		
		return "admin/addUser";
	}
	
	@RequestMapping("/assignRoles")
	public String getAssignRolePage(@RequestParam("userId") String userId, Model m)
	{
		//System.out.println("user Id : "+userId);
		if(userId!=null)
		{
			try {
				UserBean user = userService.getUserById(userId);
				m.addAttribute("User",user);
				
			} catch (IRSException e) {

				m.addAttribute("errMsg","Cant Assign Role to User "+e.getMessage());
			}
			
		}
		
		return "admin/assignRoles";
	}
	
	@RequestMapping("/processAssignRoles")
	public String processAssignRolePage(@Valid @ModelAttribute("User") UserBean user,BindingResult rs,Model m)
	{
		
		try {
			userService.updateUserRole(user);
			m.addAttribute("msg","User Role Updated Successfully for User Id : "+user.getUserId());
		} catch (IRSException e) {
			m.addAttribute("errMsg","Cant Assign Role to User "+e.getMessage());
		}
		
		return "admin/assignRoles";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") String userId, Model m)
	{
		try {
			
			userService.deleteUser(userId);
			List<UserBean> userList = userService.getAllUsers("101");
			m.addAttribute("userList",userList);
			m.addAttribute("msg","User Deleted");
			
			if(userList!=null)
				m.addAttribute("listSize", userList.size());
			
		} catch (IRSException e) {
			m.addAttribute("errMsg","Cant View Users : "+e.getMessage());
		}
		
		return "admin/viewAllUsers";
	}
	
	@RequestMapping("/viewAllUsers")
	public String getViewAllUserPage(Model m)
	{
		try {
			
			List<UserBean> userList = userService.getAllUsers("101");
			m.addAttribute("userList",userList);
			
			if(userList!=null)
				m.addAttribute("listSize", userList.size());
			
		} catch (IRSException e) {
			m.addAttribute("errMsg","Cant View Users : "+e.getMessage());
		}
		return "admin/viewAllUsers";
	}
	
}

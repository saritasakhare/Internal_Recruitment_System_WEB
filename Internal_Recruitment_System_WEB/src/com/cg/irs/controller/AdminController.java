package com.cg.irs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;
import com.cg.irs.service.IUserService;
import com.cg.irs.service.UserServiceImpl;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/addUser")
	public String getCreateUserPage(Model m)
	{
		m.addAttribute("user",new UserBean());
		return "admin/addUser";
	}
	
	@RequestMapping(value="processAddUser")
	public String processAddUser(@Valid @ModelAttribute("user") UserBean user,BindingResult rs, Model m)
	{
		try {
			
			UserBean userBean = userService.addUser(user);
			m.addAttribute("msg","User Created Successfully with Id : "+userBean.getUserId());
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "admin/addUser";
	}
	
	@RequestMapping("/assignRoles")
	public String getAssignRolePage(Model m)
	{
		m.addAttribute("user",new UserBean());
		return "admin/assignRoles";
	}
	
	@RequestMapping("/deleteUser")
	public String getDeleteUserPage(Model m)
	{
		m.addAttribute("user",new UserBean());
		return "admin/deleteUser";
	}
}

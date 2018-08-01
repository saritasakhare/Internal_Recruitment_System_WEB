package com.cg.irs.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;
import com.cg.irs.service.IAssignedRequisitionService;
import com.cg.irs.service.IEmployeeService;
import com.cg.irs.service.IProjectService;
import com.cg.irs.service.IRequisitionService;
import com.cg.irs.service.IUserService;


@Controller
public class IRSController
{
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRequisitionService requisitionService;
	
	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IAssignedRequisitionService assingnedRequistionService;
	

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IRequisitionService getRequisitionService() {
		return requisitionService;
	}


	public void setRequisitionService(IRequisitionService requisitionService) {
		this.requisitionService = requisitionService;
	}


	public IProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	public IAssignedRequisitionService getAssingnedRequistionService() {
		return assingnedRequistionService;
	}

	public void setAssingnedRequistionService(
			IAssignedRequisitionService assingnedRequistionService) {
		this.assingnedRequistionService = assingnedRequistionService;
	}

	/****************************************************
	  			Mapping
	  			
	 ***************************************************/

	@RequestMapping(value="/home")
	public String getHomePage(Model m)
	{
		return "Home";
	}
	
	@RequestMapping(value="/adminView")
	public String getAdminViewPage(Model m)
	{
		System.out.println("going to adminView");
		return "admin/adminView";
	}
	
	@RequestMapping(value="/resourceManagerView")
	public String getResourceManagerViewPage(Model m)
	{
		System.out.println("going to resourceManagerView");
		return "rm/resourceManagerView";
	}
	
	@RequestMapping(value="/resourceManagerExecutiveView")
	public String getResourceManagerExecutiveViewPage(Model m)
	{
		System.out.println("going to resourceManagerView");
		return "rmge/resourceManagerExecutiveView";
	}
	
	@RequestMapping(value="login.mvc",method=RequestMethod.POST)
	public String getHomePage(@RequestParam("userId") String userId, @RequestParam("password") String password,Model model)
	{
		String redirection ="";
		try{
			UserBean userBean = new UserBean();
			userBean.setPassword(password);
			userBean.setUserId(userId);			
			userBean = userService.login(userBean);
			redirection = userBean.getRole()+"HomePage";
		}
		catch(IRSException e)
		{
			model.addAttribute("msg", e.getMessage());
			return "../../login";
		}
		catch(Exception e)
		{
			model.addAttribute("msg", e.getMessage());
			return "Error";
		}	
		if(redirection.equals("ADMINHomePage"))
		{
			model.addAttribute("user", new UserBean());
		}
		return redirection;
	}
	
	@RequestMapping(value="adduser.mvc",method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") UserBean user ,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "ADMINHomePage";
		}
		try{
			user = userService.addUser(user);
		}
		catch(IRSException e)
		{
			model.addAttribute("msg", e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "Error";
		}	
		return "ADMINHomePage";
	}
	
}

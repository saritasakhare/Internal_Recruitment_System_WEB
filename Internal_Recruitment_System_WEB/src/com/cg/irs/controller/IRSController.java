package com.cg.irs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
	
	@RequestMapping(value="home.mvc")
	public String getHomePage(Model model)
	{
		System.out.println("In controller");
		UserBean userBean = new UserBean();
		userBean.setUserId("121");
		userBean.setPassword("12345");
		try {
			userBean=userService.getUserDetail(userBean);
			System.out.println(userBean.getRole());
		} catch (IRSException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "home";
	}
	
}

package com.cg.irs.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
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
	


	/****************************************************
	  			Mapping
	  			
	 ***************************************************/

	@RequestMapping(value="/home")
	public String getHomePage(HttpSession session,Model m)
	{
		UserBean user = (UserBean)session.getAttribute("user");
		String role = user.getRole().toLowerCase();
		String redirection = role+"/"+role+"View";
		
		return redirection;
	}
	
	@RequestMapping(value="/adminView")
	public String getAdminViewPage(Model m)
	{
		return "admin/adminView";
	}
	
	@RequestMapping(value="/resourceManagerView")
	public String getResourceManagerViewPage(Model m)
	{
		return "rm/resourceManagerView";
	}
	
	@RequestMapping(value="/resourceManagerExecutiveView")
	public String getResourceManagerExecutiveViewPage(Model m)
	{
		return "rmge/resourceManagerExecutiveView";
	}
	
	@RequestMapping(value="/login.mvc")
	public String getLogInPage(Model m)
	{
		return "login";
	}
	@RequestMapping(value="processLogin.mvc",method=RequestMethod.GET)
	public String getHomePage(@RequestParam("userId") String userId, @RequestParam("password") String password,HttpServletRequest req,HttpSession session,Model model)
	{
		//System.out.print("\nvallidating user ");
		
		String redirection ="";
		try{
			
			UserBean userBean = new UserBean();
			userBean.setPassword(password);
			userBean.setUserId(userId);			
			userBean = userService.login(userBean);
			
			session.setAttribute("user",userBean);
			
			String role = userBean.getRole().toLowerCase();
			
			redirection = role+"/"+role+"View";
		}
		catch(IRSException e)
		{
			model.addAttribute("errMsg", e.getMessage());
			//System.out.print("\nUser validation failed forwording to login");
			return "login";
		}
		catch(Exception e)
		{
			model.addAttribute("errMsg", e.getMessage());
			return "Error";
		}	
		
		return redirection;
	}
	
	@RequestMapping(value="logout.mvc")
	public String logout(HttpSession session,Model model)
	{
		//System.out.print("\nLogging Out..");
		session.setAttribute("user",null);
		return "login";
		
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
			model.addAttribute("msg", e.getMessage());
			return "Error";
		}	
		return "ADMINHomePage";
	}
	
}

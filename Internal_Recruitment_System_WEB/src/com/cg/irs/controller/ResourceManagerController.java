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

import com.cg.irs.dao.IAssignedRequisitionDao;
import com.cg.irs.entity.EmployeeBean;
import com.cg.irs.entity.ProjectBean;
import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;
import com.cg.irs.service.IAssignedRequisitionService;
import com.cg.irs.service.IEmployeeService;
import com.cg.irs.service.IRequisitionService;
import com.cg.irs.service.RequisitionServiceImpl;

@Controller
@RequestMapping(value="/rm")
public class ResourceManagerController {

	@Autowired
	private IRequisitionService requisitionService;
	@Autowired
	private IAssignedRequisitionService assignedRequisitionService;
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping(value="/raiseRequisition")
	public String getRaiseRequisitionPage(Model m)
	{
		RequisitionBean requisition =  new RequisitionBean();
		
		m.addAttribute("requisition",requisition);
		
		return "rm/raiseRequisition";
	}
	
	@RequestMapping(value="/processRaiseRequisition")
	public String processRaiseRequisition( @Valid @ModelAttribute("requisition") RequisitionBean requisition,BindingResult rs, Model m)
	{
		
		try {
			ProjectBean project = new ProjectBean();
			project.setProjectId("101");
			
			UserBean user = new UserBean();
			user.setUserId("102");
			
			requisition.setUserBean(user);
			requisition.setProjectBean(project);
			
			RequisitionBean req = requisitionService.insertRequisition(requisition);
			
			m.addAttribute("msg","SuccessFully Raised requisition with Id : "+req.getRequisitionId());
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "rm/raiseRequisition";
	}
	
	@RequestMapping(value="/viewAssignedRequisitions")
	public String getViewAssignedRequisitionsPage(Model m)
	{
		m.addAttribute("requisition", new RequisitionBean());
		return "rm/viewAssignedRequisitions";
	}
	
	@RequestMapping(value="/viewAssignedRequisition")
	public String getViewAssignedRequisitionPage(@RequestParam("requisitionId") String requisitionId, Model m)
	{
		
		try {
			
			List<String> empIdList = assignedRequisitionService.getEmployeeIdsByRequisitionId(requisitionId);
			List<EmployeeBean> empList = employeeService.getEmployeeListByIdList(empIdList);
			m.addAttribute("empList",empList);
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		m.addAttribute("requisitionsList", new RequisitionBean());
		return "rm/viewAssignedRequisition";
	}
	
	
	@RequestMapping(value="/viewAllRequisitions")
	public String viewAllRequisitions(Model m)
	{
		try {
			
			List<RequisitionBean> requisitionList = requisitionService.getAllRequisitions();
			m.addAttribute("requisitionList",requisitionList);
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "rm/viewAllRequisitions";
	}
	
	@RequestMapping(value="/viewRequisition")
	public String viewRequisition(@RequestParam("requisitionId") String requisitionId, Model m)
	{
		try {
			
			RequisitionBean requisition = requisitionService.getRequisitionById(requisitionId);
			m.addAttribute("requisition",requisition);
			
		} catch (IRSException e) {
			
			e.printStackTrace();
		} 
		return "rm/viewRequisition";
	}
	
	@RequestMapping(value="/saveAssignedRequisition")
	public String saveAssignedRequisition(@RequestParam("requisitionId") String requisitionId, Model m)
	{
		 
		return "rm/viewRequisition";
	}
	
}

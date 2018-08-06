package com.cg.irs.controller;

import java.util.Date;
import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.irs.entity.EmployeeBean;
import com.cg.irs.entity.IdList;
import com.cg.irs.entity.ProjectBean;
import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;
import com.cg.irs.service.IAssignedRequisitionService;
import com.cg.irs.service.IEmployeeService;
import com.cg.irs.service.IRequisitionService;

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
	public String processRaiseRequisition(@RequestParam("projectId") String projectId, @Valid @ModelAttribute("requisition") RequisitionBean requisition,BindingResult rs,HttpSession session, Model m)
	{
		
		try {
			ProjectBean project = new ProjectBean();
			project.setProjectId(projectId);
			UserBean user =  (UserBean)session.getAttribute("user");
			/*
			UserBean user = new UserBean();
			user.setUserId("103");
			*/
			requisition.setUserBean(user);
			requisition.setProjectBean(project);
			requisition.setCurrentStatus("OPEN");
			requisition.setDateCreated(new Date());
			
			RequisitionBean req = requisitionService.insertRequisition(requisition);
			
			m.addAttribute("msg","SuccessFully Raised requisition with Id : "+req.getRequisitionId());
			
		}
		catch (IRSException e ) {
			m.addAttribute("msg",e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e ) {
			m.addAttribute("errMsg","Unable to Raise reqisition");
			e.printStackTrace();
		} 
		
		return "rm/raiseRequisition";
	}
	
	@RequestMapping(value="/viewAssignedRequisitions")
	public String getViewAssignedRequisitionsPage(HttpSession session,Model m)
	{
		
		try {
			
			UserBean user = (UserBean)session.getAttribute("user");
			
			List<RequisitionBean> requisitionList = requisitionService.getAssignedRequisitionsById(user.getUserId());
			m.addAttribute("requisitionList",requisitionList);
			
			if(requisitionList!=null)
				m.addAttribute("listSize",requisitionList.size());
			else
				m.addAttribute("listSize",0);
			
		} catch (IRSException e) {
			e.printStackTrace();
		}

		return "rm/viewRequisitionsList";
	}
	
	@RequestMapping(value="/viewAssignedRequisition")
	public String getViewAssignedRequisitionPage(@RequestParam("requisitionId") String requisitionId, Model m)
	{
		
		try {
			
			List<String> empIdList = assignedRequisitionService.getEmployeeIdsByRequisitionId(requisitionId);
			
			System.out.println("\nempIdList : "+empIdList);
			
			List<EmployeeBean> empList = employeeService.getEmployeeListByIdList(empIdList);
			for(EmployeeBean emp:empList)
				System.out.println("\nemp : "+emp);
			
			m.addAttribute("empList",empList);
			m.addAttribute("idList",new IdList());
			m.addAttribute("requisitionId", requisitionId);
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "rm/viewAssignedRequisition";
	}
	
	
	@RequestMapping(value="/viewAllRequisitions")
	public String viewAllRequisitions(Model m)
	{
		try {
			
			List<RequisitionBean> requisitionList = requisitionService.getAllRequisitions();
			m.addAttribute("requisitionList",requisitionList);
			
			if(requisitionList!=null)
				m.addAttribute("listSize",requisitionList.size());
			else
				m.addAttribute("listSize",0);
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "rm/viewRequisitionsList";
	}
	
	@RequestMapping(value="/viewRequisition")
	public String viewRequisition(@RequestParam("requisitionId") String requisitionId, Model m)
	{
		try {
			
			RequisitionBean requisition = requisitionService.getRequisitionById(requisitionId);
			m.addAttribute("requisition",requisition);
			m.addAttribute("requisitionId",requisition.getRequisitionId());
			
		} catch (IRSException e) {
			
			e.printStackTrace();
		} 
		return "rm/viewRequisition";
	}
	
	@RequestMapping(value="/saveAssignedRequisition")
	public String saveAssignedRequisition(@RequestParam("requisitionId") String requisitionId,@ModelAttribute("idList") IdList idList,  Model m)
	{
		try
		{
				RequisitionBean requisition  = requisitionService.getRequisitionById(requisitionId);
				System.out.print("\nSubmitting...");	
				List<EmployeeBean> selectedList = employeeService.getEmployeeListByIdList(idList.getList());
				for(EmployeeBean emp : selectedList)
				{
					
					employeeService.updateProjectId(emp.getEmployeeId(),requisition.getProjectBean().getProjectId());
					
					assignedRequisitionService.deleteAssignedRequitision(requisitionId,emp.getEmployeeId());
					System.out.print("\n"+emp.getEmployeeId()+" Added. ");
				}
				
				requisitionService.updateStatus(requisitionId, "CLOSED");
				m.addAttribute("requisition",requisition);
				
				System.out.print("** Requisition Processed Successfully. **");
		}catch(IRSException e)
		{
			e.printStackTrace();
		}
		
		return "rm/viewRequisition";
	}
	
	/*
	  	Report link Mapping 
	 */
	
	@RequestMapping(value="/report")
	public String getReportpage(HttpSession session,Model m)
	{
		try {
			
			UserBean user = (UserBean)session.getAttribute("user");
			
			List<RequisitionBean> requisitionList = requisitionService.getReportById(user.getUserId());
			m.addAttribute("requisitionList",requisitionList);
			
		} catch (IRSException e) {
			e.printStackTrace();
		}

		return "rm/report";
	}
}

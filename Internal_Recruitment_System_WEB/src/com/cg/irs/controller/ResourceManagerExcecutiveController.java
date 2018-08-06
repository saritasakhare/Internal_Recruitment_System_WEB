package com.cg.irs.controller;

import java.util.List;






import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.irs.entity.AssignedRequisitionBean;
import com.cg.irs.entity.EmployeeBean;
import com.cg.irs.entity.IdList;
import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;
import com.cg.irs.service.IAssignedRequisitionService;
import com.cg.irs.service.IEmployeeService;
import com.cg.irs.service.IRequisitionService;

@Controller
@RequestMapping(value="/rmge")
public class ResourceManagerExcecutiveController {

	@Autowired
	IRequisitionService requisitionService;
	@Autowired
	IAssignedRequisitionService assignedRequisitionService;
	@Autowired
	IEmployeeService employeeService;
	
	@RequestMapping(value="viewAllRequisitions")
	public String getAllRequisitionsPage(Model m)
	{
		
		try {
			
			List<RequisitionBean> requisitionList = requisitionService.getAllRequisitions();
			m.addAttribute("requisitionList", requisitionList);
			if(requisitionList!=null)
				m.addAttribute("listSize",requisitionList.size());
			else
				m.addAttribute("listSize",0);
			
		} catch (IRSException e) {
			m.addAttribute("errMsg","Cant view requisition : "+e.getMessage());
		}
		
		return "rmge/viewAllRequisitions";
	}
	
	@RequestMapping(value="viewSpecificRequisitions")
	public String getSpecificRequisitions(Model m)
	{
		return "rmge/viewSpecificRequisitions";
	}
	
	@RequestMapping(value="processViewSpecificRequisitions")
	public String viewSpecificRequisitions(@RequestParam("rmId") String rmId, Model m)
	{
		
		try {
			
			List<RequisitionBean> list = requisitionService.getSpecificRequisition(rmId);
			m.addAttribute("requisitionList",list);
			if(list!=null)
				m.addAttribute("listSize",list.size());
			else
				m.addAttribute("listSize",0);
			
		} catch (IRSException e) {
			m.addAttribute("errMsg","Cant view requisition : "+e.getMessage());
		}
		
		return "rmge/viewAllRequisitions";
	}
	
	@RequestMapping(value="assignRequisition")
	public String getAssignRequisitionPage(@RequestParam("requisitionId") String requisitionId, Model m)
	{
		
		try {
			RequisitionBean req = requisitionService.getRequisitionById(requisitionId);
			List<EmployeeBean> empList = employeeService.getMatchingEmployeeList(req);
			if(req.getNumberRequired()>empList.size())
			{
				throw new IRSException("No Of Required Resources Not Available");
			}
			for(EmployeeBean emp:empList)
			System.out.println("\nemp : "+emp);
			
			m.addAttribute("employeeList",empList);
			m.addAttribute("idList", new IdList());
			m.addAttribute("requisitionId",requisitionId);
			
			if(empList!=null)
				m.addAttribute("listSize",empList.size());
			
		} catch (IRSException e) {
			m.addAttribute("errMsg","Error : "+e.getMessage());
		}
		
		return "rmge/assignRequisition";
	}
	
	@RequestMapping(value="saveAssignedRequisition")
	public String saveAssignRequisitionPage(@RequestParam("requisitionId")String requisitionId, @ModelAttribute("idList") IdList idList, Model m)
	{
		
		try {
			List<EmployeeBean> selectedList = employeeService.getEmployeeListByIdList(idList.getList());
			
			
			for(EmployeeBean emp : selectedList)
			{
				
				AssignedRequisitionBean assigned = new AssignedRequisitionBean();
				assigned.setEmployeeId(emp.getEmployeeId());
				assigned.setRequisitionId(requisitionId);
				assigned.setUserId("101");
				
				//System.out.println("\ninserting assigned requisition");
				
				assignedRequisitionService.insertAssignedRequisition(assigned);
				employeeService.updateProjectId(emp.getEmployeeId(),"ASSIGNED");
				m.addAttribute("msg","Employees assigned to Requisition Sucessfully!");
				
			}
			
			requisitionService.updateStatus(requisitionId,"ASSIGNED");
			//System.out.print("\n** Requisition Processed SuccessFully **");
			
		} catch (IRSException e) {
			m.addAttribute("errMsg","Cant assigend requisition : "+e.getMessage());
		}
		
		return getAllRequisitionsPage(m);
	}
	
	/*
  	Report link Mapping 
 */
	
	@RequestMapping(value="/report")
	public String getReportpage(HttpSession session,Model m)
	{
		try {
			
			UserBean user = (UserBean)session.getAttribute("user");
			
			List<RequisitionBean> requisitionList = requisitionService.getAllRequisitions();
			m.addAttribute("requisitionList",requisitionList);
			
			if(requisitionList!=null)
				m.addAttribute("listSize",requisitionList.size());
			else
				m.addAttribute("listSize",0);
			
		} catch (IRSException e) {
			m.addAttribute("errMsg","Cant view report :"+e.getMessage());
		}

		return "rmge/report";
	}

}
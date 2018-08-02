package com.cg.irs.controller;

import java.util.List;




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
			
		} catch (IRSException e) {
			e.printStackTrace();
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
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "rmge/viewAllRequisitions";
	}
	
	@RequestMapping(value="assignRequisition")
	public String getAssignRequisitionPage(@RequestParam("requisitionId") String requisitionId, Model m)
	{
		
		try {
			RequisitionBean req = requisitionService.getRequisitionById(requisitionId);
			List<EmployeeBean> empList = employeeService.getMatchingEmployeeList(req);
			
			for(EmployeeBean emp:empList)
			System.out.println("\nemp : "+emp);
			
			m.addAttribute("employeeList",empList);
			m.addAttribute("idList", new IdList());
			m.addAttribute("requisitionId",requisitionId);
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "rmge/assignRequisition";
	}
	
	@RequestMapping(value="saveAssignedRequisition")
	public String saveAssignRequisitionPage(@RequestParam("requisitionId")String requisitionId, @ModelAttribute("idList") IdList idList, Model m)
	{
		
		try {
			List<EmployeeBean> selectedList = employeeService.getEmployeeListByIdList(idList.getList());
			
			System.out.print("\nSubmitting....");
			for(EmployeeBean emp : selectedList)
			{
				
				AssignedRequisitionBean assigned = new AssignedRequisitionBean();
				assigned.setEmployeeId(emp.getEmployeeId());
				assigned.setRequisitionId(requisitionId);
				assigned.setUserId("101");
				
				System.out.println("\ninserting assigned requisition");
				
				assignedRequisitionService.insertAssignedRequisition(assigned);
				employeeService.updateProjectId(emp.getEmployeeId(),"ASSIGNED");
				
				System.out.print("\n "+emp.getEmployeeId()+" Added. ");
			}
			
			requisitionService.updateStatus(requisitionId,"ASSIGNED");
			System.out.print("\n** Requisition Processed SuccessFully **");
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "rmge/assignRequisition";
	}
}
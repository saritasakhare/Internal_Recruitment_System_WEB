package com.cg.irs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.irs.entity.RequisitionBean;
import com.cg.irs.entity.UserBean;
import com.cg.irs.exception.IRSException;
import com.cg.irs.service.IRequisitionService;
import com.cg.irs.service.RequisitionServiceImpl;

@Controller
@RequestMapping(value="/rm")
public class ResourceManagerController {

	@Autowired
	private IRequisitionService requisitionService;
	
	@RequestMapping(value="/raiseRequisition")
	public String getRaiseRequisitionPage(Model m)
	{
		m.addAttribute("requisition", new RequisitionBean());
		return "rm/raiseRequisition";
	}
	
	@RequestMapping(value="/processRaiseRequisition")
	public String processRaiseRequisition(@Valid @ModelAttribute("requisition") RequisitionBean requisition,BindingResult rs, Model m)
	{
		
		try {
			UserBean user = new UserBean();
			user.setUserId("101");
			
			requisition.setUserBean(user);
			RequisitionBean req = requisitionService.insertRequisition(requisition);
			m.addAttribute("msg","SuccessFully Raised requisition with Id : "+req.getRequisitionId());
			
		} catch (IRSException e) {
			e.printStackTrace();
		}
		
		return "rm/raiseRequisition";
	}
	
	@RequestMapping(value="/viewAssignedRequisitions")
	public String getvViewAssignedRequisitionsPage(Model m)
	{
		m.addAttribute("requisition", new RequisitionBean());
		return "rm/viewAssignedRequisitions";
	}
}

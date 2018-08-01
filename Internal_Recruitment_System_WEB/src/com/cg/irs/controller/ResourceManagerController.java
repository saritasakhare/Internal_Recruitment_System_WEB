package com.cg.irs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.irs.entity.RequisitionBean;

@Controller
@RequestMapping(value="/rm")
public class ResourceManagerController {

	@RequestMapping(value="/raiseRequisition")
	public String getRaiseRequisitionPage(Model m)
	{
		m.addAttribute("requisition", new RequisitionBean());
		return "rm/raiseRequisition";
	}
	
	@RequestMapping(value="/viewAssignedRequisitions")
	public String getvViewAssignedRequisitionsPage(Model m)
	{
		m.addAttribute("requisition", new RequisitionBean());
		return "rm/viewAssignedRequisitions";
	}
}

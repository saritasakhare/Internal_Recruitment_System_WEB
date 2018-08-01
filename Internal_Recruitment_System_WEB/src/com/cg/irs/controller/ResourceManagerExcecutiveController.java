package com.cg.irs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/rmge")
public class ResourceManagerExcecutiveController {

	@RequestMapping(value="viewAllRequisitions")
	public String getAllRequisitionsPage(Model m)
	{
		
		return "rmge/viewAllRequisitions";
	}
	
	@RequestMapping(value="viewSpecificRequisitions")
	public String getSpecificRequisitions(Model m)
	{
		return "rmge/viewSpecificRequisitions";
	}
}
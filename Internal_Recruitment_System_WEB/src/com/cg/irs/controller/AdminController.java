package com.cg.irs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.irs.entity.UserBean;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/createUser")
	public String getCreateUserPage(Model m)
	{
		m.addAttribute("user",new UserBean());
		return "admin/createUser";
	}
}

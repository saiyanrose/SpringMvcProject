package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

	@RequestMapping(value="/dashboard",method = RequestMethod.GET)
	public String dashboardPage(Model model){//show data on view page 
		try {
			
			model.addAttribute("pageTitle","Home-ProjectName");
		}catch (Exception e) {
			System.out.println("Home Controller-->welcomePage: "+e.getStackTrace());
			return "error/error500";
		}		
		return "index";
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcomePage(Model model){
		return "redirect:/dashboard";
	}
}

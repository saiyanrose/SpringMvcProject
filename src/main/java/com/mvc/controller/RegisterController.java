package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.models.User;
import com.mvc.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired private UserService userService;

	@RequestMapping(value ="/register",method = RequestMethod.GET)
	public String registerPage(Model model) {
		//country
		//state
		//cities		
		model.addAttribute("pageTitle", "Register-ProjectName");
		return "register/registerPage";
	}
	
	@RequestMapping(value ="/register/user",method = RequestMethod.POST)
	public String registerProcess(User user,RedirectAttributes redirectAttributes) {		
		boolean registerStatus=userService.registerUser(user);
		if(registerStatus) {
			redirectAttributes.addFlashAttribute("message","User successfully register.");
		}else {
			redirectAttributes.addFlashAttribute("error","Something went wrong.");
		}
		return "redirect:/register";
	}
}

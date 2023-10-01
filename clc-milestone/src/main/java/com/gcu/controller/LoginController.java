package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/")
public class LoginController {

	@GetMapping("/login")
	public ModelAndView display(Model model) {
		ModelAndView mv = new ModelAndView();

		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());

		mv.addObject(model);
		mv.setViewName("login");
		return mv;
	}

}
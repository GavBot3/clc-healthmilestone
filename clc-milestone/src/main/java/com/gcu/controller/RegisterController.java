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

import com.gcu.model.RegisterModel;

@Controller
@RequestMapping("/")
public class RegisterController {

	@GetMapping("/register")
	public ModelAndView display(Model model) {
		ModelAndView mv = new ModelAndView();

		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", new RegisterModel());

		mv.addObject(model);
		mv.setViewName("register");
		return mv;
	}

}
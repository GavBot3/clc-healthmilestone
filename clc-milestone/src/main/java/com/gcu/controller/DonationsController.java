package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class DonationsController {
    
    @GetMapping("/donations")
    public String getDonations(Model model){
    	model.addAttribute("title", "Donations");
    	model.addAttribute("donations", "DONATION");
        return "donations";
    }
	//public ModelAndView display(Model model) {
		/*ModelAndView mv = new ModelAndView();

		// Add attributes to the Spring Model object
		model.addAttribute("title", "Login Form"); // Add a "title" attribute with the value "Login Form"
		model.addAttribute("loginModel", new LoginModel()); // Add a "loginModel" attribute with a new instance of LoginModel

		mv.addObject(model); // Add the Model object to the ModelAndView
		mv.setViewName("login"); // Set the view name to "login" (a reference to a JSP or Thymeleaf template)
		return mv; // Return the ModelAndView object*/
	}


// Import necessary Java libraries and Spring Framework classes
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

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class RegisterController {

	// Handle HTTP GET requests to "/register" URL
	@GetMapping("/register")
	public ModelAndView display(Model model) {
		ModelAndView mv = new ModelAndView();

		// Add attributes to the Spring Model object
		model.addAttribute("title", "Register Form"); // Add a "title" attribute with the value "Register Form"
		model.addAttribute("registerModel", new RegisterModel()); // Add a "registerModel" attribute with a new instance of RegisterModel

		mv.addObject(model); // Add the Model object to the ModelAndView
		mv.setViewName("register"); // Set the view name to "register" (a reference to a JSP or Thymeleaf template)
		return mv; // Return the ModelAndView object
	}

}

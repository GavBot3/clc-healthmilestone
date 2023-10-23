// Import necessary Java libraries and Spring Framework classes
package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.LoginModel;
import jakarta.validation.Valid;

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class LoginController {
	private LoginModel loginModel; // Injected LoginModel bean

    @Autowired
    public LoginController(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

	// Handle HTTP GET requests to "/login" URL
	@GetMapping("/login")
	public ModelAndView display(Model model) {
		ModelAndView mv = new ModelAndView();

		// Add attributes to the Spring Model object
		model.addAttribute("title", "Login Form"); // Add a "title" attribute with the value "Login Form"
		model.addAttribute("loginModel", loginModel); // Add a "loginModel" attribute with a new instance of LoginModel

		mv.addObject(model); // Add the Model object to the ModelAndView
		mv.setViewName("login"); // Set the view name to "login" (a reference to a JSP or Thymeleaf template)
		return mv; // Return the ModelAndView object
	}

	@PostMapping("/loginsubmit")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
	
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
	
		return "dashboard";
	}

}

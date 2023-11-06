// Import necessary Java libraries and Spring Framework classes
package com.gcu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserService;
import com.gcu.model.RegisterModel;

import jakarta.validation.Valid;;

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class RegisterController {

    
	private final RegisterModel registerModel; // Injected RegisterModel bean
	@Autowired
	private UserService service;

    
    public RegisterController(RegisterModel registerModel) {
        this.registerModel = registerModel;
    }
	// Handle HTTP GET requests to "/register" URL
	@GetMapping("/register")
	public ModelAndView display(Model model) {
		ModelAndView mv = new ModelAndView();

		// Add attributes to the Spring Model object
		model.addAttribute("title", "Register Form"); // Add a "title" attribute with the value "Register Form"
		model.addAttribute("registerModel", registerModel); // Add a "registerModel" attribute with a new instance of RegisterModel

		mv.addObject(model); // Add the Model object to the ModelAndView
		mv.setViewName("register"); // Set the view name to "register" (a reference to a JSP or Thymeleaf template)
		return mv; // Return the ModelAndView object
	}

	@RequestMapping("/registersubmit")
	public String doLogin(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
	
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Register From");
			return "register";
		}

		//TODO: Create new user with vaild info
		if(service.createUser(registerModel)) {
			System.out.println("TRUE");
			return "dashboard";
		}
		
	
		return "register";
	}

}

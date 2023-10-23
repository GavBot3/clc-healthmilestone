package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.DonationsModel;


import jakarta.validation.Valid;

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class DonationsController {
    private DonationsModel donationsModel;

	@Autowired
    public DonationsController(DonationsModel donationsModel) {
        this.donationsModel = donationsModel;
    }

    @RequestMapping("/donations")
    public ModelAndView getDonations(Model model){
		ModelAndView mv = new ModelAndView();

		// Add attributes to the Spring Model object
		model.addAttribute("title", "Donations"); // Add a "title" attribute with the value "Register Form"
		model.addAttribute("donationsModel", donationsModel); // Add a "registerModel" attribute with a new instance of RegisterModel

		mv.addObject(model); // Add the Model object to the ModelAndView
		mv.setViewName("donations"); // Set the view name to "register" (a reference to a JSP or Thymeleaf template)
		return mv; // Return the ModelAndView object
    	
    }
    
	@RequestMapping("/donationsubmit")
	public String doLogin(@Valid DonationsModel donationsModel, BindingResult bindingResult, Model model) {
	
	
		return "dashboard";
	}

}


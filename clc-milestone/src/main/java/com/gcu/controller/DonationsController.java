package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.DonationsServiceInterface;
import com.gcu.business.MedicineServiceInterface;
import com.gcu.data.DataAccessInterface;
import com.gcu.data.DonationsDataService;
import com.gcu.model.DonationsModel;


import jakarta.validation.Valid;

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class DonationsController {

    @Autowired
    @Qualifier("donationsService")
    private DonationsServiceInterface service;



    @RequestMapping("/donations")
    public String getDonations(Model model){
		ModelAndView mv = new ModelAndView();

		// Add attributes to the Spring Model object
		model.addAttribute("title", "Donations"); // Add a "title" attribute with the value "Register Form"
		model.addAttribute("donationsModel", new DonationsModel()); // Add a "registerModel" attribute with a new instance of RegisterModel

		mv.addObject(model); // Add the Model object to the ModelAndView
		mv.setViewName("donations"); // Set the view name to "register" (a reference to a JSP or Thymeleaf template)
		return "donations"; // Return the ModelAndView object
    	
    }
    
	@RequestMapping("/donationsubmit")
	public String doLogin(@Valid DonationsModel donationsModel, BindingResult bindingResult, Model model) {
		
		System.out.println(donationsModel.getOrgan());
		if(service.createDonation(donationsModel)) {
			
			return "dashboard";
		}
		return "starter";
	}

}


package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.*;
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

	@Autowired
	DonationsDataService donationsDataService;
	@Autowired
	private UserService userService;

	@RequestMapping("/donations")
	public String getDonations(Model model) {
		ModelAndView mv = new ModelAndView();

		// Add attributes to the Spring Model object
		model.addAttribute("title", "Donations"); // Add a "title" attribute with the value "Register Form"
		model.addAttribute("donationsModel", new DonationsModel()); // Add a "registerModel" attribute with a new
																	// instance of RegisterModel

		mv.addObject(model); // Add the Model object to the ModelAndView
		mv.setViewName("donations"); // Set the view name to "register" (a reference to a JSP or Thymeleaf template)
		return "donations"; // Return the ModelAndView object

	}

	@RequestMapping("/donationsubmit")
	public String doLogin(@Valid DonationsModel donationsModel, BindingResult bindingResult, Model model) {

		System.out.println(donationsModel.getOrgan());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			int id = (int) userService.getUserIdFromUserDetails(userDetails);
			donationsModel.setUser_ID(id);

			System.out.println("Donations model in submit: " + donationsModel.getUser_ID());
			service.createDonation(donationsModel);
			model.addAttribute("donations", donationsDataService.findByID(id));

			return "dashboard";
		}
		return "dashboard";
	}

	@RequestMapping("/deleteDonation")
	public String showDeleteDonationPage(Model model) {
		// Add the donationsModel attribute to the model
		ModelAndView mv = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			int id = (int) userService.getUserIdFromUserDetails(userDetails);
			List<DonationsModel> userDonations = donationsDataService.findByID(id);
			// Add attributes to the Spring Model object
			model.addAttribute("title", "deleteDonation"); // Add a "title" attribute with the value "Register Form"
			model.addAttribute("userDonations", userDonations);
			model.addAttribute("donationsModel", new DonationsModel()); // Add a "registerModel" attribute with a new
																		// instance of RegisterModel

			mv.addObject(model); // Add the Model object to the ModelAndView
			mv.setViewName("deleteDonation"); // Set the view name to "register" (a reference to a JSP or Thymeleaf
												// template)
			return "deleteDonation"; // Return the ModelAndView object
		}
		return "deleteDonation";
	}

	@RequestMapping("/donationDeleteSubmit")
	public String doDelete(@Valid DonationsModel donationsModel, BindingResult bindingResult, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			int id = (int) userService.getUserIdFromUserDetails(userDetails);
			List<DonationsModel> userDonations = donationsDataService.findByID(id);
			// iterate through userDonations and make sure th id entered corresponds with
			// the users_id
			boolean isValid = false;
			for (DonationsModel donation : userDonations) {
				if (donation.getID() == donationsModel.getID()) {
					isValid = true;
				}
			}
			if (isValid) {
				service.deleteDonation(donationsModel);
			}
			model.addAttribute("donations", donationsDataService.findByID(id));
			return "dashboard";

		}

		return "dashboard";
	}

	@RequestMapping("/updateDonation")
	public String showUpdateDonationPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			int id = (int) userService.getUserIdFromUserDetails(userDetails);
			List<DonationsModel> userDonations = donationsDataService.findByID(id);

			// Add attributes to the Spring Model object
			model.addAttribute("title", "updateDonation"); // Add a "title" attribute with the value "Register Form"
			model.addAttribute("donationsModel", new DonationsModel()); // Add a "registerModel" attribute with a new //
																		// instance of RegisterModel
			model.addAttribute("donationList", userDonations);

			return "updateDonation";
		}
		return "updateDonation";

	}

	@RequestMapping("/updateDonationSubmit")
	public String doUpdate(@Valid DonationsModel donationsModel, BindingResult bindingResult, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			int id = (int) userService.getUserIdFromUserDetails(userDetails);
			List<DonationsModel> userDonations = donationsDataService.findByID(id);
			// iterate through userDonations and make sure th id entered corresponds with
			// the users_id
			donationsModel.setUser_ID(id);
			boolean isValid = false;
			for (DonationsModel donation : userDonations) {
				if (donation.getID() == donationsModel.getID()) {
					isValid = true;
				}
			}
			System.out.println("donation Model ID" + donationsModel.getID());
			if (isValid) {
				System.out.println("Update is VALID");
				service.updateDonation(donationsModel);
			}
			model.addAttribute("donations", donationsDataService.findByID(id));

			return "dashboard";
		}
		return "dashboard";
	}

}

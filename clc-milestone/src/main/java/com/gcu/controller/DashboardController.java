// Import necessary Spring Framework classes
package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.DonationsService;
import com.gcu.business.UserService;
import com.gcu.data.DonationsDataService;
import com.gcu.model.DonationsModel;


@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class DashboardController {

	@Autowired
    private UserService userService;
	@Autowired
    private DonationsDataService donationsDataService;

    // Handle HTTP GET requests to "/home" URL
    @RequestMapping("/dashboard")
    public String printAct(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	 if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
             UserDetails userDetails = (UserDetails) authentication.getPrincipal();

             // Now, you have access to UserDetails, and you can use it in your controller logic
             String username = userDetails.getUsername();
             System.out.print(username);
             int id = (int) userService.getUserIdFromUserDetails(userDetails);
             System.out.print(id);
             List<DonationsModel> donations = donationsDataService.findByID(id);
             
        
        
         model.addAttribute("title", "Welcome To Our Health Services"); // Add a "title" attribute with a welcome message

        	 model.addAttribute("donations", donations);
        	 
         

         //call method to view
    	 }
    	 
        return "dashboard"; // Return the name of the view, in this case, "starter" (a reference to a JSP or Thymeleaf template)
    }

}
// Import necessary Spring Framework classes
package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
<<<<<<< Updated upstream
import com.gcu.business.MedicineService;
import com.gcu.business.MedicineServiceInterface;
=======
import com.gcu.business.UserService;
import com.gcu.data.DonationsDataService;
import com.gcu.model.DonationsModel;
>>>>>>> Stashed changes


@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class DashboardController {

	@Autowired
<<<<<<< Updated upstream
    private DonationsService service;
	@Autowired
	@Qualifier("MedicineServiceInterface")
	private MedicineServiceInterface medicines;

=======
    private UserService userService;
	@Autowired
    private DonationsDataService donationsDataService;
>>>>>>> Stashed changes

    // Handle HTTP GET requests to "/home" URL
    @RequestMapping("/dashboard")
    public String printAct(Model model) {
<<<<<<< Updated upstream
        model.addAttribute("title", "Welcome To Our Health Services"); // Add a "title" attribute with a welcome message
        //call method to view
        model.addAttribute("donations", service.getDonations());
        model.addAttribute("medicines", medicines.getMedicines());
=======
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
    	 
>>>>>>> Stashed changes
        return "dashboard"; // Return the name of the view, in this case, "starter" (a reference to a JSP or Thymeleaf template)
    }

}
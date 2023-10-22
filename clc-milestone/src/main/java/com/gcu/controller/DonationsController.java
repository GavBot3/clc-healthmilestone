package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class DonationsController {
    
    @RequestMapping("/donations")
    public String getDonations(Model model){
    	model.addAttribute("title", "Donations");
        return "donations";
    }

}


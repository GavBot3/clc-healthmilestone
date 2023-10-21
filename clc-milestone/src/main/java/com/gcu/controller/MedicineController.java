package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.MedicineServiceInterface;

import org.springframework.ui.Model;

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class MedicineController {
    @Autowired
    private MedicineServiceInterface service;

    @RequestMapping("/medicines")
    public String printAct(Model model) {
        model.addAttribute("title", "Medicines"); // Add a "title" attribute with a welcome message
        model.addAttribute("medicines", service.getMedicines());
        return "medicines"; // Return the name of the view, in this case, "starter" (a reference to a JSP or Thymeleaf template)
    }
}
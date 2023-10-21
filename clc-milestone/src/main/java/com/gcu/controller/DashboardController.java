// Import necessary Spring Framework classes
package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // This class is annotated as a Spring MVC controller
@RequestMapping("/") // All mappings in this controller start with "/"
public class DashboardController {

    // Handle HTTP GET requests to "/home" URL
    @RequestMapping("/dashboard")
    public String printAct(Model model) {
        model.addAttribute("title", "Welcome To Our Health Services"); // Add a "title" attribute with a welcome message
        return "dashboard"; // Return the name of the view, in this case, "starter" (a reference to a JSP or Thymeleaf template)
    }

}
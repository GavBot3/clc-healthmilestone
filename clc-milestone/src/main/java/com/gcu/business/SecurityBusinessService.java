package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.RegistrationsDataService;
import com.gcu.data.DataAccessInterface;
import com.gcu.model.RegisterModel;

@Service
public class SecurityBusinessService {
    @Autowired
    DataAccessInterface<RegisterModel> service;

    // Method for authenticating users based on username and password
    public boolean authenticate(String username, String password) {
        
        List<RegisterModel> users = new ArrayList<RegisterModel>();
        
        // Retrieve a list of registered users from the data service
        users = service.findAll();
        
        // Loop through the list of users and check for a matching username and password
        for (RegisterModel user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                // Return true if authentication is successful
                return true;
            }
        }
        
        // Return false if no matching user is found
        return false;
    }
}

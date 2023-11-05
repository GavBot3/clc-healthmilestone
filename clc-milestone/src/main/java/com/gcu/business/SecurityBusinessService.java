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

	public boolean authenticate(String username, String password) {
		
        List<RegisterModel>  users = new ArrayList<RegisterModel>();
        users = service.findAll();
        for(RegisterModel user : users){
            if(username == user.getUsername() && password == user.getPassword()){
                return true;
            }
        }
        return false;
       
	}
	

}
package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import com.gcu.model.MedicineModel;
import com.gcu.model.RegisterModel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import com.gcu.data.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserServiceInterface{

    @Autowired
	public DataAccessInterface<RegisterModel> service;

	@Override
	public void init() {
		
		throw new UnsupportedOperationException("Unimplemented method 'init'");
	}

	@Override
	public void destroy() {
		
		throw new UnsupportedOperationException("Unimplemented method 'destroy'");
	}

	@Override
	public List<RegisterModel> getUsers() {
		return null;
		
	}

	@Override
	public boolean createUser(RegisterModel model) {
		
        return service.create(model);
        
		
	}

   

}
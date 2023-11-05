package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import com.gcu.model.MedicineModel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import com.gcu.data.*;


import org.springframework.beans.factory.annotation.Autowired;



public class MedicineService implements MedicineServiceInterface{

    @Autowired
	public DataAccessInterface<MedicineModel> service;

   
    @Override
    public List<MedicineModel> getMedicines()
    {
        return service.findAll();
    }

    
	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("Initialize Medicine Service");

	}


	@Override
	@PreDestroy
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy Medicine Service");
	}

}
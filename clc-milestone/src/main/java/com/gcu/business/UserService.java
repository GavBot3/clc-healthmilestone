package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import com.gcu.model.MedicineModel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import com.gcu.data.*;


import org.springframework.beans.factory.annotation.Autowired;



public class UserService {

    @Autowired
	public DataAccessInterface<MedicineModel> service;

   

}
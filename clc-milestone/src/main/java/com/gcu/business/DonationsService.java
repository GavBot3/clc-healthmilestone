package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.DonationsModel;



@Service

public class DonationsService implements DonationsServiceInterface{

	@Autowired
	DataAccessInterface<DonationsModel> service;
	
	@Override
	public List<DonationsModel> getDonations() {
		// TODO Auto-generated method stub
		List<DonationsModel> orders = service.findAll();
		return orders;
		
	}

	@Override
	public boolean createDonation(DonationsModel dm) {
		// TODO Auto-generated method stub
		try{
			service.create(dm);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}

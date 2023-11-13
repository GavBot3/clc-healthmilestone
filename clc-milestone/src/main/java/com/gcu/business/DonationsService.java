package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.DonationsModel;



@Service

public class DonationsService implements DonationsServiceInterface{

	@Autowired
	DataAccessInterface<DonationsModel> service;
	

	public List<DonationsModel> getDonations() {
		
		return service.findAll();
		
	}


	public boolean createDonation(DonationsModel dm) {

		try{
			service.create(dm);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}


	public boolean deleteDonation(DonationsModel dm) {

		try{
			service.delete(dm);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}


	public boolean updateDonation(DonationsModel dm) {
		try{
			service.update(dm);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}

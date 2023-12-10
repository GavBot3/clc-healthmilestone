package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.MedicineService;
import com.gcu.business.UserService;
import com.gcu.data.DonationsDataService;
import com.gcu.model.DonationsModel;
import com.gcu.model.MedicineModel;


@RestController
@RequestMapping("/service")
public class APIController {
	
	@Autowired
	private DonationsDataService service;
	@Autowired
	private UserService userService;
	@Autowired
	private MedicineService medicineService;
	
	//API path to get all users donations
	@GetMapping(path="/getdonation", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<DonationsModel> getDonations(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("GET HERE?");
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			System.out.println("Authenticated?");
			int id = (int) userService.getUserIdFromUserDetails(userDetails);
			System.out.println("ID?" + id);
			//Here we have an ID, get all within that ID
			List<DonationsModel> donations = service.findByID(id);
			System.out.println("Returning donations " + donations.size());
			return donations;
		}
		System.out.println("Returning null");

		return null;
	}
		
	
	//API path to get specific donation
	@GetMapping(path="/getdonation/{id}")
	public ResponseEntity<?> getDonationById(@PathVariable("id") int donationId){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			int userId = (int) userService.getUserIdFromUserDetails(userDetails);
			try {
				List<DonationsModel> userDonations = service.findByID(userId);
				boolean isValid = false;
				for (DonationsModel donation : userDonations) {
					if (donation.getID() == donationId) {
						isValid = true;
					}
				}
				if (isValid) {
					//return
					DonationsModel dm = service.findByDonationID(donationId);
					if(dm == null) {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}else {
						return new ResponseEntity<>(dm, HttpStatus.OK);
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
	
	
	@GetMapping(path = "/getMedicines", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getMedicines() {
		try {

			List<MedicineModel> medicines = medicineService.getMedicines();
			if (medicines.isEmpty())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);

			else
				return new ResponseEntity<>(medicines, HttpStatus.OK);
		}

		catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DonationsModel {
    @NotNull(message = "ID is a required field") // First name must not be null
    @Size(min = 1, max = 32, message = "ID must be and int") // First name must be between 1 and 32 characters in length
    private int ID;
    
    @NotNull(message = "Organ is a required field") // Last name must not be null
    @Size(min = 1, max = 32, message = "Organ must be between 1 and 32 characters") // Last name must be between 1 and 32 characters in length
    private String organ;
    
    @NotNull(message = "Last name is a required field") // Last name must not be null
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") // Last name must be between 1 and 32 characters in length
    private String donation_date;
    
    
    @NotNull(message = "UserID is a required field") // Email must not be null
    @Size(min = 1, max = 32, message = "UserID must be an int") // Email must be between 1 and 32 characters in length
    private int user_ID;

    public DonationsModel() {
    	
    }
	public DonationsModel(int id, String organ, String donation_date, int user_id) {
		// TODO Auto-generated constructor stub
		this.ID = id;
		this.organ = organ;
		this.donation_date = donation_date;
		this.user_ID = user_id;
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getOrgan() {
		return organ;
	}


	public void setOrgan(String organ) {
		this.organ = organ;
	}


	public String getDonation_date() {
		return donation_date;
	}


	public void setDonation_date(String donation_date) {
		this.donation_date = donation_date;
	}


	public int getuser_ID() {
		return user_ID;
	}


	public void setuser_ID(int userID) {
		user_ID = userID;
	}


    
    
}
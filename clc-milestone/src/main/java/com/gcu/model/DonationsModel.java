package com.gcu.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DonationsModel {

    private int ID;
    
    @NotNull(message = "Organ is a required field") // Last name must not be null
    @Size(min = 1, max = 32, message = "Organ must be between 1 and 32 characters") // Last name must be between 1 and 32 characters in length
    private String organ;
    
    @NotNull(message = "Last name is a required field") // Last name must not be null
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") // Last name must be between 1 and 32 characters in length
    private String donation_date;
    
    
    @NotNull(message = "User ID is a required field")
    @Min(value = 1, message = "User ID must be at least 1")
    @Max(value = 4, message = "User ID must be at most 2147483647") // Adjust the maximum value as needed
    private int user_ID;

    public DonationsModel() {
    	
    }
	public DonationsModel(int ID, String organ, String donation_date, int user_id) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.organ = organ;
		this.donation_date = donation_date;
		this.user_ID = user_id;
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int ID) {
		this.ID = ID;
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


	public int getUser_ID() {
		return user_ID;
	}


	public void setUser_ID(int userID) {
		user_ID = userID;
	}


    
    
}

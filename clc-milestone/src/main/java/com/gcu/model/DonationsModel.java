package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DonationsModel {
    @NotNull(message = "First name is a required field") // First name must not be null
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") // First name must be between 1 and 32 characters in length
    private String firstName;
    
    @NotNull(message = "Last name is a required field") // Last name must not be null
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") // Last name must be between 1 and 32 characters in length
    private String lastName;
    
    @NotNull(message = "Organ is a required field") // Last name must not be null
    @Size(min = 1, max = 32, message = "Organ must be between 1 and 32 characters") // Last name must be between 1 and 32 characters in length
    private String organ;
    
    @NotNull(message = "Email is a required field") // Email must not be null
    @Size(min = 1, max = 32, message = "Email must be between 1 and 32 characters") // Email must be between 1 and 32 characters in length
    private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrgan() {
		return organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

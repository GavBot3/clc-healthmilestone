package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterModel {
    
    @NotNull(message = "User name is a required field")
	@Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters")
	private String firstName;
	
	
	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String lastName;

    @NotNull(message = "User name is a required field")
	@Size(min = 10, max = 10, message = "User name must be between 1 and 32 characters")
	private int phoneNumber;
	
	
	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String email;

    @NotNull(message = "User name is a required field")
	@Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters")
	private String username;
	
	
	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String password;


// Getters and setters for firstName
public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

// Getters and setters for lastName
public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

// Getters and setters for phoneNumber
public int getPhoneNumber() {
    return phoneNumber;
}

public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    

}

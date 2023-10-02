package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// A Java class representing the model for the registration form
public class RegisterModel {
    
    // Define validation constraints for the first name field
    @NotNull(message = "First name is a required field") // First name must not be null
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters") // First name must be between 1 and 32 characters in length
    private String firstName;
    
    // Define validation constraints for the last name field
    @NotNull(message = "Last name is a required field") // Last name must not be null
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters") // Last name must be between 1 and 32 characters in length
    private String lastName;

    // Define validation constraints for the phone number field
    @NotNull(message = "Phone number is a required field") // Phone number must not be null
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 characters") // Phone number must be exactly 10 characters in length
    private int phoneNumber;
    
    // Define validation constraints for the email field
    @NotNull(message = "Email is a required field") // Email must not be null
    @Size(min = 1, max = 32, message = "Email must be between 1 and 32 characters") // Email must be between 1 and 32 characters in length
    private String email;

    // Define validation constraints for the username field
    @NotNull(message = "Username is a required field") // Username must not be null
    @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") // Username must be between 1 and 32 characters in length
    private String username;
    
    // Define validation constraints for the password field
    @NotNull(message = "Password is a required field") // Password must not be null
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") // Password must be between 1 and 32 characters in length
    private String password;

    // Getter and setter methods for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter methods for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and setter methods for phoneNumber
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter methods for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

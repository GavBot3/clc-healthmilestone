package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@ComponentScan({"com.gcu"})
@SpringBootApplication
public class ClcMilestoneApplication {
		
		

	public static void main(String[] args) {
		SpringApplication.run(ClcMilestoneApplication.class, args);
		String plaintextpassword ="password";
		String encoded = new BCryptPasswordEncoder().encode(plaintextpassword);
		System.out.println(plaintextpassword + " encoded as: " + encoded);
	}

}

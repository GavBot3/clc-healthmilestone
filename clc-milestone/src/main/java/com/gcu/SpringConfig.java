package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.MedicineService;
import com.gcu.business.MedicineServiceInterface;

@Configuration
public class SpringConfig {

    public SpringConfig() {
		// TODO Auto-generated constructor stub
	}

	@Bean(name="MedicineServiceInterface")
	public MedicineServiceInterface getMedicineBusiness() {
		//medicine service
		return new MedicineService();
	}

}

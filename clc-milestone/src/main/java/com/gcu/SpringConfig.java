package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.MedicineService;
import com.gcu.business.MedicineServiceInterface;
import com.gcu.model.DonationsModel;
import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;

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
	
	@Bean
    public LoginModel loginModel() {
        return new LoginModel();
    }
	
    @Bean
    public RegisterModel registerModel() {
        return new RegisterModel();
    }

	@Bean
    public DonationsModel donationsModel() {
        return new DonationsModel();
    }

}

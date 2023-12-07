package com.gcu;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.DonationsService;
import com.gcu.business.MedicineService;
import com.gcu.business.MedicineServiceInterface;
import com.gcu.model.DonationsModel;
import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;
import com.gcu.business.*;

@Configuration
public class SpringConfig {



    public SpringConfig() {
		// TODO Auto-generated constructor stub
	}

	    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:8889/clc_milestone");
		dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

	@Bean(name="MedicineServiceInterface")
	public MedicineServiceInterface getMedicineBusiness() {
		//medicine service
		return new MedicineService();
	}
	
	@Bean(name="UserServiceInterface")
	public UserServiceInterface getUserBusiness(DataSource dataSource) {
		//medicine service
		return new UserService(dataSource);
	}
	

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public LoginModel loginModel() {
        return new LoginModel();
    }
	
    @Bean
    public RegisterModel registerModel() {
        return new RegisterModel();
    }
	@Primary
	@Bean(name="DonationsServiceInterface")
    public DonationsServiceInterface getDonationsBusiness() {
        return new DonationsService();
    }

}

package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.UserService;

@Configuration
@EnableWebSecurity	
public class SecurityConfig {

	@Autowired
	private UserService service;
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		.httpBasic()
		.and()
		.authorizeRequests()
		.requestMatchers("/service/**").authenticated()
		.and()
		.authorizeRequests()
		.requestMatchers("/", "/images/**", "/displayDauthCode").permitAll()
		.anyRequest().authenticated().and()
		.formLogin()
		.loginPage("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll()
		.defaultSuccessUrl("/dashboard", true)
		.and()
		.logout()
		.logoutUrl("/logout")
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.permitAll()
		.logoutSuccessUrl("/");
	    
		return http.build();		
	}
	
	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);
		
	}
}

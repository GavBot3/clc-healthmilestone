package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import com.gcu.business.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserService service;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/", "/images/**", "/service/**","/home", "/login", "/register/**",
								"/loginsubmit", "/registersubmit")
						.permitAll()
						//.requestMatchers("/service/**").authenticated()
						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/login")
						.usernameParameter("username")
						.passwordParameter("password")
						.permitAll()
						.defaultSuccessUrl("/dashboard", true))
				.logout(logout -> logout
						.logoutUrl("/logout")
						.invalidateHttpSession(true)
						.clearAuthentication(true)
						.permitAll()
						.logoutSuccessUrl("/"));
		return http.build();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("Configuring authentication manager");
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);

	}

	private String clientId = "41efe9a337e083ade3da";
	private String clientSecert = "498fece8b66b36a0dda8369e07f71b491e4737bd";
	private String redirectUri = "http://localhost:8080/login/oauth2/code/github";

//	@Bean
//	public ClientRegistrationRepository clientRegistrationRepository() {
//		ClientRegistration registration = ClientRegistration.withRegistrationId("github")
//				.clientId(clientId)
//				.clientSecret(clientSecert)
//				.redirectUri(redirectUri)
//				.authorizationUri("https://github.com/login/oauth/authorize")
//				.tokenUri("https://github.com/login/oauth/access_token")
//				.userInfoUri("https://api.github.com/user")
//				.userNameAttributeName("id")
//				.clientName("GitHub")
//				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE).build();
//		return new InMemoryClientRegistrationRepository(registration);
//	}

}

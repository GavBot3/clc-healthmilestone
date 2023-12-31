package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gcu.model.LoginModel;
import com.gcu.model.MedicineModel;
import com.gcu.model.RegisterModel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import com.gcu.data.*;
import com.gcu.data.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;


@Service
public class UserService implements UserDetailsService, UserServiceInterface{

	
	@Autowired
	RegistrationsDataService service;
	
	@Autowired 
	UserDataAccess dao;


    public UserService(DataSource dataSource) {

    }

    public long getUserIdFromUserDetails(UserDetails userDetails) {
        String username = userDetails.getUsername();
        UserEntity user = dao.findByUsername(username);
        return user != null ? user.getId() : -1;
    }

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		UserEntity user = dao.findByUsername(username);
		if (username != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		} else {

			throw new UsernameNotFoundException("username not found");
		}
        //return userDetailsManager.loadUserByUsername(username);
    }

	@Override
	public void init() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'init'");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'destroy'");
	}

	@Override
	public List<RegisterModel> getUsers() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
	}

	@Override
	public boolean createUser(RegisterModel model) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'createUser'");
		//This is where a newly registered user will add to database!
		return service.create(model);
	}


   

}
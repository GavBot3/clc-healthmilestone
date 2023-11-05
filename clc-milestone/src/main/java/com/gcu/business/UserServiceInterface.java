package com.gcu.business;

import java.util.List;

import com.gcu.model.RegisterModel;

public interface UserServiceInterface {

    public void init();
	public void destroy();
	public List<RegisterModel> getUsers();
    public boolean createUser(RegisterModel model);
	
}

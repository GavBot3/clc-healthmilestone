package com.gcu.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.sql.DataSource;
import com.gcu.model.LoginModel;

@Service
public class UserDataAccess implements DataAccessInterface<LoginModel>{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	
	public UserDataAccess(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}



	@Override
	public List<LoginModel> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}



	@Override
	public LoginModel findByID(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByID'");
	}

	// public UserEntity findByUsername(String username){

	// }



	@Override
	public boolean create(LoginModel t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'create'");
	}



	@Override
	public boolean update(LoginModel t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}



	@Override
	public boolean delete(LoginModel t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

}
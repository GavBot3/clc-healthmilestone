package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.MedicineModel;
import com.gcu.model.RegisterModel;


@Service
public class RegistrationsDataService implements DataAccessInterface<RegisterModel>{

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	
	
	public RegistrationsDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}




	@Override
	public RegisterModel findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(RegisterModel t) {
		// TODO Auto-generated method stub
		//Create sql statement
		String sql = "INSERT INTO users(first_name,last_name,phone_number, email, username, passowrd) VALUES (?,?,?, ?, ?, ?)";
		try {
			int rows = jdbcTemplateObject.update(sql, 
										t.getFirstName(),
										t.getLastName(),
										t.getPhoneNumber(),
                                        t.getEmail(),
                                        t.getUsername(),
                                        t.getPassword()
                                        );





		return rows == 1 ? true : false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(RegisterModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(RegisterModel t) {
		// TODO Auto-generated method stub
		return false;
	}


    @Override
    public List<RegisterModel> findAll() {
        String sql = "SELECT * FROM users";
        List<RegisterModel> users = new ArrayList<RegisterModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next()) {
                users.add(new RegisterModel(
                                            srs.getInt("ID"),
                                            srs.getString("first_name"), 
                                            srs.getString("last_name"),
						                    srs.getString("phone_number"),
                                             srs.getString("email"),
						                    srs.getString("username"),
                                             srs.getString("password")));
			}
           
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        return users;
    }}



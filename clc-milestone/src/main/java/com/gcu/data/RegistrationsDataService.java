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
public class RegistrationsDataService implements DataAccessInterface<RegisterModel> {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    // Constructor to initialize data source and JDBC template
    public RegistrationsDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    // Find a user by their ID (Not yet implemented)
    @Override
    public RegisterModel findByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    // Create a new user registration
    @Override
    public boolean create(RegisterModel t) {
        // Create SQL statement for user registration
        String sql = "INSERT INTO users(first_name, last_name, phone_number, email, username, password) VALUES (?,?,?,?,?,?)";
        try {
            // Execute the SQL statement and insert user data
            int rows = jdbcTemplateObject.update(sql, 
                    t.getFirstName(),
                    t.getLastName(),
                    t.getPhoneNumber(),
                    t.getEmail(),
                    t.getUsername(),
                    t.getPassword()
            );
            // Log the user's first name and return true if the operation was successful
            System.out.println(t.getFirstName());
            return rows == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return false if there was an error during user registration
        return false;
    }

    // Update user information (Not yet implemented)
    @Override
    public boolean update(RegisterModel t) {
        // TODO Auto-generated method stub
        return false;
    }

    // Delete user (Not yet implemented)
    @Override
    public boolean delete(RegisterModel t) {
        // TODO Auto-generated method stub
        return false;
    }

    // Retrieve a list of all registered users
    @Override
    public List<RegisterModel> findAll() {
        String sql = "SELECT * FROM users";
        List<RegisterModel> users = new ArrayList<RegisterModel>();
        try {
            // Execute the SQL query and retrieve a result set
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                // Create RegisterModel objects and add them to the users list
                users.add(new RegisterModel(
                    srs.getInt("ID"),
                    srs.getString("first_name"), 
                    srs.getString("last_name"),
                    srs.getString("phone_number"),
                    srs.getString("email"),
                    srs.getString("username"),
                    srs.getString("password")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return the list of registered users
        return users;
    }
}

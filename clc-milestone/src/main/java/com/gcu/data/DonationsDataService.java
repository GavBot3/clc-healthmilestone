package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.DonationsModel;

@Service
public class DonationsDataService implements DataAccessInterface<DonationsModel> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    // Constructor to initialize data source and JDBC template
    public DonationsDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    // Retrieve a list of all donations
    @Override
    public List<DonationsModel> findAll() {
        String sql = "SELECT * FROM donations";
        List<DonationsModel> donations = new ArrayList<DonationsModel>();
        try {
            // Execute the SQL query and retrieve a result set
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                // Create DonationsModel objects and add them to the donations list
                donations.add(new DonationsModel(
                    srs.getInt("ID"),
                    srs.getString("organ"),
                    srs.getString("donation_date"),
                    srs.getInt("user_ID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return the list of donations
        return donations;
    }

    // Find a donation by its ID (Not yet implemented)
    @Override
    public DonationsModel findByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    // Create a new donation
    @Override
    public boolean create(DonationsModel t) {
        // Create SQL statement for donation
        String sql = "INSERT INTO donations(organ, donation_date, user_ID) VALUES (?,?,?)";
        try {
            // Execute the SQL statement and insert donation data
            int rows = jdbcTemplateObject.update(sql,
                    t.getOrgan(),
                    t.getDonation_date(),
                    t.getUser_ID());
            return rows == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return false if there was an error during donation creation
        return false;
    }

    // Update donation information (Not yet implemented)
    @Override
    public boolean update(DonationsModel t) {
        // TODO Auto-generated method stub
    	String sql = "UPDATE `donations` SET `ID`=?,`organ`= ?,`donation_date`= ?,`user_ID`= ? WHERE 1";
    	try {
    		int rows = jdbcTemplateObject.update(sql, t.getID(), t.getOrgan(), t.getDonation_date(), t.getUser_ID());
    		System.out.println(rows);
    		return rows == 1 ? true : false;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return false;
    }

    // Delete a donation 
    @Override
    public boolean delete(DonationsModel t) {
        // TODO Auto-generated method stub
    	String sql = "DELETE FROM donations WHERE ID = ?";
    	try {
    		int rows = jdbcTemplateObject.update(sql, t.getID());
    		System.out.println(rows);
    		return rows == 1 ? true : false;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return false;
    }
}

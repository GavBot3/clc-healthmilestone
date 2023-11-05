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
public class DonationsDataService implements DataAccessInterface<DonationsModel>{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	
	public DonationsDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}


	@Override
	public List<DonationsModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM DONATIONS";
		List<DonationsModel> donations = new ArrayList<DonationsModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next()) {
				donations.add(new DonationsModel(srs.getInt("ID"),
						srs.getString("organ"), srs.getString("donation_date"),
						srs.getInt("user_ID")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return donations;
	}

	@Override
	public DonationsModel findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(DonationsModel t) {
		// TODO Auto-generated method stub
		//Create sql statement
		String sql = "INSERT INTO donations(organ, donation_date, user_ID) VALUES (?,?,?)";
		try {
			int rows = jdbcTemplateObject.update(sql, 
										t.getOrgan(),
										t.getDonation_date(),
										t.getuser_ID());
		return rows == 1 ? true : false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(DonationsModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DonationsModel t) {
		// TODO Auto-generated method stub
		return false;
	}

}

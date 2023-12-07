package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.MedicineModel;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@Service
public class MedicineDataService<T> implements DataAccessInterface<MedicineModel> {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    // Constructor to initialize data source and JDBC template
    public MedicineDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    // Retrieve a list of all medicines
    @Override
    public List<MedicineModel> findAll() {
        List<MedicineModel> medicines = new ArrayList<MedicineModel>();
        String sql = "SELECT * FROM medicines";

        try {
            // Execute the SQL query and retrieve a result set
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                // Create MedicineModel objects and add them to the medicines list
                medicines.add(new MedicineModel(
                    srs.getLong("ID"),
                    srs.getString("name"),
                    srs.getString("type"),
                    srs.getString("strength"),
                    srs.getInt("quantity"),
                    srs.getInt("num_servings")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return medicines;
    }

    @Override
    public List<MedicineModel> findByID(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    // Create a new medicine
    @Override
    public boolean create(MedicineModel medicine) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO medicines(name, type, strength, quantity, num_servings) VALUES(?,?,?,?,?)";
        try {
            // Execute the SQL statement and insert medicine data
            int rows = jdbcTemplateObject.update(sql, 
            medicine.getName(), 
            medicine.getType(), 
            medicine.getStrength(), 
            medicine.getQuantity(), 
            medicine.getNumServings());
            return rows == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return false if there was an error during medicine creation
        return false;
    }

    // Update medicine information (Not yet implemented)
    @Override
    public boolean update(MedicineModel t) {
        // TODO Auto-generated method stub
        return true;
    }

    // Delete a medicine (Not yet implemented)
    @Override
    public boolean delete(MedicineModel t) {
        // TODO Auto-generated method stub
        return true;
    }
}

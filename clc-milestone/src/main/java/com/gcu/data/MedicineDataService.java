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
public class MedicineDataService<T> implements DataAccessInterface<MedicineModel>{

    @Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

    public MedicineDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
    @Override
    public List<MedicineModel> findAll()
    {
        List<MedicineModel> medicines = new ArrayList<MedicineModel>();
        String sql = "SELECT * FROM ORDERS";

		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next()) {
				medicines.add(new MedicineModel(srs.getLong("ID"), srs.getString("name"),
						srs.getString("type"), srs.getString("strength"),
						srs.getInt("QUANTITY"), srs.getInt("num_servings")));
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}

        return medicines;
    }


    
	@Override
	public MedicineModel findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(MedicineModel medicine) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO medicines(name, type, strength, quantity, num_servings) VALUES(?,?,?)";
		try {
			int rows = jdbcTemplateObject.update(sql, medicine.getName(),medicine.getType(),medicine.getStrength(),medicine.getQuantity(), medicine.getNumServings());
			return rows == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(MedicineModel t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(MedicineModel t) {
		// TODO Auto-generated method stub
		return true;
	}
}
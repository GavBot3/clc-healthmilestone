package com.gcu.data;

import java.util.List;

import com.gcu.model.DonationsModel;
import com.gcu.model.MedicineModel;
import com.gcu.model.RegisterModel;

/**
 * This is the data access interafcawefaapsehfdskjfljnsddsflkjdsfg
 */
public interface DataAccessInterface <T> {
	public List<T> findAll();
	public List<T> findByID(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}

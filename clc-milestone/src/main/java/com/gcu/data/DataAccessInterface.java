package com.gcu.data;

import java.util.List;

/**
 * This is the data access interafcawefaapsehfdskjfljnsddsflkjdsfg
 */
public interface DataAccessInterface <T> {
	public List<T> findAll();
	public T findByID(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
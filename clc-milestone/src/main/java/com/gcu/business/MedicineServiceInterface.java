package com.gcu.business;
import java.util.List;


import com.gcu.model.MedicineModel;

public interface MedicineServiceInterface{

	public void init();
	public void destroy();
    public List<MedicineModel> getMedicines();
}
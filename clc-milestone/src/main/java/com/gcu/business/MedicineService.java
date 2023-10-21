package com.gcu.business;
import java.util.ArrayList;
import java.util.List;

import com.gcu.model.MedicineModel;



public class MedicineService implements MedicineServiceInterface{

    @Override
    public List<MedicineModel> getMedicines()
    {
        List<MedicineModel> medicines = new ArrayList<MedicineModel>();
        medicines.add(new MedicineModel("Ibuprophen", "NSAID", "600mg", 100, 50));
        medicines.add(new MedicineModel("Percocet", "Acetaminophen", "10mg", 20, 20));
        medicines.add(new MedicineModel("Adderall", "Dextroamphetamine-amphetamine", "20g", 60, 30));
        medicines.add(new MedicineModel("Peneciline", "Antibiotic", "250mg", 90, 45));
        return medicines;
    }

}
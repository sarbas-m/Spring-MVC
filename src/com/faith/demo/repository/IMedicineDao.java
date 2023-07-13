package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicineCompany;



public interface IMedicineDao {
	
	//list
		public List<Medicine> getMedicine();
		
		//insert /update
		public void saveMedicine(Medicine theMedicine);
		
		//Search by id
		public Medicine searchById(int id);
		
		public Medicine getmedicine(int theId);
		
		//delete
		public void deleteMedicine (Medicine theMedicine);
		
		//Search by name
		public List<Medicine> searchByName(String sName);
		
		
		public Medicine searchMedicine(int medicineId);
		
		public void disableMedicine(Medicine theMed);
		
		List<MedicineCompany> medCompanyList();

	

        

}

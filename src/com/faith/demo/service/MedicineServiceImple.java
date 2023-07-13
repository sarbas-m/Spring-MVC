package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicineCompany;
import com.faith.demo.repository.IMedicineDao;

@Service
public class MedicineServiceImple implements IMedicineService {
	
	@Autowired
	private IMedicineDao medicineDao;

	
	public List<Medicine> getMedicine() {
		return medicineDao.getMedicine();
	}

	

	public Medicine searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public List<Medicine> searchByName(String sName) {
		return medicineDao.searchByName(sName);
	}



	@Override
	public void saveMedicine(Medicine theMedicine) {
		
		medicineDao.saveMedicine(theMedicine);
		
	}
	
	



	@Override
	public void deleteMedicine(Medicine theMedicine) {
		medicineDao.deleteMedicine(theMedicine);

		
	}



	@Override
	public Medicine getmedicine(int theId) {
		return medicineDao.getmedicine(theId);
	}



	/*
	 * public Medicine searchMedicine(int medicineId) {
	 * 
	 * return medicineDao.searchMedicine(medicineId); }
	 */


	public void disableMedicine(Medicine theMed) {
		theMed.setMedicineIsActive("false");
		medicineDao.disableMedicine(theMed);
		
	}



	public Medicine searchMedicine(int medicineId) {
		return medicineDao.getmedicine(medicineId);
	}



	@Override
	public List<MedicineCompany> medCompanyList() {
		// TODO Auto-generated method stub
		return null;
	}



	/*
	 * @Override public List<MedicineCompany> medCompanyList() { // TODO
	 * Auto-generated method stub return medicineDao.medCompanyList(); }
	 */





}

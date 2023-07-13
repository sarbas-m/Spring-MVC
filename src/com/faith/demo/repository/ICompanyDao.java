package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicineCompany;


public interface ICompanyDao {
	
	//insert 
    public void saveCompany(MedicineCompany theMedicine);
    
    public List<MedicineCompany> getCompany();

}

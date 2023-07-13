package com.faith.demo.service;

import java.util.List;

import com.faith.demo.entity.MedicineCompany;

public interface ICompanyService {
	
	//insert 
    public void saveCompany(MedicineCompany theComp);

    public List<MedicineCompany> getCompany();
}

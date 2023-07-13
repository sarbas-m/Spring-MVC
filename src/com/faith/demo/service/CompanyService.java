package com.faith.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.MedicineCompany;
import com.faith.demo.repository.ICompanyDao;


@Service
public class CompanyService implements ICompanyService {
	
	
	@Autowired
	private ICompanyDao Dao;



	@Override
	public void saveCompany(MedicineCompany theComp) {
		Dao.saveCompany(theComp);
		
	}



	public List<MedicineCompany> getCompany() {
		return Dao.getCompany();
	}

}

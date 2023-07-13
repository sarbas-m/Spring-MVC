package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.example.MedPres;
import com.faith.demo.example.ViewPatientForOp;
import com.faith.demo.repository.IMedicineDao;
import com.faith.demo.repository.IPrescription;


@Service
public class PrescriptonServiceImple implements IPrescriptonService {
	
	
	@Autowired
	private IPrescription presDao;


	@Override
	public List<MedPres> medPresImp() {
		return presDao.medPresImp();
	}


	public List<ViewPatientForOp> detailsOfEachOp(int appointId) {
		return presDao.detailsOfEachOp(appointId);
	}


	@Override
	public void removePv(int apId) {
		presDao.removePv(apId);
		
	}

}

package com.faith.demo.service;

import java.util.List;

import com.faith.demo.example.MedPres;
import com.faith.demo.example.ViewPatientForOp;

public interface IPrescriptonService {
	
	public List<MedPres> medPresImp();
	
	public List<ViewPatientForOp> detailsOfEachOp(int appointId);

	public void removePv(int apId);
}

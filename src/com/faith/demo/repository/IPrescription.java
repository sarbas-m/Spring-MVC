package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.example.MedPres;
import com.faith.demo.example.ViewPatientForOp;

public interface IPrescription {
	
	public List<MedPres> medPresImp();
	
	public List<ViewPatientForOp> detailsOfEachOp(int appointId);
	
	public void removePv(int apId);
}

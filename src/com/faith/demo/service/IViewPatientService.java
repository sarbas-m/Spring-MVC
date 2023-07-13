package com.faith.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.faith.demo.entity.TestReport;
import com.faith.demo.example.ViewPatientForTest;



public interface IViewPatientService {
	
	public List<ViewPatientForTest> patientForTest();
	
	public List<ViewPatientForTest> detailsOfEachTest(int appointId);
	
	public List<ViewPatientForTest>tsetDetailWithPrescription(int preId);
	
	public void saveActual(TestReport tes);
	
	public TestReport editingResult(int pId);

}

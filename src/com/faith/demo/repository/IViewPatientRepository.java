package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.entity.TestReport;
import com.faith.demo.example.ViewPatientForTest;



public interface IViewPatientRepository {
	
	public List<ViewPatientForTest> patientForTest();
	
	public List<ViewPatientForTest> detailsOfEachTest(int appointId);

	public List<ViewPatientForTest>tsetDetailWithPrescription(int preId);

	public void saveActual(TestReport tes);

	public TestReport editingResult(int pId);


}

package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.TestReport;
import com.faith.demo.example.ViewPatientForTest;
import com.faith.demo.repository.IViewPatientRepository;

@Service
public class ViewPatientServiceImplementation implements IViewPatientService{
	
	@Autowired
	IViewPatientRepository viewpatientrepo;

	@Override
	public List<ViewPatientForTest> patientForTest() {
		// TODO Auto-generated method stub
		return viewpatientrepo.patientForTest();
	}

	@Override
	public List<ViewPatientForTest> detailsOfEachTest(int appointId) {
		// TODO Auto-generated method stub
		return viewpatientrepo.detailsOfEachTest(appointId);
	}

	@Override
	public List<ViewPatientForTest> tsetDetailWithPrescription(int preId) {
		// TODO Auto-generated method stub
		return viewpatientrepo.tsetDetailWithPrescription(preId);
	}

	@Override
	public void saveActual(TestReport tes) {
		// TODO Auto-generated method stub
		viewpatientrepo.saveActual(tes);
		
	}

	@Override
	public TestReport editingResult(int pId) {
		// TODO Auto-generated method stub
		return viewpatientrepo.editingResult(pId);
	}
	

}

package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Patient;
import com.faith.demo.repository.IPatientDao;
@Service
public class PatientImplementationService implements IPatientService {
	@Autowired
	private IPatientDao patientDao;

	@Override
	public void savePatient(Patient thePatient) {
	       patientDao.savePatient(thePatient);
		
	}

	@Override
	public List<Patient> getPatient() {
		// TODO Auto-generated method stub
		return patientDao.getPatient();
	}

	@Override
	public Patient getPatient(int patientId) {
		return patientDao.getPatient(patientId);	
	}

@Override
	public void disablePatient(Patient thePatient) {
	
    thePatient.setPatientIsActive("false");
    patientDao.disablePatient(thePatient);
	}

	/*@Override
	public Patient updatePatient(Patient thePatient) {
		// TODO Auto-generated method stub
		return patientDao.updatePatient(thePatient);
	}*/

	@Override
	public Patient searchPatient(int patientId) {
		// TODO Auto-generated method stub
		return patientDao.searchPatient(patientId);
	}

	@Override
	public List<Doctor> getDoctorList() {
		// TODO Auto-generated method stub
		return patientDao.getDoctorList();
	}

}

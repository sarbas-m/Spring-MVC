package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Patient;

public interface IPatientDao {

	public void savePatient(Patient thePatient);

	public List<Patient> getPatient();
	
	public Patient getPatient(int patientId);
	public Patient searchPatient(int patientId);


    //delete 

	//public void disablePatient(int PatientId, Patient thePatient);
	public void  disablePatient(Patient thePatient);
	
	public List<Doctor> getDoctorList();
}

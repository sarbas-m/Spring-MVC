package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Patient;
import com.faith.demo.entity.Test;
import com.faith.demo.entity.TestPrescription;

public class ViewPatientForTest {
	
	private TestPrescription testprescription;
	private Appointment appointment;
	private Test test;
	private Patient patient;
	private Doctor doctor;
	
	public ViewPatientForTest() {
		
	}

	




	public ViewPatientForTest(TestPrescription testprescription, Appointment appointment, Test test, Patient patient,
			Doctor doctor) {
		super();
		this.testprescription = testprescription;
		this.appointment = appointment;
		this.test = test;
		this.patient = patient;
		this.doctor = doctor;
	}






	public TestPrescription getTestprescription() {
		return testprescription;
	}






	public void setTestprescription(TestPrescription testprescription) {
		this.testprescription = testprescription;
	}






	public Appointment getAppointment() {
		return appointment;
	}






	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}






	public Test getTest() {
		return test;
	}






	public void setTest(Test test) {
		this.test = test;
	}






	public Patient getPatient() {
		return patient;
	}






	public void setPatient(Patient patient) {
		this.patient = patient;
	}






	public Doctor getDoctor() {
		return doctor;
	}






	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}






	@Override
	public String toString() {
		return "ViewPatientForTest [testprescription=" + testprescription + ", appointment=" + appointment + ", test="
				+ test + ", patient=" + patient + ", doctor=" + doctor + "]";
	}






	


	

}

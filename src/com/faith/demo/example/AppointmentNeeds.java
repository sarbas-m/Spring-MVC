package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Patient;
import com.faith.demo.entity.TestPrescription;

public class AppointmentNeeds {
	
	Appointment appointment;
	TestPrescription testprescription;
	Patient patient;
	Doctor doctor;
	
	public AppointmentNeeds() {
		
	}

	public AppointmentNeeds(Appointment appointment, TestPrescription testprescription, Patient patient,
			Doctor doctor) {
		super();
		this.appointment = appointment;
		this.testprescription = testprescription;
		this.patient = patient;
		this.doctor = doctor;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public TestPrescription getTestprescription() {
		return testprescription;
	}

	public void setTestprescription(TestPrescription testprescription) {
		this.testprescription = testprescription;
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
		return "AppointmentNeeds [appointment=" + appointment + ", testprescription=" + testprescription + ", patient="
				+ patient + ", doctor=" + doctor + "]";
	}
	
	

}

package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.TestPrescription;

public class TestPresHistory {
	
    private Appointment appointment;
    private Doctor doctor;
    private TestPrescription testPrescription;
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public TestPresHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestPrescription getTestPrescription() {
		return testPrescription;
	}
	public void setTestPrescription(TestPrescription testPrescription) {
		this.testPrescription = testPrescription;
	}
	public TestPresHistory(Appointment appointment, Doctor doctor, TestPrescription testPrescription) {
		super();
		this.appointment = appointment;
		this.doctor = doctor;
		this.testPrescription = testPrescription;
	}


    
    
	
	

}

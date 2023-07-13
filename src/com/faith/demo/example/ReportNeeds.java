package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Patient;
import com.faith.demo.entity.Test;
import com.faith.demo.entity.TestPrescription;
import com.faith.demo.entity.TestReport;

public class ReportNeeds {
	
	TestReport testreport;
	TestPrescription testprescription;
	Appointment appointment;
	Test test;
	Patient patient;
	Doctor doctor;
	
	public ReportNeeds() {
		
	}

	@Override
	public String toString() {
		return "ReportNeeds [testreport=" + testreport + ", testprescription=" + testprescription + ", appointment="
				+ appointment + ", test=" + test + ", patient=" + patient + ", doctor=" + doctor + "]";
	}

	public TestReport getTestreport() {
		return testreport;
	}

	public void setTestreport(TestReport testreport) {
		this.testreport = testreport;
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

	public ReportNeeds(TestReport testreport, TestPrescription testprescription, Appointment appointment, Test test,
			Patient patient, Doctor doctor) {
		super();
		this.testreport = testreport;
		this.testprescription = testprescription;
		this.appointment = appointment;
		this.test = test;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	

}

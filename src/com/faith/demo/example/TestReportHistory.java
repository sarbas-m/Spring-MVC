package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.TestPrescription;
import com.faith.demo.entity.TestReport;

public class TestReportHistory {
	
    private Appointment appointment;
    private Doctor doctor;
    private TestPrescription testPrescription;
    private TestReport testReport;
    

	public TestReportHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public TestReport getTestReport() {
		return testReport;
	}
	public void setTestReport(TestReport testReport) {
		this.testReport = testReport;
	}
	public TestPrescription getTestPrescription() {
		return testPrescription;
	}
	public void setTestPrescription(TestPrescription testPrescription) {
		this.testPrescription = testPrescription;
	}
	public TestReportHistory(Appointment appointment, Doctor doctor, TestPrescription testPrescription,
			TestReport testReport) {
		super();
		this.appointment = appointment;
		this.doctor = doctor;
		this.testPrescription = testPrescription;
		this.testReport = testReport;
	}
    
    

}

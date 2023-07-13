package com.faith.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class TestPrescription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testPrescriptionId;
	private LocalDate testPresCreatedOn;
	private String testPresIsActive;
	
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(testPresCreatedOn==null) { //we set default value in case if the value is not set yet
			testPresCreatedOn=LocalDate.now();
		}
		if(testPresIsActive==null) {
			testPresIsActive="true";
		}
		
		}
	
	@ManyToOne
	@JoinColumn(name="appointmentId")
	private Appointment appointment;
	
	@ManyToOne
	@JoinColumn(name="testId")
	private Test test;
	
	@OneToOne(mappedBy="testPrescription")
	private TestReport testReport;

	public int getTestPrescriptionId() {
		return testPrescriptionId;
	}

	public void setTestPrescriptionId(int testPrescriptionId) {
		this.testPrescriptionId = testPrescriptionId;
	}

	public LocalDate getTestPresCreatedOn() {
		return testPresCreatedOn;
	}

	public void setTestPresCreatedOn(LocalDate testPresCreatedOn) {
		this.testPresCreatedOn = testPresCreatedOn;
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

	public TestReport getTestReport() {
		return testReport;
	}

	public void setTestReport(TestReport testReport) {
		this.testReport = testReport;
	}

	/*@Override
	public String toString() {
		return "TestPrescription [testPrescriptionId=" + testPrescriptionId + ", testPresCreatedOn=" + testPresCreatedOn
				+ ", appointment=" + appointment + ", test=" + test + ", testReport=" + testReport + "]";
	}*/

	public TestPrescription(Appointment appointment) {
		super();
		this.appointment = appointment;
	}

	public TestPrescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

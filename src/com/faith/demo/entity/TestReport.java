package com.faith.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class TestReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testReportId;
	private int testActualValue;
	private LocalDate reportCreatedOn;
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(reportCreatedOn==null) {
			reportCreatedOn=LocalDate.now();
		}
	}
	
	@OneToOne
	@JoinColumn(name="testPrescriptionId")
	private TestPrescription testPrescription;
	
	public TestReport() {
		
	}

	public int getTestReportId() {
		return testReportId;
	}

	public void setTestReportId(int testReportId) {
		this.testReportId = testReportId;
	}

	public int getTestActualValue() {
		return testActualValue;
	}

	public void setTestActualValue(int testActualValue) {
		this.testActualValue = testActualValue;
	}

	public LocalDate getReportCreatedOn() {
		return reportCreatedOn;
	}

	public void setReportCreatedOn(LocalDate reportCreatedOn) {
		this.reportCreatedOn = reportCreatedOn;
	}

	public TestPrescription getTestPrescription() {
		return testPrescription;
	}

	public void setTestPrescription(TestPrescription testPrescription) {
		this.testPrescription = testPrescription;
	}

	@Override
	public String toString() {
		return "TestReport [testReportId=" + testReportId + ", testActualValue=" + testActualValue
				+ ", reportCreatedOn=" + reportCreatedOn + ", testPrescription=" + testPrescription + "]";
	}
	
	

}



package com.faith.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Test {
	
	//primary key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testId;
	private String testNumber;
	private String testName;
	private int lowRange;
	private int highRange;
	private String Unit;
	private int testPrice;
	private String isActive;
	private LocalDate testCreatedOn;
	
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(isActive==null) { //we set default value in case if the value is not set yet
			isActive="true";
		}
		if(testCreatedOn==null) {
			testCreatedOn=LocalDate.now();
		}
		}
	
	@OneToMany(mappedBy="test")
	List<TestPrescription>testPrescription;
	
	
	
	
	public List<TestPrescription> getTestPrescription() {
		return testPrescription;
	}

	public void setTestPrescription(List<TestPrescription> testPrescription) {
		this.testPrescription = testPrescription;
	}

	//public constructor
	public Test() {
		
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(String testNumber) {
		this.testNumber = testNumber;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getLowRange() {
		return lowRange;
	}

	public void setLowRange(int lowRange) {
		this.lowRange = lowRange;
	}

	public int getHighRange() {
		return highRange;
	}

	public void setHighRange(int highRange) {
		this.highRange = highRange;
	}

	
	

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public int getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(int testPrice) {
		this.testPrice = testPrice;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	
	public LocalDate getTestCreatedOn() {
		return testCreatedOn;
	}

	public void setTestCreatedOn(LocalDate testCreatedOn) {
		this.testCreatedOn = testCreatedOn;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testNumber=" + testNumber + ", testName=" + testName + ", lowRange="
				+ lowRange + ", highRange=" + highRange + ", Unit=" + Unit + ", testPrice=" + testPrice + ", isActive="
				+ isActive + ", testCreatedOn=" + testCreatedOn + ", testPrescription=" + testPrescription + "]";
	}

	
	
	
	

	

	
	
	

}

package com.faith.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class TestBill {
	
	public String getTestbillNumber() {
		return testbillNumber;
	}

	public void setTestbillNumber(String testbillNumber) {
		this.testbillNumber = testbillNumber;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testBillId;
	private String testbillNumber;
	private int testBillAmount;
	
	private LocalDate testBillCreatedOn;
	private String testBillIsActive;
	@PrePersist
	@PreUpdate
	private void prePersist() {
		if(testBillIsActive==null) {
			testBillIsActive="true";
		}
	if(testBillCreatedOn==null) {
		testBillCreatedOn=LocalDate.now();
	}
}
	
	

	@ManyToOne
	@JoinColumn(name="appointmentId")
	private Appointment appointment;
	
	public int getTestBillId() {
		return testBillId;
	}

	public void setTestBillId(int testBillId) {
		this.testBillId = testBillId;
	}

	public int getTestBillAmount() {
		return testBillAmount;
	}

	public void setTestBillAmount(int testBillAmount) {
		this.testBillAmount = testBillAmount;
	}

	public LocalDate getTestBillCreatedOn() {
		return testBillCreatedOn;
	}

	public void setTestBillCreatedOn(LocalDate testBillCreatedOn) {
		this.testBillCreatedOn = testBillCreatedOn;
	}

	public String getTestBillIsActive() {
		return testBillIsActive;
	}

	public void setTestBillIsActive(String testBillIsActive) {
		this.testBillIsActive = testBillIsActive;
	}

	

}



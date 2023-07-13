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
public class PatientBill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int patientBillId;
	private int patientBillAmount;
	private LocalDate patientbillCreatedOn;
	private String patientBillIsActive;
	
	@PrePersist
	@PreUpdate	
	private void persist() {
		if(patientBillIsActive==null)
			patientBillIsActive="true";
	}
	
	@ManyToOne
	@JoinColumn(name="appointmentId")
	private Appointment appointment;
	
	
	public int getPatientBillId() {
		return patientBillId;
	}

	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
	}

	public int getPatientBillAmount() {
		return patientBillAmount;
	}

	public void setPatientBillAmount(int patientBillAmount) {
		this.patientBillAmount = patientBillAmount;
	}

	public LocalDate getPatientbillCreatedOn() {
		return patientbillCreatedOn;
	}

	public void setPatientbillCreatedOn(LocalDate patientbillCreatedOn) {
		this.patientbillCreatedOn = patientbillCreatedOn;
	}

	public String getPatientBillIsActive() {
		return patientBillIsActive;
	}

	public void setPatientBillIsActive(String patientBillIsActive) {
		this.patientBillIsActive = patientBillIsActive;
	}

	@Override
	public String toString() {
		return "PatientBill [patientBillId=" + patientBillId + ", patientBillAmount=" + patientBillAmount
				+ ", patientbillCreatedOn=" + patientbillCreatedOn + ", patientBillIsActive=" + patientBillIsActive
				+ ", appointment=" + appointment + "]";
	}

	public PatientBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}




}
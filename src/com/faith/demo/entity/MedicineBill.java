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
public class MedicineBill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int medicineBillId;
	private double medicineBillAmount;
	private LocalDate medBillCreatedOn;
	private String medBillIsActive;
	@PrePersist
	@PreUpdate
	private void persist() {
		if(medBillIsActive==null)
			medBillIsActive="yes";
	}
	
	
	@ManyToOne
	@JoinColumn(name="appointmentId")
	private Appointment appointment;
	
	public int getMedicineBillId() {
		return medicineBillId;
	}

	public void setMedicineBillId(int medicineBillId) {
		this.medicineBillId = medicineBillId;
	}

	public double getMedicineBillAmount() {
		return medicineBillAmount;
	}

	public void setMedicineBillAmount(double medicineBillAmount) {
		this.medicineBillAmount = medicineBillAmount;
	}

	public LocalDate getMedBillCreatedOn() {
		return medBillCreatedOn;
	}

	public void setMedBillCreatedOn(LocalDate medBillCreatedOn) {
		this.medBillCreatedOn = medBillCreatedOn;
	}

	public String getMedBillIsActive() {
		return medBillIsActive;
	}

	public void setMedBillIsActive(String medBillIsActive) {
		this.medBillIsActive = medBillIsActive;
	}



}

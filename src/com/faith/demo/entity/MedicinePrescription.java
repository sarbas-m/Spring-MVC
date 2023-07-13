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
public class MedicinePrescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicinePrescriptionId;
	private int days;
	private LocalDate medPresCreatedOn;
	private String medPresIsActive;

	@PrePersist
	@PreUpdate
	public void prepersist() {
		if (medPresIsActive == null)
			medPresIsActive = "yes";
		if(medPresCreatedOn==null) { //we set default value in case if the value is not set yet
			medPresCreatedOn=LocalDate.now();
		}
	}

	@ManyToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;

	@ManyToOne
	@JoinColumn(name = "dosageId")
	private Dosage dosage;

	@ManyToOne
	@JoinColumn(name = "medicineId")
	private Medicine medicine;

	public int getMedicinePrescriptionId() {
		return medicinePrescriptionId;
	}

	public void setMedicinePrescriptionId(int medicinePrescriptionId) {
		this.medicinePrescriptionId = medicinePrescriptionId;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public LocalDate getMedPresCreatedOn() {
		return medPresCreatedOn;
	}

	public void setMedPresCreatedOn(LocalDate medPresCreatedOn) {
		this.medPresCreatedOn = medPresCreatedOn;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public MedicinePrescription(Appointment appointment) {
		super();
		this.appointment = appointment;
	}

	public MedicinePrescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dosage getDosage() {
		return dosage;
	}

	public String getMedPresIsActive() {
		return medPresIsActive;
	}

	public void setMedPresIsActive(String medPresIsActive) {
		this.medPresIsActive = medPresIsActive;
	}

	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
	}

	@Override
	public String toString() {
		return "MedicinePrescription [medicinePrescriptionId=" + medicinePrescriptionId + ", days=" + days
				+ ", medPresCreatedOn=" + medPresCreatedOn + ", appointment=" + appointment + ", dosage=" + dosage
				+ ", medicine=" + medicine + "]";
	}

}
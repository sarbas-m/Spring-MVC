package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Dosage;
import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicinePrescription;
import com.faith.demo.entity.Patient;

public class MedPres {
   
	private Patient patient;
	private MedicinePrescription medicineprescription;
	private Doctor doctor;
	private Medicine medicine;
	private Dosage dosage;
	private Appointment appointment;
	
	
	public MedPres() {
		super();
		// TODO Auto-generated constructor stub
	}




	public MedPres(Patient patient, MedicinePrescription medicineprescription, Doctor doctor, Medicine medicine,
			Dosage dosage, Appointment appointment) {
		super();
		this.patient = patient;
		this.medicineprescription = medicineprescription;
		this.doctor = doctor;
		this.medicine = medicine;
		this.dosage = dosage;
		this.appointment = appointment;
	}




	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public MedicinePrescription getMedicineprescription() {
		return medicineprescription;
	}


	public void setMedicineprescription(MedicinePrescription medicineprescription) {
		this.medicineprescription = medicineprescription;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public Medicine getMedicine() {
		return medicine;
	}


	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}


	public Dosage getDosage() {
		return dosage;
	}


	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
	}


	@Override
	public String toString() {
		return "MedPres [patient=" + patient + ", medicineprescription=" + medicineprescription + ", doctor=" + doctor
				+ ", medicine=" + medicine + ", dosage=" + dosage + "]";
	}




	public Appointment getAppointment() {
		return appointment;
	}




	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	
	
}

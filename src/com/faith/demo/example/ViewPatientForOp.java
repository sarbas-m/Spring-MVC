package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Dosage;
import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicinePrescription;
import com.faith.demo.entity.Patient;


public class ViewPatientForOp {
	
		
		private MedicinePrescription medicineprescription;
		private Appointment appointment;
		private Patient patient;
		private Doctor doctor;
		private Medicine medicine;
		private Dosage dosage;
		
		public ViewPatientForOp() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ViewPatientForOp(MedicinePrescription medicineprescription, Appointment appointment, Patient patient,
				Doctor doctor, Medicine medicine, Dosage dosage) {
			super();
			this.medicineprescription = medicineprescription;
			this.appointment = appointment;
			this.patient = patient;
			this.doctor = doctor;
			this.medicine = medicine;
			this.dosage = dosage;
		}

		public MedicinePrescription getMedicineprescription() {
			return medicineprescription;
		}

		public void setMedicineprescription(MedicinePrescription medicineprescription) {
			this.medicineprescription = medicineprescription;
		}

		public Appointment getAppointment() {
			return appointment;
		}

		public void setAppointment(Appointment appointment) {
			this.appointment = appointment;
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
		
		
		
		
		
}

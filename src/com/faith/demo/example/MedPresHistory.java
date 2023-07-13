package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.MedicinePrescription;

public class MedPresHistory {
	
    private Appointment appointment;
    private Doctor doctor;
    private MedicinePrescription medicinePrescription;
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
	public MedicinePrescription getMedicinePrescription() {
		return medicinePrescription;
	}
	public void setMedicinePrescription(MedicinePrescription medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}
	public MedPresHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedPresHistory(Appointment appointment, Doctor doctor, MedicinePrescription medicinePrescription) {
		super();
		this.appointment = appointment;
		this.doctor = doctor;
		this.medicinePrescription = medicinePrescription;
	}

}

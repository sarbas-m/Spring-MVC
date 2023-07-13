package com.faith.demo.example;

import com.faith.demo.entity.Appointment;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.DoctorNote;

public class DoctorNoteHistory {

    private DoctorNote doctorNote;
    private Appointment appointment;
    private Doctor doctor;
    
	public DoctorNote getDoctorNote() {
		return doctorNote;
	}
	public void setDoctorNote(DoctorNote doctorNote) {
		this.doctorNote = doctorNote;
	}
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
	public DoctorNoteHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorNoteHistory(DoctorNote doctorNote, Appointment appointment, Doctor doctor) {
		super();
		this.doctorNote = doctorNote;
		this.appointment = appointment;
		this.doctor = doctor;
	}

    
    
	
}

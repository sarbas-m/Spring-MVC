package com.faith.demo.example;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Diagnos;
import com.faith.demo.entity.Doctor;

public class AppointmentDiagnosDoctorDTO {
    private Diagnos diagnos;
    private Appointment appointment;
    private Doctor doctor;
	public Diagnos getDiagnos() {
		return diagnos;
	}
	public void setDiagnos(Diagnos diagnos) {
		this.diagnos = diagnos;
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
	public AppointmentDiagnosDoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppointmentDiagnosDoctorDTO(Diagnos diagnos, Appointment appointment, Doctor doctor) {
		super();
		this.diagnos = diagnos;
		this.appointment = appointment;
		this.doctor = doctor;
	}

    
}

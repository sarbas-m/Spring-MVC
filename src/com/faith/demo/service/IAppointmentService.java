package com.faith.demo.service;

import java.util.List;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Patient;

public interface IAppointmentService {

	public void saveAppointment(Appointment theAppointment);

	 public List<Appointment> getAppointment();

	public Appointment searchAppointment(int appointmentId);

	public void disableAppointment(Appointment searchAppointment);

	public Appointment getAppointment(int appointmentId);

}

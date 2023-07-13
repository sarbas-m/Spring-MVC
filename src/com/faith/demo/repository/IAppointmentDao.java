package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.entity.Appointment;

public interface IAppointmentDao {

	 public List<Appointment> getAppointment();

	public Appointment getAppointment(int appointmentId);

	public void saveAppointment(Appointment theAppointment);

	public void disableAppointment(Appointment theAppointment);

	 public Appointment searchAppointment(int appointmentId);

}

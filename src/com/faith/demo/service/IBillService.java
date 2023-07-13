package com.faith.demo.service;

import java.util.List;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Patient;
import com.faith.demo.entity.PatientBill;

public interface IBillService {
	
	     public List<PatientBill> getBill();

		public Appointment getBill(int patientBillId);
		
		public List<Appointment> getAppointment(int appointmentId);
		
		public Patient patient(int patientId);

}

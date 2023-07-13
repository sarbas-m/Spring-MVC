package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Patient;
import com.faith.demo.entity.PatientBill;
import com.faith.demo.repository.IBillDao;
@Service
public class BillImplementationService implements IBillService {
	@Autowired
	private IBillDao billDao;
	
	@Override
	public List<PatientBill> getBill() {
		// TODO Auto-generated method stub
		return billDao.getBill();
	}

	@Override
	public Appointment getBill(int patientBillId) {
		// TODO Auto-generated method stub
		return 	billDao.getBill(patientBillId);	
	}

	@Override
	public List<Appointment> getAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		return billDao.getAppointment(appointmentId);
	}

	@Override
	public Patient patient(int patientId) {
		// TODO Auto-generated method stub
		return billDao.patient(patientId);
	}

}

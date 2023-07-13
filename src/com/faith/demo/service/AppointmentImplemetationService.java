package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Patient;
import com.faith.demo.repository.IAppointmentDao;
@Service
public class AppointmentImplemetationService implements IAppointmentService {
	@Autowired
	private IAppointmentDao appointmentDao;

	@Override
	public void saveAppointment(Appointment theAppointment) {
		appointmentDao.saveAppointment(theAppointment);
		
	}

	@Override
	 public List<Appointment> getAppointment() {
		return appointmentDao.getAppointment();
	}

	

	@Override
	public Appointment searchAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		return appointmentDao.searchAppointment(appointmentId);
	}

	@Override
	public void disableAppointment(Appointment theAppointment) {
		// TODO Auto-generated method stub
		theAppointment.setAppointmentIsActive("false");
	    appointmentDao.disableAppointment(theAppointment);
	    }

	@Override
	public Appointment getAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		return 	appointmentDao.getAppointment(appointmentId);	
	}
	


	
	}



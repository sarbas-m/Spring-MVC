package com.faith.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Patient;
import com.faith.demo.entity.PatientBill;

@Repository
public class BillDaoImplementation implements IBillDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PatientBill> getBill() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment getBill(int patientBillId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Appointment> getAppointment(int patientId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Appointment> theQuery = currentSession.createQuery("From Appointment where appointmentIsActive='true' and patientId=:patientId", Appointment.class);
		theQuery.setParameter("patientId", patientId);
		List<Appointment> listApp=theQuery.getResultList();
		
		return listApp;
	}

	@Override
	@Transactional
	public Patient patient(int patientId) {
		Session currentSession = sessionFactory.getCurrentSession();
        Patient patient=currentSession.get(Patient.class, patientId);
		return patient;
	}



}

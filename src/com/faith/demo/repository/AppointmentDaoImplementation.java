package com.faith.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.entity.Appointment;

@Repository
public class AppointmentDaoImplementation implements IAppointmentDao {
		@Autowired
		private SessionFactory sessionFactory;

		@Autowired
		public AppointmentDaoImplementation(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		
		@Override
		@Transactional
		public List<Appointment> getAppointment() {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<Appointment> theQuery = currentSession.createQuery("From Appointment where appointmentIsActive='true'", Appointment.class);
			// execute query and get result set
			List<Appointment> appointment = theQuery.getResultList();
			return appointment;
		}


		@Override
		@Transactional
		public Appointment getAppointment(int appointmentId) {
				Session currentSession = sessionFactory.getCurrentSession();
				Appointment theAppointment=currentSession.get(Appointment.class,appointmentId);
				return theAppointment;
				
		}

		@Override
		@Transactional
		public void saveAppointment(Appointment theAppointment) {
			System.out.println(theAppointment.getAppCreatedOn());
			theAppointment.setAppValidityDate(theAppointment.getAppCreatedOn().plusDays(7));
			System.out.println(theAppointment.getAppValidityDate());
				// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
				// save the patient
			currentSession.saveOrUpdate(theAppointment);//save or update for both insert and update
		    
		}
		
		@Override
		@Transactional
		public void disableAppointment(Appointment theAppointment) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(theAppointment);//save or update for both insert and update
			//int theQuery = currentSession.createNativeQuery("disablePatient",Patient.class).setParameter(1, PatientId).executeUpdate();
			//List<Patient> patient = theQuery.setParameter("id", PatientId).getResultList();
			//return;
			//Query theQuery = currentSession.createQuery("UPDATE Patient set patientIsActive=:false WHERE patientId=id", Patient.class);

		}


	


		@Override
		@Transactional
		public Appointment searchAppointment(int appointmentId) {
				Session currentSession=sessionFactory.getCurrentSession();
				Appointment theQuery=currentSession.get(Appointment.class,appointmentId);
				return theQuery;
				
		}



	}

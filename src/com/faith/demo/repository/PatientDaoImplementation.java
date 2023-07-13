package com.faith.demo.repository;

import java.util.List;
import javax.persistence.SqlResultSetMapping;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Patient;

@Repository
public class PatientDaoImplementation implements IPatientDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public PatientDaoImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	@Transactional
	public List<Patient> getPatient() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Patient> theQuery = currentSession.createQuery("From Patient where patientIsActive='true'", Patient.class);
		// execute query and get result set
		List<Patient> patient = theQuery.getResultList();
		return patient;
	}


	@Override
	@Transactional
	public Patient getPatient(int patientId) {
			Session currentSession = sessionFactory.getCurrentSession();
			Patient thePatient=currentSession.get(Patient.class,patientId);
			return thePatient;
			
	}

	@Override
	@Transactional
	public void savePatient(Patient thePatient) {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			// save the patient
			currentSession.saveOrUpdate(thePatient);//save or update for both insert and update
	    
	}
	
	@Override
	@Transactional
	public void disablePatient(Patient thePatient) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thePatient);//save or update for both insert and update
		//int theQuery = currentSession.createNativeQuery("disablePatient",Patient.class).setParameter(1, PatientId).executeUpdate();
		//List<Patient> patient = theQuery.setParameter("id", PatientId).getResultList();
		//return;
		//Query theQuery = currentSession.createQuery("UPDATE Patient set patientIsActive=:false WHERE patientId=id", Patient.class);

	}


	/*@Override
	@Transactional
	public Patient updatePatient(Patient thePatient) {
		int id=thePatient.getPatientId();
		String number=thePatient.getPatientPhoneNumber();
		String add=thePatient.getPatientAddress();
		Session currentSession = sessionFactory.getCurrentSession();
		//Query<Patient> theQuery = currentSession.createNamedQuery(@SqlResultSetMapping(name="updateResult", columns = { @ColumnResult(name = "count")})
//).createQuery("Update Patient set patientPhoneNumber=:number and patientAddress=:add  where patientId=:id ", Patient.class).setParameter("id", id);
		// execute query and get result set
		
		return null;
	}*/


	@Override
	@Transactional
	public Patient searchPatient(int patientId) {
			Session currentSession=sessionFactory.getCurrentSession();
			Patient theQuery=currentSession.get(Patient.class,patientId);
			
			return theQuery;
			
	}


	@Override
	@Transactional
	public List<Doctor> getDoctorList() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Doctor> theQuery=currentSession.createQuery("from Doctor",Doctor.class);
		List<Doctor> listDoctor=theQuery.getResultList();
		
		return listDoctor;
	}

}
package com.faith.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.faith.demo.entity.Appointment;

import com.faith.demo.entity.Diagnos;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.DoctorNote;
import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicinePrescription;
import com.faith.demo.entity.Test;
import com.faith.demo.entity.TestPrescription;
import com.faith.demo.entity.TestReport;
import com.faith.demo.example.AppointmentDiagnosDoctorDTO;
import com.faith.demo.example.DoctorNoteHistory;
import com.faith.demo.example.MedPresHistory;
import com.faith.demo.example.TestPresHistory;
import com.faith.demo.example.TestReportHistory;

@Repository
public class DoctorDaoImpleNew implements IDoctorDaoNew {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Appointment> listAppointmentTable(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Appointment> theQuery = currentSession.createQuery("from Appointment where date(appCreatedOn) = current_date() and appointmentIsActive='true' and doctor.user.userId=:id",
				Appointment.class);

		List<Appointment> theAppointment = theQuery.setParameter("id", userId).getResultList();
		return theAppointment;
	}

	@Override
	@Transactional
	public Appointment patientDetails(int tokenNo) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Appointment> theQuery = currentSession.createQuery("from Appointment where tokenNo=:name",
				Appointment.class);

		Appointment theAppointment = theQuery.setParameter("name", tokenNo).getSingleResult();

		return theAppointment;
	}

	@Override
	@Transactional
	public void insertDiagnos(Diagnos diagnos) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(diagnos);

	}

	@Override
	@Transactional
	public void insertDoctorNote(DoctorNote doctorNote) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(doctorNote);
	}

	@Override
	@Transactional
	public void insertMedicine(MedicinePrescription medicinePrescription) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(medicinePrescription);

	}

	@Override
	@Transactional
	public void insertTest(TestPrescription testPrescription) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(testPrescription);

	}

	@Override
	@Transactional
	public List<Appointment> searchPatient(String names) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Appointment> theQuery = currentSession.createQuery("from Appointment where patient.patientName=:name",
				Appointment.class);

		List<Appointment> theAppointment = theQuery.setParameter("name", names).getResultList();

		return theAppointment;
	}

	@Override
	@Transactional
	public List<AppointmentDiagnosDoctorDTO> diaHistDto(int patientId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hqlQuery = "SELECT NEW com.faith.demo.example.AppointmentDiagnosDoctorDTO(d, a, doc) "
				+ "FROM Diagnos d " + "JOIN d.appointment a " + "JOIN a.doctor doc where a.patient.patientId=:name";

		Query query = currentSession.createQuery(hqlQuery);
		List<AppointmentDiagnosDoctorDTO> results = query.setParameter("name", patientId).getResultList();

		return results;

	}

	@Override
	@Transactional
	public List<DoctorNoteHistory> doctorNoteDto(int patientId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hqlQuery = "SELECT NEW com.faith.demo.example.DoctorNoteHistory(d, a, doc) " + "FROM DoctorNote d "
				+ "JOIN d.appointment a " + "JOIN a.doctor doc where a.patient.patientId=:name";

		Query query = currentSession.createQuery(hqlQuery);
		List<DoctorNoteHistory> results = query.setParameter("name", patientId).getResultList();

		for (DoctorNoteHistory a : results) {
			System.out.println(a.getDoctorNote().getNote());
		}
		return results;
	}

	@Override
	@Transactional
	public List<MedPresHistory> medPresHistoryDto(int patientId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hqlQuery = "SELECT NEW com.faith.demo.example.MedPresHistory( a, doc,d) "
				+ "FROM MedicinePrescription d " + "JOIN d.appointment a "
				+ "JOIN a.doctor doc where a.patient.patientId=:name";

		Query query = currentSession.createQuery(hqlQuery);
		List<MedPresHistory> results = query.setParameter("name", patientId).getResultList();

		for (MedPresHistory a : results) {
			System.out.println(a.getMedicinePrescription().getMedicine().getMedicineName());
		}
		return results;
	}

	@Override
	@Transactional
	public List<TestPresHistory> testPresHistoryDto(int patientId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hqlQuery = "SELECT NEW com.faith.demo.example.TestPresHistory( a, doc,d) " + "FROM TestPrescription d "
				+ "JOIN d.appointment a " + "JOIN a.doctor doc where a.patient.patientId=:name";

		Query query = currentSession.createQuery(hqlQuery);
		List<TestPresHistory> results = query.setParameter("name", patientId).getResultList();

		return results;
	}

	@Override
	@Transactional
	public List<TestReportHistory> testReportHistoryDto(int patientId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hqlQuery = "SELECT NEW com.faith.demo.example.TestReportHistory( a, doc,t,d) " + "FROM TestReport d "
				+ "JOIN d.testPrescription t " + "JOIN t.appointment a join a.doctor doc where a.patient.patientId=:name";

		Query query = currentSession.createQuery(hqlQuery);
		List<TestReportHistory> results = query.setParameter("name", patientId).getResultList();

		for (TestReportHistory a : results) {
			System.out.println(a.getTestReport().getTestPrescription().getTest().getTestName());
		}
		return results;
	}

	@Override
	@Transactional
	public List<Test> getTestList() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Test> theQuery=currentSession.createQuery("from Test",Test.class);
		List<Test> testList=theQuery.getResultList();
		return testList;
	}

	@Override
	@Transactional
	public List<Medicine> getMedicineList() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Medicine> theQuery=currentSession.createQuery("from Medicine",Medicine.class);
		List<Medicine> testList=theQuery.getResultList();
		return testList;
	}

	@Override
	@Transactional
	public List<Diagnos> getDiagnosList(int appointmentId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Diagnos> theQuery=currentSession.createQuery("from Diagnos where appointment.appointmentId=:id",Diagnos.class);
		List<Diagnos> DiagnosListDoc=theQuery.setParameter("id", appointmentId).getResultList();
		
		return DiagnosListDoc;
	}

	@Override
	@Transactional
	public void deleteDiagnos(int diagnosId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Diagnos dia=currentSession.get(Diagnos.class, diagnosId);
		dia.setDiagnosIsActive("false");
		currentSession.saveOrUpdate(dia);		
	}

	@Override
	@Transactional
	public List<MedicinePrescription> getMedPresList(int appointmentId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<MedicinePrescription> theQuery=currentSession.createQuery("from MedicinePrescription where appointment.appointmentId=:id",MedicinePrescription.class);
		List<MedicinePrescription> medListDoc=theQuery.setParameter("id", appointmentId).getResultList();

		return medListDoc;
	}

	@Override
	@Transactional
	public List<TestPrescription> getTestPresList(int appointmentId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<TestPrescription> theQuery=currentSession.createQuery("from TestPrescription where appointment.appointmentId=:id",TestPrescription.class);
		List<TestPrescription> testListDoc=theQuery.setParameter("id", appointmentId).getResultList();

		return testListDoc;
	}

	@Override
	@Transactional
	public List<DoctorNote> getDocNotPresList(int appointmentId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<DoctorNote> theQuery=currentSession.createQuery("from DoctorNote where appointment.appointmentId=:id",DoctorNote.class);
		
		List<DoctorNote> docNotListDoc=theQuery.setParameter("id", appointmentId).getResultList();
		
		return docNotListDoc;
	}

	@Override
	@Transactional
	public void disableAppointment(Appointment appointment) {
		Session currentSession=sessionFactory.getCurrentSession();
		appointment.setAppointmentIsActive("false");
		currentSession.saveOrUpdate(appointment);		
	}

	@Override
	@Transactional
	public Appointment getAppointment(int appointmentId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Appointment theAppointment=currentSession.get(Appointment.class,appointmentId);
		
		return theAppointment;
	}

	@Override
	@Transactional
	public int getUserIdFromDb(int appointmentId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Appointment theAppointment=currentSession.get(Appointment.class,appointmentId);
		
		int userId=theAppointment.getDoctor().getUser().getUserId();
		
		
		
		return userId;
	}


}

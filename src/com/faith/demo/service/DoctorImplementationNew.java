package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Diagnos;
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

import com.faith.demo.repository.IDoctorDaoNew;

@Service
public class DoctorImplementationNew implements IDoctorServiceNew {
	
	
	@Autowired
	private IDoctorDaoNew doctorDao;

	@Override
	public List<Appointment> listAppointmentTable(int userId) {
		// TODO Auto-generated method stub
		return doctorDao.listAppointmentTable(userId);
	}

	@Override
	public Appointment patientDetails(int tokenNo) {
		// TODO Auto-generated method stub
		return doctorDao.patientDetails(tokenNo);
	}

	@Override
	public void insertDiagnos(Diagnos diagnos) {
		
		doctorDao.insertDiagnos(diagnos);
	} 
		

	

	@Override
	public void insertDoctorNote(DoctorNote doctorNote) {
		doctorDao.insertDoctorNote(doctorNote);

	}

	@Override
	public void insertMedicine(MedicinePrescription medicinePrescription) {
		doctorDao.insertMedicine(medicinePrescription);

	}

	@Override
	public void insertTest(TestPrescription testPrescription) {
		doctorDao.insertTest(testPrescription);

	}

	@Override
	public List<Appointment> searchPatient(String name) {
		// TODO Auto-generated method stub
		return doctorDao.searchPatient(name);
	}

	@Override
	public List<AppointmentDiagnosDoctorDTO> diaHistDto(int patientId) {
		// TODO Auto-generated method stub
		return doctorDao.diaHistDto(patientId);
	}

	@Override
	public List<DoctorNoteHistory> doctorNoteDto(int patientId) {
		// TODO Auto-generated method stub
		return doctorDao.doctorNoteDto(patientId);
	}

	@Override
	public List<MedPresHistory> medPresHistoryDto(int patientId) {
		// TODO Auto-generated method stub
		return doctorDao.medPresHistoryDto(patientId);
	}

	@Override
	public List<TestPresHistory> testPresHistoryDto(int patientId) {
		// TODO Auto-generated method stub
		return doctorDao.testPresHistoryDto(patientId);
	}

	@Override
	public List<TestReportHistory> testReportHistoryDto(int patientId) {
		// TODO Auto-generated method stub
		return doctorDao.testReportHistoryDto(patientId);
	}

	@Override
	public List<Test> getTestList() {
		// TODO Auto-generated method stub
		return doctorDao.getTestList();
	}

	@Override
	public List<Medicine> getMedicineList() {
		// TODO Auto-generated method stub
		return doctorDao.getMedicineList();
	}

	@Override
	public List<Diagnos> getDiagnosList(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorDao.getDiagnosList( appointmentId);
	}

	@Override
	public void deleteDiagnos(int diagnosId) {
		doctorDao.deleteDiagnos(diagnosId);
		
	}

	@Override
	public List<MedicinePrescription> getMedPresList(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorDao.getMedPresList(appointmentId);
	}

	@Override
	public List<TestPrescription> getTestPresList(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorDao.getTestPresList(appointmentId);
	}

	@Override
	public List<DoctorNote> getDocNotPresList(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorDao.getDocNotPresList(appointmentId);
	}

	@Override
	public void disableAppointment(Appointment appointment) {
		doctorDao.disableAppointment(appointment);
		
	}

	@Override
	public Appointment getAppointment(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorDao.getAppointment(appointmentId);
	}

	@Override
	public int getUserIdFromDb(int appointmentId) {
		// TODO Auto-generated method stub
		return doctorDao.getUserIdFromDb(appointmentId);
	}



}

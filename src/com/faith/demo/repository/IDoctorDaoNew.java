package com.faith.demo.repository;

import java.util.List;

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


public interface IDoctorDaoNew {
	
	public List<Appointment> listAppointmentTable(int userId);
	
	public List<Appointment> searchPatient(String name);
	
	public Appointment patientDetails(int patientId);
	
	public void insertDiagnos(Diagnos diagnos);
	
	public void insertDoctorNote(DoctorNote doctorNote);
	
	public void insertMedicine(MedicinePrescription medicinePrescription);
	
	public void insertTest(TestPrescription testPrescription);
	///////
	public List<AppointmentDiagnosDoctorDTO> diaHistDto(int patientId);
	
	public List<DoctorNoteHistory> doctorNoteDto(int patientId);
	
	public List<MedPresHistory> medPresHistoryDto(int patientId);
	
	public List<TestPresHistory> testPresHistoryDto(int patientId);
	
	public List<TestReportHistory> testReportHistoryDto(int patientId);

	public List<Test> getTestList();

	public List<Medicine> getMedicineList();
	
	public List<Diagnos> getDiagnosList(int appointmentId);
	
	public List<MedicinePrescription> getMedPresList(int appointmentId);
	
	public void deleteDiagnos(int diagnosId);
	
	public List<TestPrescription> getTestPresList(int appointmentId);
	
	public List<DoctorNote> getDocNotPresList(int appointmentId);
	
	public void disableAppointment(Appointment appointment);
	
	public Appointment getAppointment(int appointmentId);
	
	public int getUserIdFromDb(int appointmentId);
}

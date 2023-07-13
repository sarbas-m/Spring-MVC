package com.faith.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appointmentId;
	private int tokenNo;
	private String appointmentIsActive;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)	
	private LocalDateTime appCreatedOn;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime appValidityDate;
	private String department;
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDateTime getAppValidityDate() {
		return appValidityDate;
	}

	public void setAppValidityDate(LocalDateTime appValidityDate) {
		this.appValidityDate = appValidityDate;
	}

	public List<PatientBill> getPatientBill() {
		return patientBill;
	}

	public void setPatientBill(List<PatientBill> patientBill) {
		this.patientBill = patientBill;
	}

	public List<MedicineBill> getMedicineBill() {
		return medicineBill;
	}

	public void setMedicineBill(List<MedicineBill> medicineBill) {
		this.medicineBill = medicineBill;
	}

	public List<TestBill> getTestBill() {
		return testBill;
	}

	public void setTestBill(List<TestBill> testBill) {
		this.testBill = testBill;
	}

	@PrePersist
	@PreUpdate
	private void persist() {
		if(appointmentIsActive==null) {
			appointmentIsActive="true";
	}
			
}
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctorId")
	private Doctor doctor;
	
	@OneToMany(mappedBy="appointment")
	private List<DoctorNote> doctorNote;
	
	@OneToMany(mappedBy="appointment")
	private List<Diagnos> diagnos;
	
	@OneToMany(mappedBy="appointment")
	private List<TestPrescription> testPrescription;
	
	@OneToMany(mappedBy="appointment")
	private List<MedicinePrescription> medicinePrescription;
	
	
	public int getAppointmentId() {
		return appointmentId;
	}
	
	@OneToMany(mappedBy="appointment")
	private List<PatientBill> patientBill;
	
	@OneToMany(mappedBy="appointment")
	private List<MedicineBill> medicineBill;
	
	@OneToMany(mappedBy="appointment")
	private List<TestBill> testBill;
	
	

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(int tokenNo) {
		this.tokenNo = tokenNo;
	}

	public String getAppointmentIsActive() {
		return appointmentIsActive;
	}

	public void setAppointmentIsActive(String appointmentIsActive) {
		this.appointmentIsActive = appointmentIsActive;
	}



	public LocalDateTime getAppCreatedOn() {
		return appCreatedOn;
	}

	public void setAppCreatedOn(LocalDateTime appCreatedOn) {
		this.appCreatedOn = appCreatedOn;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<DoctorNote> getDoctorNote() {
		return doctorNote;
	}

	public void setDoctorNote(List<DoctorNote> doctorNote) {
		this.doctorNote = doctorNote;
	}
	
		
	public List<Diagnos> getDiagnos() {
		return diagnos;
	}



	public void setDiagnos(List<Diagnos> diagnos) {
		this.diagnos = diagnos;
	}

	public List<TestPrescription> getTestPrescription() {
		return testPrescription;
	}

	public void setTestPrescription(List<TestPrescription> testPrescription) {
		this.testPrescription = testPrescription;
	}

	public List<MedicinePrescription> getMedicinePrescription() {
		return medicinePrescription;
	}

	public void setMedicinePrescription(List<MedicinePrescription> medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}

	

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", tokenNo=" + tokenNo + ", appointmentIsActive="
				+ appointmentIsActive + ", appCreatedOn=" + appCreatedOn + ", appValidityDate=" + appValidityDate
				+ ", patient=" + patient + ", doctor=" + doctor + ", doctorNote=" + doctorNote + ", diagnos=" + diagnos
				+ ", testPrescription=" + testPrescription + ", medicinePrescription=" + medicinePrescription
				+ ", patientBill=" + patientBill + ", medicineBill=" + medicineBill + ", testBill=" + testBill + "]";
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int appointmentId) {
		super();
		this.appointmentId = appointmentId;
	}

	
	
}
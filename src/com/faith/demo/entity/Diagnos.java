package com.faith.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Diagnos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int diagnosId;
	private String diagnos;
	private LocalDate diagnosCreatedOn;
	private String diagnosIsActive;
	
	@PrePersist
	@PreUpdate
	public void prePersist() {
		if(diagnosCreatedOn==null) { //we set default value in case if the value is not set yet
			diagnosCreatedOn=LocalDate.now();
		}
		
		}
	
	@ManyToOne
	@JoinColumn(name="appointmentId")
	private Appointment appointment;

	public Diagnos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDiagnosId() {
		return diagnosId;
	}

	public void setDiagnosId(int diagnosId) {
		this.diagnosId = diagnosId;
	}

	public String getDiagnos() {
		return diagnos;
	}

	public void setDiagnos(String diagnos) {
		this.diagnos = diagnos;
	}

	public LocalDate getDiagnosCreatedOn() {
		return diagnosCreatedOn;
	}

	public void setDiagnosCreatedOn(LocalDate diagnosCreatedOn) {
		this.diagnosCreatedOn = diagnosCreatedOn;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Diagnos [diagnosId=" + diagnosId + ", diagnos=" + diagnos + ", diagnosCreatedOn=" + diagnosCreatedOn
				+ ", appointment=" + appointment + "]";
	}

	public Diagnos(String diagnos, LocalDate diagnosCreatedOn) {
		super();
		this.diagnos = diagnos;
		this.diagnosCreatedOn = diagnosCreatedOn;
	}

	public Diagnos(Appointment appointment) {
		super();
		this.appointment = appointment;
	}

	public String getDiagnosIsActive() {
		return diagnosIsActive;
	}

	public void setDiagnosIsActive(String diagnosIsActive) {
		this.diagnosIsActive = diagnosIsActive;
	}
	
	
	

}

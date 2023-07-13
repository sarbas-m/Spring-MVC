package com.faith.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    private String doctorRegNo;
    
    @Column(nullable = false)
    private String doctorName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate doctorDateOfBirth;

    @Column(nullable = false)
    private String doctorGender;

    private String doctorBloodGroup;
    
    @Column(nullable = false)
    private String doctorPhoneNo;

    private String doctorAddress;

    @Column(nullable = false)
    private String doctorQualification;

    @Column(nullable = false)
    private String doctorEmail;

    @Column(nullable = false)
    private String doctorSpecialization;

    private int doctorConsultationFee;

    private String isActive;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (isActive == null)
            isActive = "yes";
    }
    
    public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	@OneToOne
    @JoinColumn(name="userId")
    private User user;
    
	@OneToMany(mappedBy="doctor")
	private List<Appointment> appointment;
    
    public Doctor() {
        super();
    }

	public int getDoctorId() {
		return doctorId;
	}

	public String getDoctorRegNo() {
		return doctorRegNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public LocalDate getDoctorDateOfBirth() {
		return doctorDateOfBirth;
	}

	public String getDoctorGender() {
		return doctorGender;
	}

	public String getDoctorBloodGroup() {
		return doctorBloodGroup;
	}

	public String getDoctorPhoneNo() {
		return doctorPhoneNo;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public String getDoctorQualification() {
		return doctorQualification;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public int getDoctorConsultationFee() {
		return doctorConsultationFee;
	}

	public String getIsActive() {
		return isActive;
	}

	public User getUser() {
		return user;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public void setDoctorRegNo(String doctorRegNo) {
		this.doctorRegNo = doctorRegNo;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setDoctorDateOfBirth(LocalDate doctorDateOfBirth) {
		this.doctorDateOfBirth = doctorDateOfBirth;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}

	public void setDoctorBloodGroup(String doctorBloodGroup) {
		this.doctorBloodGroup = doctorBloodGroup;
	}

	public void setDoctorPhoneNo(String doctorPhoneNo) {
		this.doctorPhoneNo = doctorPhoneNo;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public void setDoctorConsultationFee(int doctorConsultationFee) {
		this.doctorConsultationFee = doctorConsultationFee;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorRegNo=" + doctorRegNo + ", doctorName=" + doctorName
				+ ", doctorDateOfBirth=" + doctorDateOfBirth + ", doctorGender=" + doctorGender + ", doctorBloodGroup="
				+ doctorBloodGroup + ", doctorPhoneNo=" + doctorPhoneNo + ", doctorAddress=" + doctorAddress
				+ ", doctorQualification=" + doctorQualification + ", doctorEmail=" + doctorEmail
				+ ", doctorSpecialization=" + doctorSpecialization + ", doctorConsultationFee=" + doctorConsultationFee
				+ ", isActive=" + isActive + ", user=" + user + "]";
	}

	
    
}
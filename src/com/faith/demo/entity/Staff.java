package com.faith.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;
    
    private String staffRegNo;

    private String staffName;

    private String staffDepartment;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate staffDateOfBirth;

    private String staffGender;

    private String staffBloodGroup;

    private String staffPhoneNo;

    private String staffAddress;

    private String staffQualification;

    private String staffEmail;

    private String isActive;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (isActive == null)
            isActive = "yes";
    }

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStaffId() {
		return staffId;
	}

	public String getStaffRegNo() {
		return staffRegNo;
	}

	public String getStaffName() {
		return staffName;
	}

	public String getStaffDepartment() {
		return staffDepartment;
	}

	public LocalDate getStaffDateOfBirth() {
		return staffDateOfBirth;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public String getStaffBloodGroup() {
		return staffBloodGroup;
	}

	public String getStaffPhoneNo() {
		return staffPhoneNo;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public String getStaffQualification() {
		return staffQualification;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public String getIsActive() {
		return isActive;
	}

	public User getUser() {
		return user;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public void setStaffRegNo(String staffRegNo) {
		this.staffRegNo = staffRegNo;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public void setStaffDepartment(String staffDepartment) {
		this.staffDepartment = staffDepartment;
	}

	public void setStaffDateOfBirth(LocalDate staffDateOfBirth) {
		this.staffDateOfBirth = staffDateOfBirth;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public void setStaffBloodGroup(String staffBloodGroup) {
		this.staffBloodGroup = staffBloodGroup;
	}

	public void setStaffPhoneNo(String staffPhoneNo) {
		this.staffPhoneNo = staffPhoneNo;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public void setStaffQualification(String staffQualification) {
		this.staffQualification = staffQualification;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffRegNo=" + staffRegNo + ", staffName=" + staffName
				+ ", staffDepartment=" + staffDepartment + ", staffDateOfBirth=" + staffDateOfBirth + ", staffGender="
				+ staffGender + ", staffBloodGroup=" + staffBloodGroup + ", staffPhoneNo=" + staffPhoneNo
				+ ", staffAddress=" + staffAddress + ", staffQualification=" + staffQualification + ", staffEmail="
				+ staffEmail + ", isActive=" + isActive + ", user=" + user + "]";
	}

}
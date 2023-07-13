package com.faith.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class MedicineCompany {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int companyId;
 private String companyNumber;
 private String companyName;
 private LocalDate companyCreatedOn;
 
 
 
 public String getCompanyNumber() {
	return companyNumber;
}
public void setCompanyNumber(String companyNumber) {
	this.companyNumber = companyNumber;
}
@PrePersist
 @PreUpdate
 public void prePersist() {
	 if(companyCreatedOn==null) {
		 companyCreatedOn=LocalDate.now();
	 }
	
 }
 @OneToMany(mappedBy="medicineCompany")
 private List<Medicine> medicine;
 @OneToMany(mappedBy="medicineCompany")
 private List<MedicineOrder> medicineOrder;
	
	
 public int getCompanyId() {
  return companyId;
 }
 public void setCompanyId(int companyId) {
  this.companyId = companyId;
 }
 public String getCompanyName() {
  return companyName;
 }
 public void setCompanyName(String companyName) {
  this.companyName = companyName;
 }
 public MedicineCompany() {
  super();
  // TODO Auto-generated constructor stub
 }
 public List<Medicine> getMedicine() {
  return medicine;
 }
 public void setMedicine(List<Medicine> medicine) {
  this.medicine = medicine;
 }
 public List<MedicineOrder> getMedicineOrder() {
  return medicineOrder;
 }
 public void setMedicineOrder(List<MedicineOrder> medicineOrder) {
  this.medicineOrder = medicineOrder;
 }
@Override
public String toString() {
	return "MedicineCompany [companyId=" + companyId + ", companyName=" + companyName + ", medicineOrder="
			+ medicineOrder + "]";
}
public LocalDate getCompanyCreatedOn() {
	return companyCreatedOn;
}
public void setCompanyCreatedOn(LocalDate companyCreatedOn) {
	this.companyCreatedOn = companyCreatedOn;
}

	
	

}
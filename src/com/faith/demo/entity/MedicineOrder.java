package com.faith.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class MedicineOrder {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int orderId;
 private int orderQty;
 private LocalDate orderOn;
 
 
 
 @PrePersist
 @PreUpdate
 public void prePersist() {
	 if(orderOn==null) {
		 orderOn=LocalDate.now();
	 }
	
 }
	
 @ManyToOne
 @JoinColumn(name="medicineId")
 private Medicine medicine;
 @ManyToOne
 @JoinColumn(name="companyId")
 private MedicineCompany medicineCompany;
 public int getOrderId() {
  return orderId;
 }
 public void setOrderId(int orderId) {
  this.orderId = orderId;
 }
 public int getOrderQty() {
  return orderQty;
 }
 public void setOrderQty(int orderQty) {
  this.orderQty = orderQty;
 }
 public Medicine getMedicine() {
  return medicine;
 }
 public void setMedicine(Medicine medicine) {
  this.medicine = medicine;
 }
 public MedicineCompany getMedicineCompany() {
  return medicineCompany;
 }
 public void setMedicineCompany(MedicineCompany medicineCompany) {
  this.medicineCompany = medicineCompany;
 }

}

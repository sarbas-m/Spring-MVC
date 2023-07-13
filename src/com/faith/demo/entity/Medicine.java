package com.faith.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Medicine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int medicineId;
	private String medicineNumber;
	private String medicineName;
	private int quantity;
	private double price;
	private String medicineIsActive;
	@PrePersist
	@PreUpdate
	public void prepersist() {
		if(medicineIsActive == null)   
			medicineIsActive = "yes";
	}
	@OneToMany(mappedBy="medicine")
	private List<MedicinePrescription> medicinePrescription;
	@ManyToOne
	@JoinColumn(name="companyId")
	private MedicineCompany medicineCompany;
	@OneToMany(mappedBy="medicine")
	private List<MedicineOrder> medicineOrder;
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineNumber() {
		return medicineNumber;
	}
	public void setMedicineNumber(String medicineNumber) {
		this.medicineNumber = medicineNumber;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}


	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMedicineIsActive() {
		return medicineIsActive;
	}
	public void setMedicineIsActive(String medicineIsActive) {
		this.medicineIsActive = medicineIsActive;
	}
	public List<MedicinePrescription> getMedicinePrescription() {
		return medicinePrescription;
	}
	public void setMedicinePrescription(List<MedicinePrescription> medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}
	public MedicineCompany getMedicineCompany() {
		return medicineCompany;
	}
	public void setMedicineCompany(MedicineCompany medicineCompany) {
		this.medicineCompany = medicineCompany;
	}
	public List<MedicineOrder> getMedicineOrder() {
		return medicineOrder;
	}
	public void setMedicineOrder(List<MedicineOrder> medicineOrder) {
		this.medicineOrder = medicineOrder;
	}

}
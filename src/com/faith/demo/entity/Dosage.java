package com.faith.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dosage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dosageId;
	private String dosagePattern;
	private int dosageQty;
	
	@OneToMany(mappedBy="dosage",fetch=FetchType.EAGER)
	private List<MedicinePrescription> medicinePrescription;

	public Dosage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDosageId() {
		return dosageId;
	}

	public void setDosageId(int dosageId) {
		this.dosageId = dosageId;
	}

	public String getDosagePattern() {
		return dosagePattern;
	}

	public void setDosagePattern(String dosagePattern) {
		this.dosagePattern = dosagePattern;
	}

	public int getDosageQty() {
		return dosageQty;
	}

	public void setDosageQty(int dosageQty) {
		this.dosageQty = dosageQty;
	}

	public List<MedicinePrescription> getMedicinePrescription() {
		return medicinePrescription;
	}

	public void setMedicinePrescription(List<MedicinePrescription> medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}

	/*@Override
	public String toString() {
		return "Dosage [dosageId=" + dosageId + ", dosagePattern=" + dosagePattern + ", dosageQty=" + dosageQty
				+ ", medicinePrescription=" + medicinePrescription + "]";
	}*/
	
	
	
	
	

}

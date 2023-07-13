package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.TestBill;
import com.faith.demo.example.ReportNeeds;

public interface IReportRepository {
	
	public List<ReportNeeds>reportList();
	
	public List<ReportNeeds>listOfReportGen(int appoId);

	public void removePrescription(int apppId);

	public void insertBil(TestBill tes);

	public Appointment gettingApObj(int appoinId);

	public TestBill gettingBillNumber(int appoiId);

}

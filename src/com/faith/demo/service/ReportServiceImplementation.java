package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.TestBill;
import com.faith.demo.example.ReportNeeds;
import com.faith.demo.repository.IReportRepository;

@Service
public class ReportServiceImplementation implements IReportService {
	
	@Autowired
	private IReportRepository reportrepo;

	@Override
	public List<ReportNeeds> reportList() {
		// TODO Auto-generated method stub
		return reportrepo.reportList();
	}

	@Override
	public List<ReportNeeds> listOfReportGen(int appoId) {
		// TODO Auto-generated method stub
		return reportrepo.listOfReportGen(appoId);
	}

	@Override
	public void removePrescription(int apppId) {

		reportrepo.removePrescription(apppId);
	}

	@Override
	public void insertBil(TestBill tes) {
		// TODO Auto-generated method stub
		reportrepo.insertBil(tes);
		
	}

	@Override
	public Appointment gettingApObj(int appoinId) {
		// TODO Auto-generated method stub
		return reportrepo.gettingApObj(appoinId);
	}

	@Override
	public TestBill gettingBillNumber(int appoiId) {
		// TODO Auto-generated method stub
		return reportrepo.gettingBillNumber(appoiId);
	}
	
	

}

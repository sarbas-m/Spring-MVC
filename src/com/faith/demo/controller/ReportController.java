package com.faith.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.TestBill;
import com.faith.demo.example.ReportNeeds;
import com.faith.demo.service.IReportService;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private IReportService reportservice;
	
	@GetMapping("/listofreports")
	public String listOfReport(Model themodel) {
		
		List<ReportNeeds>listedReports= reportservice.reportList();
		themodel.addAttribute("reportfrontlist", listedReports);
		
		return "report-frontpage";
		
		
	}
	@GetMapping("/bill")
	public String bill(@RequestParam("appointedId") int apId, Model themodel) {
		
		reportservice.removePrescription(apId);
		

		TestBill testbill= new TestBill();
		
		Appointment appin=reportservice.gettingApObj(apId);
			
		List<ReportNeeds> billlist=reportservice.listOfReportGen(apId);
		
		
		int bill=0;
		for(int i=0;i<billlist.size();i++) {
			bill=billlist.get(i).getTest().getTestPrice()+bill;
		}
		String name=billlist.get(0).getPatient().getPatientName();
		String reg=billlist.get(0).getPatient().getRegistrationNumber();
		LocalDate dates=billlist.get(0).getTestreport().getReportCreatedOn();
		System.out.println(reg);
		themodel.addAttribute("billlist",billlist);
		themodel.addAttribute("bill", bill);
		themodel.addAttribute("name",name);
		themodel.addAttribute("reg",reg);
		themodel.addAttribute("bilingdate", dates);
		
		System.out.println("safaf");
		testbill.setTestBillAmount(bill);
		System.out.println("Sadasfasfewwe");
		testbill.setAppointment(appin);
		System.out.println("adsdaddads");
		reportservice.insertBil(testbill);
		System.out.println("Dawdss");
		
		TestBill testing= reportservice.gettingBillNumber(apId);
		String billnumbered=testing.getTestbillNumber();
		themodel.addAttribute("bilnums", billnumbered);
		
		
		return "bill-page";
		
		
	}
	@GetMapping("/allreportfront")
	public String beforeReportGen(@RequestParam("appointingId") int apId, Model themodel) {
		
		
		
		List<ReportNeeds>beforerepogenertaion=reportservice.listOfReportGen(apId);
		themodel.addAttribute("listbeforegeneratingreport", beforerepogenertaion);
		String name=beforerepogenertaion.get(0).getPatient().getPatientName();
		int age=beforerepogenertaion.get(0).getPatient().getPatientAge();
		String blood=beforerepogenertaion.get(0).getPatient().getPatientBloodGroup();
		String docname=beforerepogenertaion.get(0).getDoctor().getDoctorName();
		
		themodel.addAttribute("pname", name);
		themodel.addAttribute("page", age);
		themodel.addAttribute("pblood", blood);
		themodel.addAttribute("doctor", docname);

		return "report-front-list";
		
		
	}
	@GetMapping("/disablePrescription")
	public String removePrescription(@RequestParam("appointedId") int aId) {
		
		reportservice.removePrescription(aId);
		
		return "redirect:/patientview/patientfortest";
		
		
	}

}

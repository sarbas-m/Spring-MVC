package com.faith.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Patient;
import com.faith.demo.repository.AppointmentDaoImplementation;
import com.faith.demo.service.IBillService;

@Controller
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private IBillService billDao;
	
	@GetMapping("/home")
	public String showDashBoard(Model theModel) {
		
		return "welcoomeindex";
	}

	@GetMapping("/viewbill")
	public String bookBill(@RequestParam("appointmentId") int appointmentId, @RequestParam("patientId") int patientId,
			Model theModel) {
		List<Appointment> listApp = billDao.getAppointment(patientId);
		int regFess = 150;
		int consultFee = 0;
		Patient thePatient = billDao.patient(patientId);

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime currentDateTime = LocalDateTime.parse(LocalDateTime.now().format(format), format);
		LocalDate todayDate = LocalDate.now();
		LocalDateTime appointDateTime = billDao.getAppointment(patientId).get(0).getAppCreatedOn();
		LocalDate patRegDate = listApp.get(0).getPatient().getPatientCreatedOn();
		LocalDate patValDate = listApp.get(0).getPatient().getValidityDate();
		LocalDateTime appointValidity = listApp.get(0).getAppValidityDate();
		//patient condition
		if(listApp.size()>=2) {
			regFess=150;
		}
		if (appointValidity.isBefore(currentDateTime)){
			consultFee = 0;
		}
		else {
			for (int i = 0; i < listApp.size(); i++) {
				consultFee = listApp.get(i).getDoctor().getDoctorConsultationFee() + consultFee;
			}
		}
		int sum=regFess+consultFee;
		System.out.println(sum);
		
		/*
		
		if (patRegDate.equals(todayDate)) {
			for (int i = 0; i < listApp.size(); i++) {
				consultFee = listApp.get(i).getDoctor().getDoctorConsultationFee() + consultFee;
			}
			sum = 150 + consultFee;

		} else if (patValDate.isBefore(todayDate) && appointValidity.isBefore(currentDateTime)) {
			for (int i = 0; i < listApp.size(); i++) {
				consultFee = listApp.get(i).getDoctor().getDoctorConsultationFee() + consultFee;
			}
			sum = 150 + consultFee;
		} else if (patValDate.isAfter(todayDate) && appointValidity.isBefore(currentDateTime)) {
			for (int i = 0; i < listApp.size(); i++) {
				consultFee = listApp.get(i).getDoctor().getDoctorConsultationFee() + consultFee;
			}
			sum = consultFee;
		} else {
			sum = 150;
		}*/
		String patientName=thePatient.getPatientName();
		String registrationNumber=thePatient.getRegistrationNumber();		
        System.out.println(consultFee);
		System.out.println(sum);
		theModel.addAttribute("consulfee", consultFee);
		theModel.addAttribute("patientName",patientName);
		theModel.addAttribute("registrationNumber",registrationNumber);
		theModel.addAttribute("registrfee", regFess);
		theModel.addAttribute("sum",sum);
		
		return "billcheck";

	}
}

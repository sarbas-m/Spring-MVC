package com.faith.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Patient;
import com.faith.demo.repository.IAppointmentDao;
import com.faith.demo.service.IPatientService;
@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private IPatientService patientservice;
	@Autowired
	private IAppointmentDao appointmentService;

	// add form
	@GetMapping("/home")
	public String showDashBoard(Model theModel) {
		
		return "welcoomeindex";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel) {
		// create model attribute to blindform data
		Patient thePatient = new Patient();
		// add customer to model
		theModel.addAttribute("patient", thePatient);
		return "patient-form";

	}

	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient thePatient) {
		System.out.println(thePatient);
		// save the customer using services
		patientservice.savePatient(thePatient);
		return "redirect:/patient/list";

	}

	@GetMapping("/list")
	public String listPatient1(Model theModel) {
		List<Patient> thePatient = patientservice.getPatient();
		theModel.addAttribute("patient", thePatient);
		return "list-patient";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId")int patientId,Model theModel) {
		//create model attribute to bindform data
		Patient thePatient=patientservice.getPatient(patientId);
		//add patient to the model 
		theModel.addAttribute("patient",thePatient);
		return "patient-form";
	
	}
	@GetMapping("/disable")
	public String disablePatient(@RequestParam("patientId")int patientId) {
		patientservice.disablePatient(patientservice.searchPatient(patientId));
	
		return "redirect:/patient/list";
		
	}
	/*@PostMapping("/updatePatient")
	public String updatePatient(@ModelAttribute("patient") Patient thePatient) {
		System.out.println(thePatient);
		// save the customer using services
		patientservice.updatePatient(thePatient);
		return "redirect:/patient/list";

	}*/
	@GetMapping("/search")
	public String searchPatient(@RequestParam("patientId") int patientId,Model theModel) {
	Patient thePatient=patientservice.searchPatient(patientId);
		theModel.addAttribute("patient", thePatient);
		return "redirect:/patient/list";
	}
	@GetMapping("/book")
	public String bookAppointment(@RequestParam("patientId") int patientId,Model theModel) {
	Patient thePatient=patientservice.searchPatient(patientId);
	Appointment appointment=new Appointment();
	
	List<Doctor> listDoctor=patientservice.getDoctorList();
	    theModel.addAttribute("listDoctor", listDoctor);
		theModel.addAttribute("patient", thePatient);
		theModel.addAttribute("patientId", patientId);
		theModel.addAttribute("appointment", appointment);
		return "booking-form";
	}
	@PostMapping("/addappointment")
	public String saveAppointment(@RequestParam("patient.patientId") int patientId,@ModelAttribute("appointment") Appointment theAppointment) {
		// save the customer using services
		
		theAppointment.getPatient().setPatientId(patientId);
		System.out.println(theAppointment);
	
		appointmentService.saveAppointment(theAppointment);
		return "redirect:/appointment/listappointment";

	}
	@GetMapping("/listappointment")
	public String listPatient(Model theModel) {
		List<Appointment> theAppointment = appointmentService.getAppointment();
		theModel.addAttribute("appointment", theAppointment);
		//theModel.addAttribute("patientId", patientId);
		System.out.println("in list");
		return "list-receptionist-appointment";
	}
}

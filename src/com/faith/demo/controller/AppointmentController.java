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
import com.faith.demo.service.IAppointmentService;
@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	
	
		@Autowired
		private IAppointmentService appointmentservice;
		
		@GetMapping("/home")
		public String showDashBoard(Model theModel) {
			
			return "welcoomeindex";
		}
		// add form
		@GetMapping("/showFormAdd")
		public String showFormAdd(Model theModel) {
			// create model attribute to blindform data
			Appointment theAppointment = new Appointment();
			// add customer to model
			theModel.addAttribute("appointment",theAppointment);
			return "booking-form";
			
		}

		@PostMapping("/addappointment")
		public String saveAppointment(@ModelAttribute("appointment") Appointment theAppointment) {
			// save the customer using services
			System.out.println(theAppointment);
			appointmentservice.saveAppointment(theAppointment);
			return "redirect:/appointment/listappointment";

		}
		@GetMapping("/listappointment")
		public String listPatient(Model theModel) {
			List<Appointment> theAppointment = appointmentservice.getAppointment();
			theModel.addAttribute("appointment", theAppointment);
			return "list-receptionist-appointment";
		}
		@GetMapping("/searchappointment")
		public String searchAppointment(@RequestParam("appointmentId") int appointmentId,Model theModel) {
		Appointment theAppointment=appointmentservice.searchAppointment(appointmentId);
			theModel.addAttribute("appointment", theAppointment);
			return "redirect:/appointment/listappointment";
		}
		@GetMapping("/disableappointment")
		public String disableAppointment(@RequestParam("appointmentId")int appointmentId) {
			appointmentservice.disableAppointment(appointmentservice.searchAppointment(appointmentId));
			return "redirect:/appointment/listappointment";
			
		}
		
}

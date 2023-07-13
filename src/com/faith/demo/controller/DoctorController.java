package com.faith.demo.controller;

import com.faith.demo.entity.Doctor;
import com.faith.demo.service.DoctorServiceImple;
import com.faith.demo.service.StaffServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
    private  DoctorServiceImple doctorService;
	
	@Autowired
    private StaffServiceImple staffService;

    @GetMapping("/home")
    public String showDash(Model model) {
        List<Doctor> doctorList = doctorService.getAllDoctors();
        model.addAttribute("doctorList", doctorList);
        return "welcomeadmin";
    }
    
    @GetMapping("/list")
    public String listDoctors(Model model) {
        List<Doctor> doctorList = doctorService.getAllDoctors();
        model.addAttribute("doctorList", doctorList);
        return "listdoctor";
    }

    @GetMapping("/add")
    public String showAddForm(Model theModel) {
        Doctor doctor = new Doctor();
        int userId=staffService.getUserIdFromDb();
        theModel.addAttribute("userId", userId);
        theModel.addAttribute("doctor", doctor);
        return "adddoctor";
    }

    @PostMapping("/save")
    public String addDoctor(@ModelAttribute("doctor") Doctor doctor) {
        LocalDate newDate = doctor.getDoctorDateOfBirth().plusDays(1);
        doctor.setDoctorDateOfBirth(newDate);
        doctorService.addDoctor(doctor);
        return "redirect:/doctor/list";
    }


@GetMapping("/edit")
   		public String showFormForUpdate(@RequestParam("doctorId") int doctorId, Model model) {
     	Doctor doctor = doctorService.getDoctorById(doctorId);
        model.addAttribute("doctor", doctor);
        return "adddoctor";
}	
   
@PostMapping("/edit")
	public String updateDoctor(@ModelAttribute("doctor") Doctor doctor) {
    doctorService.updateDoctor(doctor);
    return "redirect:/doctor/list";
}


@GetMapping("/delete")
public String delete(@RequestParam("doctorId") int doctorId) {
    doctorService.deleteDoctor(doctorId);
    return "redirect:/doctor/list";
}

@GetMapping("/disable")
public String disableDoctor(@RequestParam("doctorId") int doctorId) {
	System.out.println("sdafa");
    doctorService.disableDoctor(doctorId);
    return "redirect:/doctor/list";
}
    
    
   
}



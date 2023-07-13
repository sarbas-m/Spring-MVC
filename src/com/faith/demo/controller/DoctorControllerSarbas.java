package com.faith.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.Diagnos;
import com.faith.demo.entity.DoctorNote;
import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicinePrescription;
import com.faith.demo.entity.Test;
import com.faith.demo.entity.TestPrescription;
import com.faith.demo.example.AppointmentDiagnosDoctorDTO;
import com.faith.demo.example.DoctorNoteHistory;
import com.faith.demo.example.MedPresHistory;
import com.faith.demo.example.TestPresHistory;
import com.faith.demo.example.TestReportHistory;

import com.faith.demo.service.IDoctorServiceNew;



@Controller
@RequestMapping("/doctorSarbas")
public class DoctorControllerSarbas {
	
	@Autowired
	private IDoctorServiceNew doctorService;
	
	@GetMapping("/home")
	public String home(@RequestParam("userId") int userId,Model theModel) {
		System.out.println("Dsads");
		theModel.addAttribute("userId", userId);
		return "NewFile";
	}
	@GetMapping("/listAppoinmenet")
	public String listAppointment(@RequestParam("userId") int userId,Model theModel) {
		
		List<Appointment> theAppointment=doctorService.listAppointmentTable(userId);

		theModel.addAttribute("appoinments", theAppointment);
		theModel.addAttribute("userId", userId);
		return "list-appoinment";
		
	}
	@GetMapping("/searchPatient")
	public String searchPatient(@RequestParam("searchName") String name,Model theModel) {
		System.out.println(name);
		List<Appointment> theAppointment=doctorService.searchPatient(name);
		theModel.addAttribute("appoinments", theAppointment);
		return "list-appoinment";
		
	}
	
	@GetMapping("/patient")
	public String patientData(@RequestParam("tokenNo") int tokenNo,@RequestParam("userId") int userId,Model theModel) {
		
		Appointment patientDetails=doctorService.patientDetails(tokenNo);
		
		theModel.addAttribute("patientDetails", patientDetails);
		theModel.addAttribute("userId", userId);
		
		return "patient-data";
		
	}
	@GetMapping("/diagnos")
	public String diagnosHistory(@RequestParam("patientId") int patientId, @RequestParam("appointmentId") int appointmentId, @RequestParam("userId") int userId,Model theModel) {
	
		List<AppointmentDiagnosDoctorDTO> history=doctorService.diaHistDto(patientId);
		theModel.addAttribute("dignosHistory",history);
		List<DoctorNoteHistory> noteHistory=doctorService.doctorNoteDto(patientId);
		theModel.addAttribute("noteHistory",noteHistory);
		List<MedPresHistory> medhistory=doctorService.medPresHistoryDto(patientId);
		theModel.addAttribute("medhistory",medhistory);
		List<TestPresHistory> testHistory=doctorService.testPresHistoryDto(patientId);
		theModel.addAttribute("testHistory",testHistory);
		List<TestReportHistory> testReportHistory=doctorService.testReportHistoryDto(patientId);
		theModel.addAttribute("testReportHistory",testReportHistory);
		theModel.addAttribute("appointmentId", appointmentId);
		theModel.addAttribute("patientId", patientId);
		theModel.addAttribute("userId", userId);
		return "diagnos-data";
				
	}
	@GetMapping("/startDiagnos")
	public ModelAndView  showFormAdd(@RequestParam("appointmentId") int appointmentId,@RequestParam("patientId") int patientId,@RequestParam("userId") int userId, Model theModel) { //theModel is acontainer
		//create model attribute to bindform data
	
		Diagnos diagnos=new Diagnos();
		DoctorNote doctorNote=new DoctorNote();
		MedicinePrescription medicinePrescription=new MedicinePrescription();
		TestPrescription testPrescription=new TestPrescription();
				
		Map<String, Object> modelMap = new HashMap<String, Object>();	
		List<Test> testList=doctorService.getTestList();
		List<Medicine> medicineList=doctorService.getMedicineList();
		modelMap.put("userId", userId);
		modelMap.put("appointmentId", appointmentId);
		modelMap.put("patientId", patientId);
		modelMap.put("diagnos", diagnos);
		modelMap.put("doctorNote", doctorNote);
		modelMap.put("medicinePrescriptio"
				+ ""
				+ "n", medicinePrescription);
		modelMap.put("testPrescription", testPrescription);		
		modelMap.put("testList", testList);
		modelMap.put("medicineList", medicineList);
		return new ModelAndView("diagnos-form",modelMap);
		
	}
	@PostMapping("/saveDiagnos")
	public String saveDiagnos(@ModelAttribute("diagnos") Diagnos diagnos,Model theModel ) {
       

		int aid=diagnos.getAppointment().getAppointmentId();
		int pid=diagnos.getAppointment().getPatient().getPatientId();
        int userId=doctorService.getUserIdFromDb(aid);
        System.out.println(userId);
        theModel.addAttribute("userId", userId);
		theModel.addAttribute("appointmentId",aid);
		theModel.addAttribute("patientId",pid);
		doctorService.insertDiagnos(diagnos);
		
		List<Diagnos> cuurentDiagnos=doctorService.getDiagnosList(aid);		
		List<Test> testList=doctorService.getTestList();
		List<Medicine> medicineList=doctorService.getMedicineList();

		theModel.addAttribute("medicineList", medicineList);
		
		
		theModel.addAttribute("cuurentDiagnos", cuurentDiagnos);
		theModel.addAttribute("testList", testList);
	
		MedicinePrescription medicinePrescription=new MedicinePrescription();
		theModel.addAttribute("medicinePrescription", medicinePrescription);
		TestPrescription testPrescription=new TestPrescription();
		theModel.addAttribute("testPrescription", testPrescription);
		DoctorNote doctorNote=new DoctorNote();
		theModel.addAttribute("doctorNote", doctorNote);
		
		
		return "diagnos-form";
		
	}
	@PostMapping("/saveMedicine")
	public String saveMedicine(@ModelAttribute("medicinePrescription") MedicinePrescription medicinePrescription,Model theModel ) {
		

		Diagnos diagnos=new Diagnos();
		DoctorNote doctorNote=new DoctorNote();
		TestPrescription testPrescription=new TestPrescription();
		int aid=medicinePrescription.getAppointment().getAppointmentId();
		int pid=medicinePrescription.getAppointment().getPatient().getPatientId();
        int userId=doctorService.getUserIdFromDb(aid);
        System.out.println(userId);
        theModel.addAttribute("userId", userId);
		doctorService.insertMedicine(medicinePrescription);
		
		List<Diagnos> cuurentDiagnos=doctorService.getDiagnosList(aid);
	    List<MedicinePrescription> currentMed=doctorService.getMedPresList(aid);
	    
	    theModel.addAttribute("userId", userId);
		List<Test> testList=doctorService.getTestList();
		List<Medicine> medicineList=doctorService.getMedicineList();
		theModel.addAttribute("currentMed", currentMed);
		theModel.addAttribute("testList", testList);
		theModel.addAttribute("medicineList", medicineList);	
		theModel.addAttribute("cuurentDiagnos", cuurentDiagnos);
		theModel.addAttribute("appointmentId",aid);
		theModel.addAttribute("patientId",pid);
		theModel.addAttribute("doctorNote", doctorNote);
		theModel.addAttribute("testPrescription", testPrescription);
		theModel.addAttribute("diagnos", diagnos);

		return "diagnos-form";
		
	}
	@PostMapping("/saveTest")
	public String saveTest(@ModelAttribute("testPrescription") TestPrescription testPrescription,Model theModel ) {

		Diagnos diagnos=new Diagnos();
		DoctorNote doctorNote=new DoctorNote();
		MedicinePrescription medicinePrescription=new MedicinePrescription();
		int aid=testPrescription.getAppointment().getAppointmentId();
        int userId=doctorService.getUserIdFromDb(aid);
        System.out.println(userId);
        theModel.addAttribute("userId", userId);

		doctorService.insertTest(testPrescription);
		
		List<Diagnos> cuurentDiagnos=doctorService.getDiagnosList(aid);
	    List<MedicinePrescription> currentMed=doctorService.getMedPresList(aid);
	    List<TestPrescription> cuurentTestList=doctorService.getTestPresList(aid);			
		List<Test> testList=doctorService.getTestList();
		List<Medicine> medicineList=doctorService.getMedicineList();
		
		theModel.addAttribute("currentMed", currentMed);
		theModel.addAttribute("testList", testList);
		theModel.addAttribute("medicineList", medicineList);	
		theModel.addAttribute("cuurentDiagnos", cuurentDiagnos);
		theModel.addAttribute("appointmentId",aid);
	
		theModel.addAttribute("diagnos",diagnos);
		theModel.addAttribute("doctorNote",doctorNote);
		theModel.addAttribute("medicinePrescription",medicinePrescription);
		theModel.addAttribute("cuurentTestList",cuurentTestList);
		
		return "diagnos-form";
		
	}
	
	@PostMapping("/saveDoctorNote")
	public String saveNote(@ModelAttribute("doctorNote") DoctorNote doctorNote,Model theModel) {
		
		Diagnos diagnos=new Diagnos();
		MedicinePrescription medicinePrescription=new MedicinePrescription();
		TestPrescription testPrescription=new TestPrescription();	
		int aid=doctorNote.getAppointment().getAppointmentId();
        int userId=doctorService.getUserIdFromDb(aid);
        System.out.println(userId);
        theModel.addAttribute("userId", userId);
		List<Diagnos> cuurentDiagnos=doctorService.getDiagnosList(aid);
	    List<MedicinePrescription> currentMed=doctorService.getMedPresList(aid);
	    List<TestPrescription> cuurentTestList=doctorService.getTestPresList(aid);
	    
		List<Test> testList=doctorService.getTestList();
		List<Medicine> medicineList=doctorService.getMedicineList();
		
		doctorService.insertDoctorNote(doctorNote);
		List<DoctorNote> currentDocNote=doctorService.getDocNotPresList(aid);
		theModel.addAttribute("currentMed", currentMed);
		theModel.addAttribute("testList", testList);
		theModel.addAttribute("medicineList", medicineList);	
		theModel.addAttribute("cuurentDiagnos", cuurentDiagnos);
		theModel.addAttribute("appointmentId",aid);
		theModel.addAttribute("diagnos",diagnos);
		theModel.addAttribute("testPrescription",testPrescription);
		theModel.addAttribute("medicinePrescription",medicinePrescription);
		theModel.addAttribute("cuurentTestList",cuurentTestList);
		theModel.addAttribute("currentDocNote",currentDocNote);
	

		return "diagnos-form";
		
	}
	
	/*@GetMapping("/disableDia")
	public String deleteDiagnos(@RequestParam("diagnosId") int diagnosId,@ModelAttribute("diagnos") Diagnos diagnos,Model theModel) {
		
		
		doctorService.deleteDiagnos(diagnosId);
		Map<String, Object> modelMap = new HashMap<String, Object>();	
		List<Test> testList=doctorService.getTestList();
		List<Medicine> medicineList=doctorService.getMedicineList();

		theModel.addAttribute("testList", testList);
		theModel.addAttribute("medicineList", medicineList);
		MedicinePrescription medicinePrescription=new MedicinePrescription();
		theModel.addAttribute("medicinePrescription", medicinePrescription);
		TestPrescription testPrescription=new TestPrescription();
		theModel.addAttribute("testPrescription", testPrescription);
		DoctorNote doctorNote=new DoctorNote();
		theModel.addAttribute("doctorNote", doctorNote);
		

		return "diagnos-form";
		
	}*/
	
	@GetMapping("/disableApp")
	public String  disableApp(@RequestParam("appointmentId")int appointmentId,@RequestParam("userId") int userId,Model theModel) {
		
		System.out.println(appointmentId);
		
		Appointment theAppointment=doctorService.getAppointment(appointmentId);
		
		System.out.println(theAppointment.getAppointmentIsActive());
		
		doctorService.disableAppointment(theAppointment);
		
		System.out.println(theAppointment.getAppointmentIsActive());
		theModel.addAttribute("userId", userId);
		
		return "redirect:/doctorSarbas/listAppoinmenet";
	
	}

}

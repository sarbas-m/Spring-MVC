package com.faith.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faith.demo.entity.TestReport;
import com.faith.demo.example.ViewPatientForTest;
import com.faith.demo.service.IViewPatientService;

@RequestMapping("/patientview")
@Controller
public class PatientViewController {
	
	@Autowired
	IViewPatientService viewpatientservice;
	
	@GetMapping("/patientfortest")
	public String viewPatientList(Model themodel) {
		
		List<ViewPatientForTest>listOfTestPatient=viewpatientservice.patientForTest();
		themodel.addAttribute("allPatientTest", listOfTestPatient);
		
		return "viewtestpatient-list";
		
		}
	
	@GetMapping("/testdetailsofeach")
	public String detailsForEach(@RequestParam("appoinmentId") int appId, Model themodel) {
		
		List<ViewPatientForTest>listOfEach=viewpatientservice.detailsOfEachTest(appId);
		themodel.addAttribute("listEachPatientTest", listOfEach);
		return "each-patient-detail-list";
		
		
	}
	@GetMapping("/resultaddform")
	public String addingResult(@RequestParam("prescriptionId") int presId, Model themodel) {
		
		List<ViewPatientForTest>patientTestDetail=viewpatientservice.tsetDetailWithPrescription(presId);
		themodel.addAttribute("patientTestDisplayWithPres", patientTestDetail);
		
		TestReport testreport = new TestReport(); //null object created
		themodel.addAttribute("actualvalueadd", testreport);
		themodel.addAttribute("prescribedId", presId);
		
		return "actual-value-form";
		
		
	}
	@GetMapping("/addTheActualValue")
     public String saveActualValue(@ModelAttribute("actualvalueadd") TestReport reported) {
		
		viewpatientservice.saveActual(reported);
		return "welcometesting";
		
	}
	
	@GetMapping("/resultEditForm")
	public String editTheResult(@RequestParam("preId") int prescrId, Model themodel) {
		
		List<ViewPatientForTest>editResultListShow=viewpatientservice.tsetDetailWithPrescription(prescrId);
		themodel.addAttribute("patientTestDisplayWithPres", editResultListShow);

		
		TestReport tsr = viewpatientservice.editingResult(prescrId);
		themodel.addAttribute("actualvalueadd", tsr);
		return "actual-value-form";
		
	}
	

}

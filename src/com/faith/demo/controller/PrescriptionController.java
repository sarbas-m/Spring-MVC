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

import com.faith.demo.entity.Medicine;
import com.faith.demo.example.MedPres;
import com.faith.demo.example.ViewPatientForOp;
import com.faith.demo.service.IMedicineService;
import com.faith.demo.service.IPrescriptonService;




@Controller
@RequestMapping("/prescription")
public class PrescriptionController {
	
	   @Autowired
		private IPrescriptonService presService;
	   
	   @Autowired
	   private IMedicineService medService;
	   
		// add form
	   @GetMapping("/home")
		public String showDashBoard(Model theModel) {
			
			return "checklog";
		}
	   
		@GetMapping("/showPris")
		public String showPris(Model theModel) {

		
	
			List<MedPres> theMed= presService.medPresImp();
			theModel.addAttribute("medpres", theMed);

			return "list-pres";

		}
		
		@GetMapping("/testdetailsofeach")
		 public String detailsForEach(@RequestParam("appoinmentId") int appId, Model themodel) {
		  
		  List<ViewPatientForOp>listOfEach=presService.detailsOfEachOp(appId);
		  
		  themodel.addAttribute("listEachPatient", listOfEach);
		 
		  String patreg=listOfEach.get(0).getPatient().getRegistrationNumber();
		  String patname=listOfEach.get(0).getPatient().getPatientName();
		  int patAge=listOfEach.get(0).getPatient().getPatientAge();
		  
		  themodel.addAttribute("patientReg", patreg);
		  themodel.addAttribute("patientName", patname);
		  themodel.addAttribute("patientAge", patAge);



		  
		  return "each-patient-op";
		  
		  
		 }
		@GetMapping("/bills")
		 public String bills(@RequestParam("appointmentId") int appId, Model themodel) {
			
			presService.removePv(appId);
			
			
			
			  List<ViewPatientForOp>billList=presService.detailsOfEachOp(appId);
			  
			  double bill=0;
			  double bill1=0;
			  int quantityinbil=0;
			  int qtys[] = new int[billList.size()];
			  double qtys1[] = new double[billList.size()];
			  Medicine med=null;
			  for(int i=0;i<billList.size();i++) {
				  
				  int days=billList.get(i).getMedicineprescription().getDays();
				  double price=billList.get(i).getMedicine().getPrice();
				  int qty=billList.get(i).getMedicineprescription().getDosage().getDosageQty();
				  //
				   med=billList.get(i).getMedicine();
				  
				  
				  bill=days*price*qty+bill;
				   quantityinbil= days*qty;
				   bill1=days*price*qty;
				   qtys[i] = quantityinbil;
				   qtys1[i]=bill1;
				  
				  }
			  int stockQty=billList.get(0).getMedicine().getQuantity();
			  if(stockQty>=quantityinbil) {
				  int stock=stockQty-quantityinbil;
				  med.setQuantity(stock);	
				  medService.saveMedicine(med);
			  }else if(stockQty<quantityinbil) {
				  med.setQuantity(0);
				  medService.saveMedicine(med);
			  }
			  
			  String nameofp=billList.get(0).getPatient().getPatientName();
			  String regNum=billList.get(0).getPatient().getRegistrationNumber();
			  
			  themodel.addAttribute("totalprice",bill);
			  themodel.addAttribute("quantiy",quantityinbil);
			  themodel.addAttribute("quant",qtys);

			  themodel.addAttribute("qtys1",qtys1);
			  themodel.addAttribute("billl",billList);
			  themodel.addAttribute("namep",nameofp);
			  themodel.addAttribute("regp",regNum);

			  
			  
			  System.out.println(bill);

			return "bill-form";
		}
		
		
		
}

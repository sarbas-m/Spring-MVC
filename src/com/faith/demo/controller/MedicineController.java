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
import com.faith.demo.entity.MedicineCompany;
import com.faith.demo.service.ICompanyService;
import com.faith.demo.service.IMedicineService;






@Controller
@RequestMapping("/medicine")
public class MedicineController {
	
	
	@Autowired
	private ICompanyService CompanyService;
	
	@Autowired
	private IMedicineService medicineService;
	
	
	@GetMapping("/pharmacy")
	public String showPharmacy(Model theModel) {
		
		return "checklog";

	}
	@GetMapping("/home")
	public String showDashBoard(Model theModel) {
		
		return "checklog";
	}

	/*
	 * @GetMapping("/showMedManage") public String showMedManage(Model theModel) {
	 * 
	 * return "medicineManage";
	 * 
	 * }
	 */
	// add form
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel) {

		// create model attribute cto bindform data
		Medicine theMedicine = new Medicine();

		// add customer to model
		theModel.addAttribute("medicines", theMedicine);

		theModel.addAttribute("companies", CompanyService.getCompany());
		
		
		return "medicine-form";

	}
	@PostMapping("/saveMedicine")
	public String saveMedicine(@ModelAttribute("medicines") Medicine theMedicine) {
		
		System.out.println(theMedicine.toString());

		// save the customer
		medicineService.saveMedicine(theMedicine);

		return "redirect:/medicine/lists";

	}
	
	@GetMapping("/searchByName")
	public String listBySearch(@RequestParam("medicineName") String theName,Model theModel) {
		
		List<Medicine> theMedicines = medicineService.searchByName(theName);
		
		theModel.addAttribute("medicines", theMedicines);
		
		
		return "list-medicine";
		
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("medicineId") int theId, Model theModel) {
		// create model attribute to bindform data
		Medicine theMedicine = medicineService.getmedicine(theId);

		// add customer to the model
		theModel.addAttribute("medicines", theMedicine);
		theModel.addAttribute("companies", CompanyService.getCompany());
		return "medicine-form";

	}
	 
	/*
	 * @GetMapping("/showFormDelete") public String
	 * showFormDelete(@RequestParam("medicineId") int theId) { // create model
	 * attribute to bindform data Medicine theMedicine =
	 * medicineService.searchById(theId);
	 * 
	 * //delete customer corresponding id by passing object
	 * medicineService.deleteMedicine(theMedicine);
	 * 
	 * return "redirect:/medicine/list";
	 * 
	 * }
	 */

	@GetMapping("/lists")
	public String listMedicine(Model theModel) {
		  
		List<Medicine> theMedicines = medicineService.getMedicine();
		theModel.addAttribute("medicines", theMedicines);

		return "list-medicines";

	}
	 @GetMapping("/search")
	 public String searchMedicine(@RequestParam("medicineId") int medicineId,Model theModel) {
	  Medicine theMedd=medicineService.searchMedicine(medicineId);
	  theModel.addAttribute("medicines", theMedd);
	  return "redirect:/medicine/lists";
	 }
	
	@GetMapping("/disable")
	 public String deleteMedicine(@RequestParam("medicineId")int medicineId) {
		medicineService.disableMedicine(medicineService.searchMedicine(medicineId));
		
	  return "redirect:/medicine/lists";
	  
	 }
	
	
	
		
	
}

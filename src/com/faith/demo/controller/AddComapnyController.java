package com.faith.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicineCompany;
import com.faith.demo.service.ICompanyService;


@Controller
@RequestMapping("/company")
public class AddComapnyController {

	
		
		@Autowired
		private ICompanyService companyService;
		
		@GetMapping("/pharmacy")
		public String showPharmacy(Model theModel) {
			
			return "checklog";
		}
		@GetMapping("/home")
		public String showDashBoard(Model theModel) {
			
			return "checklog";
		}

		
	/*
	 * @GetMapping("/showCompManage") public String showCompManage(Model theModel) {
	 * System.out.println("zsdasd"); return "companyManage";
	 * 
	 * }
	 */

		// add form
		
		@GetMapping("/showFormCom")
		public String showFormCom(Model theModel) {

			// create model attribute to bindform data
			MedicineCompany theCompany = new MedicineCompany();

			// add customer to model
			theModel.addAttribute("companys", theCompany);

			return "company-form";

		}
		@PostMapping("/saveCompany")
		public String saveCompany(@ModelAttribute("companyId") MedicineCompany theComp) {
			
			System.out.println(theComp.toString());

			// save the customer
			companyService.saveCompany(theComp);

			return "redirect:/company/listt";

		}
		@GetMapping("/listt")
		public String listMedicine(Model theModel) {
			  
			List<MedicineCompany> theMedicines = companyService.getCompany();
			theModel.addAttribute("companys", theMedicines);

			return "list-company";

		}
}


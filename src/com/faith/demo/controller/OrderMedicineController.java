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
import com.faith.demo.entity.MedicineOrder;
import com.faith.demo.service.ICompanyService;
import com.faith.demo.service.IMedicineService;
import com.faith.demo.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderMedicineController {
	
	@Autowired
	private ICompanyService CompanyService;
	
	
	@Autowired
	private IMedicineService MedService;
	
	
	@Autowired
	public IOrderService orderService;
	
	@GetMapping("/OrderCL")
	public String OrderCL(Model theModel) {
		return "companyManage";
		
		
	}
	@GetMapping("/home")
	public String showDashBoard(Model theModel) {
		
		return "checklog";
	}
	
	
	@GetMapping("/showOrder")
	public String showOrder(Model theModel) {

		// create model attribute to bindform data
		MedicineOrder theOrder = new MedicineOrder();
		
		theModel.addAttribute("companies", CompanyService.getCompany());

		theModel.addAttribute("medicines", MedService.getMedicine());
		// add customer to model
		theModel.addAttribute("orders", theOrder);

		return "order-form";
	}
	
	@PostMapping("/orderMedicine")
	public String saveOrder(@ModelAttribute("orders") MedicineOrder theOrder) {
		System.out.println("sadasf");
		System.out.println(theOrder.toString());

		// save the customer
		orderService.saveOrder(theOrder);

		return "redirect:/order/list";

	}
	@GetMapping("/list")
	public String listOrder(Model theModel) {
		  
		List<MedicineOrder> theMedicines = orderService.getCompany();
		theModel.addAttribute("orders", theMedicines);

		return "list-order";

}
}
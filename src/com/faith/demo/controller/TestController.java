package com.faith.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faith.demo.entity.Test;
import com.faith.demo.service.ITestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private ITestService testservice;
	
	@GetMapping("/frontpagebuttons")
	public String showFrontPage() {
		return "welcometesting";
		
		
	}

	@GetMapping("/showFormTest")
	public String showTestForm(Model themodel) {
		
		Test tester= new Test(); //null object created
		themodel.addAttribute("testing", tester);
		
		return "test-add-form";
		
		
	}
	
	@GetMapping("/saveTestForm")
	public String saveTest(@ModelAttribute("testing") Test tested) {
		
		testservice.saveTest(tested);
		
		return "redirect:/test/listTest";
		
		
	}
	@GetMapping("/listTest")
	public String listTests(Model themodel) {
		List<Test>listOfTests=testservice.getListTest();
		themodel.addAttribute("testLists", listOfTests);
		return "test-list";
		
	}
	@GetMapping("/showTestUpdateForm")
	public String updateTest(@RequestParam("testId") int updateId,Model themodel) {
		
		Test updatingTest=testservice.updateTests(updateId);
		themodel.addAttribute("testing", updatingTest);
		return "test-add-form";
		
		
	}
	@GetMapping("/delete")
	public String deleteTest(@RequestParam("testId") int deleteId) {
		testservice.deletingTest(deleteId);
		return "redirect:/test/listTest";
		
	}
	@GetMapping("/searchTest")
	public String searchTheTest(@RequestParam("searchName") String sername, Model themodel) {
		
		List<Test>searchedTest=testservice.searchingTest(sername);
		themodel.addAttribute("testLists", searchedTest);
		return "test-list";
		
	}
}

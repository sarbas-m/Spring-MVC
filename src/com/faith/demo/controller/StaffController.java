package com.faith.demo.controller;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Staff;
import com.faith.demo.service.StaffServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffServiceImple staffService;

    @GetMapping("/list")
    public String listStaff(Model model) {
        List<Staff> staffList = staffService.getAllStaff();
        model.addAttribute("staffList", staffList);
        return "liststaff";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Staff staff = new Staff();
        model.addAttribute("staffs", staff);
        int userId=staffService.getUserIdFromDb();
        
        model.addAttribute("userId", userId);
        
        model.addAttribute("staff", staff);
        return "addstaff";
    }

    @PostMapping("/save")
    public String addStaff(@ModelAttribute("staff") Staff staff) {
        LocalDate newDate = staff.getStaffDateOfBirth().plusDays(1);
        System.out.println(staff);
        staff.setStaffDateOfBirth(newDate);
        staffService.addStaff(staff);
        return "redirect:/staff/list";
    }

    @GetMapping("/edit")
    	public String showEditForm(@RequestParam("staffId") int staffid, Model model) {
    	Staff staff = staffService.getStaffById(staffid);
    	model.addAttribute("staffs", staff);
    	return "addstaff";
    }

   @PostMapping("/edited")
   		public String updateStaff(@ModelAttribute("staff") Staff staff ) {
	   	staffService.updateStaff(staff);
	   	return "redirect:/staff/list";
    }
    
 
    

    @GetMapping("/delete")
    public String deleteStaff(@ModelAttribute("id") int id) {
       staffService.deleteStaff(id);
        return "redirect:/staff/list";
    }
    
    @GetMapping("/disable")
    public String disableStaff(@RequestParam("staffId") int staffId) {
    
        staffService.disableStaff(staffId);
        return "redirect:/staff/list";
    }
}

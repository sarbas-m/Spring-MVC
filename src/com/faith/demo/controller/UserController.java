package com.faith.demo.controller;

import com.faith.demo.entity.Staff;
import com.faith.demo.entity.User;
import com.faith.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "listuser";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "adduser";
    }
    @GetMapping("/adddoc")
    public String showAddForms(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "adddocusernew";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        
        return "redirect:/staff/add";
    }
    @PostMapping("/saves")
    public String addUserDoc(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/doctor/add";
    }
    
/*
 * @GetMapping("/edit")
    public String showEditForm(@RequestParam("staffId") int id, Model model) {
   
    	
        Staff staff = staffService.getStaffById(id);
       
        model.addAttribute("staffs", staff);
        return "addstaff";
    }

   @PostMapping("/edited")
    public String updateStaff(@ModelAttribute("id") int id, @ModelAttribute("staffs") Staff staff) {
        staff.setStaffId(id);
        staffService.updateStaff(staff);
        return "redirect:/staff/list";
 * 
 */
    
    
    
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "adduser";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("id") int id, @ModelAttribute("user") User user) {
    	user.setUserId(id);
        userService.updateUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }
}
